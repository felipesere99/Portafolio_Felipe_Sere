
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ocamp
 */
public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }


    @Override
    public TAristas mejorRedElectrica() {
        // Crear un conjunto de vértices y un conjunto de aristas
        Collection<TVertice> vertices = getVertices().values();
        Collection<TArista> aristas = getAristasCollection();

        // Crear un conjunto de aristas ordenadas por costo
        List<TArista> aristasOrdenadas = new ArrayList<>(aristas);
        Collections.sort(aristasOrdenadas, Comparator.comparingDouble(TArista::getCosto));

        // Crear un conjunto de componentes conexas
        Map<TVertice, TVertice> componentesConexas = new HashMap<>();
        for (TVertice vertice : vertices) {
            componentesConexas.put(vertice, vertice);
        }

        // Crear un conjunto de aristas del MST
        TAristas mstAristas = new TAristas();

        // Iterar sobre las aristas ordenadas por costo
        for (TArista arista : aristasOrdenadas) {
            TVertice verticeOrigen = (TVertice) arista.getEtiquetaOrigen();
            TVertice verticeDestino = (TVertice) arista.getEtiquetaDestino();

            // Verificar si los vértices están en componentes conexas diferentes
            if (!componentesConexas.get(verticeOrigen).equals(componentesConexas.get(verticeDestino))) {
                // Agregar la arista al MST
                mstAristas.add(arista);

                // Unir las componentes conexas
                TVertice componenteOrigen = componentesConexas.get(verticeOrigen);
                TVertice componenteDestino = componentesConexas.get(verticeDestino);
                for (TVertice vertice : vertices) {
                    if (componentesConexas.get(vertice).equals(componenteDestino)) {
                        componentesConexas.put(vertice, componenteOrigen);
                    }
                }
            }
        }

        return mstAristas;
    }

    private boolean esConexo(TAristas mstAristas) {
        // Verificar que todos los vértices estén en el mismo componente conexo
        TVertice verticeInicial = (TVertice) mstAristas.iterator().next().getEtiquetaOrigen();
        Set<TVertice> visitados = new HashSet<>();
        visitados.add(verticeInicial);

        Queue<TVertice> cola = new LinkedList<>();
        cola.add(verticeInicial);

        while (!cola.isEmpty()) {
            TVertice verticeActual = cola.poll();
            for (Object obj : verticeActual.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) obj;
                TVertice verticeVecino = adyacencia.getDestino();
                if (!visitados.contains(verticeVecino)) {
                    visitados.add(verticeVecino);
                    cola.add(verticeVecino);
                }
            }
        }

        return visitados.size() == getVertices().size();
    }
}