package ut7_pd4;

import java.net.CookieManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {
    protected TAristas lasAristas = new TAristas() ;
           /**
         *
         * @param vertices
         * @param aristas
         */
        public TGrafoNoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
           super(vertices, aristas);     
          lasAristas.insertarAmbosSentidos(aristas);
           
        }


        @Override
        public boolean insertarArista(IArista arista) {
            boolean tempbool = false;
            TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
            tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
            return tempbool;
        }
        
        public TAristas getLasAristas() {
            return lasAristas;
        }
     
    
     
        @Override
        public TGrafoNoDirigido Prim() {
            Collection<Comparable> U = new ArrayList<>();
            Collection<Comparable> V = new ArrayList<>();
            Collection<IArista> AristasAAM = new ArrayList<>();
            double costoPrim = 0;
    
            for (IVertice vertice : this.getVertices().values()) {
                V.add(vertice.getEtiqueta());
            }
    
            U.add(V.iterator().next());
            V.remove(V.iterator().next());
    
            while (V.size() != 0) {
                TArista tempArista = this.lasAristas.buscarMin(U, V);
                AristasAAM.add(tempArista);
                V.remove(tempArista.getEtiquetaDestino());
                U.add(tempArista.getEtiquetaDestino());
                costoPrim += tempArista.getCosto(); 
            }
    
            Collection<IVertice> VerticesSeleccionados = new ArrayList<>();
    
            for (Comparable vertice : U) {
                VerticesSeleccionados.add(new TVertice<>(vertice));
            }
    
            return new TGrafoNoDirigido(VerticesSeleccionados, AristasAAM);
        }
    
        @Override
        public TGrafoNoDirigido Kruskal() {
            TAristas aristas = new TAristas();
            aristas.addAll(this.lasAristas);
            List<IArista> F = new LinkedList<>();
            Map<Comparable, Integer> componentes = new HashMap<>();
            int i = 1;
            for (Comparable etiqueta : getVertices().keySet()) {
                componentes.put(etiqueta, i);
                i++;
            }
            while (F.size() < getVertices().size() - 1) {
                TArista arista = aristas.buscarAristaMinima();
                aristas.remove(arista);
                int compOrigen = componentes.get(arista.getEtiquetaOrigen());
                int compDestino = componentes.get(arista.getEtiquetaDestino());

                if (compOrigen != compDestino) {
                    F.add(arista);
                    for (Comparable c : componentes.keySet()) {
                        componentes.replace(c, compOrigen, compDestino);
                    }
                }
            }
            return new TGrafoNoDirigido(getVertices().values(), F);
            
        }
    
        @Override
        public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        TVertice v = (TVertice) buscarVertice(etiquetaOrigen);
        if (v == null) {
            return null;
        }
        return bea(v);
        }

        public Collection<TVertice> bea(TVertice vertice) {
        if (vertice == null) {
            return null;
        }
        List<TVertice> result = new LinkedList<>();
        vertice.bea(result);
        return result;
        }

        @Override
        public Collection<TVertice> bea() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'bea'");
        }

        @Override
        public int numBacon(Comparable actor) {
            desvisitarVertices();
            TVertice verticeBacon = null;

            for (IVertice vertice : getVertices().values()) {
                if (vertice.getEtiqueta().compareTo("Kevin_Bacon") == 0) {
                    verticeBacon = (TVertice) vertice;
                    break; 
                }
            }

            // si el que se busca no esta en el grafo
            if (verticeBacon == null) {
                System.out.println("El vértice 'Kevin_Bacon' no se encuentra en el grafo.");
                return -1;
            }

            // Si el actor es el propio Kevin_Bacon, se devuelve 0 por deafult
            if (actor.compareTo("Kevin_Bacon") == 0) {
                return 0;
            }

            return verticeBacon.numBacon(actor);
        }
            
    }
    