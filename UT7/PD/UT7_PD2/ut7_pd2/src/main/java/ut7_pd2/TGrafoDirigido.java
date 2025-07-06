package ut7_pd2;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

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
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
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
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
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
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
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
    private TVertice buscarVertice(Comparable unaEtiqueta) {
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
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
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
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
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
        Map<Comparable, TVertice> vertices = getVertices();
        LinkedList<Comparable> listaVertices = new LinkedList<Comparable>();
        LinkedList<Comparable> excentricidades = new LinkedList<Comparable>();

        for (Map.Entry<Comparable, TVertice> entry : vertices.entrySet()) {
            listaVertices.add(entry.getKey());
            excentricidades.add(obtenerExcentricidad(entry.getKey()));
        }
        LinkedList<Comparable> excentricidadesAux = (LinkedList<Comparable>) excentricidades.clone();
        Double menosUno = -1.d;
        while (excentricidadesAux.contains(menosUno)) {
            excentricidadesAux.remove(menosUno);
        }
        Comparable centro = excentricidadesAux.getFirst();
        for (Comparable excentricidad : excentricidadesAux) {
            if (centro.compareTo(excentricidad) > 0) {
                centro = excentricidad;
                System.out.println(centro.toString());
            }
        }
        int indice = excentricidades.indexOf(centro);
        centro = listaVertices.get(indice);
        return centro;
        
    }

    @Override
    public Double[][] floyd() {
        int tamMatriz = vertices.size();
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        Double[][] matrizFloyd = new Double[tamMatriz][tamMatriz];
        Double[][] camino = new Double[tamMatriz][tamMatriz];
        for (int i = 0; i < tamMatriz; i++) {
            for (int j = 0; j < tamMatriz; j++) {
                matrizFloyd[i][j] = matrizCostos[i][j];
                camino[i][j] = 0.d;
            }
        }
        for (int i = 0; i < tamMatriz; i++) {
            matrizFloyd[i][i] = 0.d;
        }
        for (int k = 0; k < tamMatriz; k++) {
            for (int i = 0; i < tamMatriz; i++) {
                for (int j = 0; j < tamMatriz; j++) {
                    if (matrizFloyd[i][k] + matrizFloyd[k][j] < matrizFloyd[i][j]) {
                        matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                        camino[i][j] = (double) k;
                    }
                }
            }
        }
        return matrizFloyd;
    }

    public Double[][] recuperarCaminos(Double[][] camino) {
        int tamanio = vertices.size();
        Double[][] costos = UtilGrafos.obtenerMatrizCostos(vertices);
        Double[][] matriz = new Double[tamanio][tamanio];

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                matriz[i][j] = costos[i][j];
                camino[i][j] = 0.d;
            }
        }
        for (int i = 0; i < tamanio; i++) {
            matriz[i][i] = 0.d;
        }
        for (int k = 0; k < tamanio; k++) {
            for (int i = 0; i < tamanio; i++) {
                for (int j = 0; j < tamanio; j++) {
                    if (matriz[i][k] + matriz[k][j] < matriz[i][j]) {
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                        camino[i][j] = (double) k;
                    }
                }
            }
        }
        return matriz;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        int tamanio = vertices.size();
        Double max = 0.d;
        Double[][] matriz = floyd();
        Set<Comparable> etiquetasVertices = vertices.keySet();
        int posicion = 0;

        for (Comparable i : etiquetasVertices) {
            if (etiquetaVertice.equals(i)) {
                break;
            }
            posicion++;
        }
        for (int i = 0; i < tamanio; i++) {
            if (matriz[i][posicion] > max) {
                max = matriz[i][posicion];
            }
        }
        if (max == Double.MAX_VALUE) {
            //max = Double.POSITIVE_INFINITY;
            max = -1.d;
        }
        return max;
    }

    @Override
    public boolean[][] warshall() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] matrizWarshall = new boolean[matrizCostos.length][matrizCostos.length];
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                matrizWarshall[i][j] = false;

                if (i != j && matrizCostos[i][j] != Integer.MAX_VALUE) {
                    matrizWarshall[i][j] = true;
                }
            }
        }
        for (int k = 0; k < matrizWarshall.length; k++) {
            for (int i = 0; i < matrizWarshall.length; i++) {
                for (int j = 0; j < matrizWarshall.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!matrizWarshall[i][j]) {
                            matrizWarshall[i][j] = matrizWarshall[i][k] && matrizWarshall[k][j];
                        }
                    }
                }
            }
        }
        return matrizWarshall;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }
    
    public boolean tieneCiclo() {
        if (this.vertices.isEmpty()) {
            LinkedList<Comparable> camino = new LinkedList<Comparable>();
            for (TVertice vertice : this.vertices.values()) {
                vertice.tieneCiclo(camino);
            }
            if (camino.size() != 0) {
                return true;
            }
        }
        return false;
    }
    
}
