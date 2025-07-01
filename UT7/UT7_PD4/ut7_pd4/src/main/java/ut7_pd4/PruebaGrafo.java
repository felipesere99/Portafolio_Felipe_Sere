package ut7_pd4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "src/main/java/uy/edu/ucu/aed/utils/aeropuertos.txt",
                "src/main/java/uy/edu/ucu/aed/utils//conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : "
                    + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();

        TCaminos caminos = gd.todosLosCaminos("Montevideo", "Porto_Alegre");

        System.out.println("Caminos desde Montevideo hasta Porto_Alegre:");
        for (TCamino camino : caminos.getCaminos()) {
            System.out.println("Camino: " + camino.imprimirEtiquetas());
            System.out.println("Costo total: " + camino.getCostoTotal());
        }
        System.out.println();

        System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        Collection<TVertice> vertices = new ArrayList<>();
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        TVertice verticeD = new TVertice("D");

        TArista aristaAB = new TArista("A", "B", 5.0);
        TArista aristaAC = new TArista("A", "C", 10.0);
        TArista aristaBD = new TArista("B", "D", 3.0);
        TArista aristaCD = new TArista("C", "D", 2.0);

        Collection<IVertice> vertice = new ArrayList<>();
        vertice.add(verticeA);
        vertice.add(verticeB);
        vertice.add(verticeC);
        vertice.add(verticeD);

        Collection<IArista> aristas = new ArrayList<>();
        aristas.add(aristaAB);
        aristas.add(aristaAC);
        aristas.add(aristaBD);
        aristas.add(aristaCD);

        TGrafoDirigido grafo = new TGrafoDirigido(vertice, aristas);

        // Insertar una arista adicional
        grafo.insertarArista(new TArista("B", "C", 7.0));

        // Verificar la existencia de un vértice y una arista
        System.out.println("Existe el vértice A: " + grafo.existeVertice("A"));
        System.out.println("Existe la arista de A a B: " + grafo.existeArista("A", "B"));

        // recorrido en profundidad (BPF) desde un vértice específico
        LinkedList<TVertice> recorridoBPF = grafo.bpf("A");
        System.out.println("Recorrido BPF desde A:");
        for (TVertice v : recorridoBPF) {
            System.out.print(v.getEtiqueta() + " ");
        }
        System.out.println();

        // Crea un camino y agrega  adyacencias
        TCamino camino = new TCamino(verticeA);
        camino.agregarAdyacencia(new TAdyacencia(5.0, verticeB));
        camino.agregarAdyacencia(new TAdyacencia(3.0, verticeD));


        //costo total del camino
        System.out.println("Costo total del camino A -> B -> D: " + camino.getCostoTotal());

        //algoritmo de Floyd para calcular la matriz de costos mínimos
        Double[][] matrizCostos = grafo.floyd();
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                System.out.print((matrizCostos[i][j] == Double.MAX_VALUE ? "INF" : matrizCostos[i][j]) + "\t");
            }
            System.out.println();
        }

        // Warshall para verificar la conectividad
        boolean[][] matrizWarshall = grafo.warshall();
        System.out.println("Matriz de conectividad (Warshall):");
        for (int i = 0; i < matrizWarshall.length; i++) {
            for (int j = 0; j < matrizWarshall.length; j++) {
                System.out.print((matrizWarshall[i][j] ? "1" : "0") + "\t");
            }
            System.out.println();
        }

        System.out.println("Tiene ciclo? " + gd.tieneCiclo());
    }
}
