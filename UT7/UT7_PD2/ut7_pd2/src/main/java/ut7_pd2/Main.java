package ut7_pd2;

public class Main {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("ut7_pd2\\src\\main\\java\\ut7_pd2\\PD2vertices.txt", "ut7_pd2\\src\\main\\java\\ut7_pd2\\PD2conexiones.txt",
               false, TGrafoDirigido.class);

       Object[] etiquetasarray = gd.getEtiquetasOrdenado();

       Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
       UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
       Double[][] matrizFloyd = gd.floyd();
       UtilGrafos.imprimirMatrizMejorado(matrizFloyd, gd.getVertices(), "Matriz luego de FLOYD");
       for (int i = 0; i < etiquetasarray.length; i++) {
           System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
       }
       System.out.println();
       System.out.println("Centro del grafo: " + gd.centroDelGrafo());
   }
}