package aed;

import static java.lang.Double.min;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Ernesto
 */
public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     *         contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    @Override
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if (!existeVertice(unaEtiqueta)) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Comparable etiquetaCentro = "";
        Comparable excentricidadCentro = Double.MAX_VALUE;
        Comparable excentricidadActual = 0;
        for (Comparable v : this.vertices.keySet()) {
            excentricidadActual = this.obtenerExcentricidad(v);
            if (excentricidadActual.compareTo(excentricidadCentro) < 0) {
                excentricidadCentro = excentricidadActual;
                etiquetaCentro = v;
            }
        }
        return etiquetaCentro;
    }

    @Override
    public Double[][] floyd() {
        Double[][] a = UtilGrafos.obtenerMatrizCostos(getVertices());
        for (int k = 0; k < this.vertices.size(); k++) {
            for (int i = 0; i < this.vertices.size(); i++) {
                if (k == i) {
                    continue; // diagonal
                }
                for (int j = 0; j < this.vertices.size(); j++) {
                    if (i == j || j == k) {
                        continue; // columna o fila
                    }
                    a[i][j] = min(a[i][k] + a[k][j], a[i][j]);
                }
            }
        }
        return a;

    }

    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] a = this.floyd();
        int cont = 0;
        double caminoMasLargo = 0;
        if (vertices.containsKey(etiquetaVertice)) {
            for (Comparable v : vertices.keySet()) {
                if (v.equals(etiquetaVertice)) {
                    break;
                }
                cont++;
            }
            for (int i = 0; i < this.vertices.size(); i++) {
                if (a[i][cont] > caminoMasLargo) {
                    caminoMasLargo = a[i][cont];
                }
            }
            return caminoMasLargo;
        }
        return -1; // NO EXISTE EL VÉRTICE
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public LinkedList<TVertice> bpf() {
        desvisitarVertices();
        LinkedList<TVertice> res = new LinkedList<>();
        for (TVertice v : this.vertices.values()) {
            if (!v.getVisitado()) {
                v.bpf(res);
            }
        }
        desvisitarVertices();
        return res;
    }

    @Override
    public LinkedList<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> res = new LinkedList<>();
        TVertice v = this.buscarVertice(etiquetaOrigen);
        if (v != null) {
            v.bpf(res);
        }
        desvisitarVertices();
        return res;
    }

    @Override
    public LinkedList<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        LinkedList<TVertice> res = new LinkedList<>();
        if (this.buscarVertice(vertice.getEtiqueta()) != null) {
            vertice.bpf(res);
        }
        desvisitarVertices();
        return res;
    }

   @Override
    public void desvisitarVertices() {
        for (TVertice v : this.vertices.values()) {
            v.setVisitado(false);
        }
    }

}
