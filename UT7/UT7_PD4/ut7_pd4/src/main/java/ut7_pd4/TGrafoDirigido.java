package ut7_pd4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, IVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        for (IVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            IVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        IVertice vertOrigen = buscarVertice(etiquetaOrigen);
        IVertice vertDestino = buscarVertice(etiquetaDestino);
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
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     *         contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    public IVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            IVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(IVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, IVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        double minEccentricity = Double.MAX_VALUE;
        Comparable center = null;

        for (Comparable etiquetaVertice : vertices.keySet()) {
            int eccentricity = (int) obtenerExcentricidad(etiquetaVertice);
            if (eccentricity != -1 && eccentricity < minEccentricity) {
                minEccentricity = eccentricity;
                center = etiquetaVertice;
            }
        }

        return center;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        int numVertices = matrizCostos.length;
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (matrizCostos[i][k] != Double.MAX_VALUE && matrizCostos[k][j] != Double.MAX_VALUE) {
                        matrizCostos[i][j] = Math.min(matrizCostos[i][j], matrizCostos[i][k] + matrizCostos[k][j]);
                    }
                }
            }
        }

        return matrizCostos;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matrizCostos = floyd();
        List<Comparable> keys = new ArrayList<>(vertices.keySet());
        int index = keys.indexOf(etiquetaVertice);
        double maxCost = Double.MIN_VALUE;

        for (int j = 0; j < matrizCostos.length; j++) {
            if (matrizCostos[index][j] != Double.MAX_VALUE) {
                maxCost = Math.max(maxCost, matrizCostos[index][j]);
            }
        }
        return maxCost == Double.MIN_VALUE ? -1 : (int) maxCost;
    }

    public boolean[][] warshall() {
        Double[][] matriz = floyd();
        boolean[][] reach = new boolean[vertices.size()][vertices.size()];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < Double.MAX_VALUE) {
                    reach[i][j] = true;
                } else {
                    reach[i][j] = false;
                }
            }
            reach[i][i] = true;
        }

        for (int k = 0; k < matriz.length; k++) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);
                }
            }
        }

        return reach;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            IVertice vertice = vertices.remove(nombreVertice);
            if (vertice != null) {
                for (IVertice v : vertices.values()) {
                    v.eliminarAdyacencia(nombreVertice);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void desvisitarVertices() {
        for (IVertice vertice : vertices.values()) {
            vertice.setVisitado(false); // Resetea el estado de visitado en cada vértice
        }
    }

    @Override
    public LinkedList<TVertice> bpf() {
        desvisitarVertices();
        LinkedList<TVertice> res = new LinkedList<>();
        for (IVertice v : this.vertices.values()) {
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
        IVertice v = this.buscarVertice(etiquetaOrigen);
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
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        IVertice verticeOrigen = buscarVertice(etiquetaOrigen);

        if (verticeOrigen != null) {
            TCamino caminoInicial = new TCamino((TVertice) verticeOrigen);
            verticeOrigen.todosLosCaminos(etiquetaDestino, caminoInicial, todosLosCaminos);
        }
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
        boolean res = false;
        
        for (IVertice vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                LinkedList camino = new LinkedList();
                camino.add(vertV.getEtiqueta());
                res = vertV.tieneCiclo(camino);
                if(res){
                    return true;
                }
            }
        }
        return res;
    }
}
