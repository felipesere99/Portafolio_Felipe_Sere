package aed;

public class Main {
    public static void main(String[] args) {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        TClasificador clasificador = new TClasificador();
        int[] datosAleatorios = generador.generarDatosAleatorios();
        int[] datosAscendentes = generador.generarDatosAscendentes();
        int[] datosDescendentes = generador.generarDatosDescendentes();

        System.out.println("Datos aleatorios");
        // clasificador.ordenarPorShell(datosAleatorios);
        // clasificador.ordenarPorInsercion(datosAleatorios);
        // clasificador.ordenarPorBurbuja(datosAleatorios);
        clasificador.ordenarPorQuickSort(datosAleatorios);
        System.out.println("Datos ascendentes");
        // clasificador.ordenarPorShell(datosAscendentes);
        // clasificador.ordenarPorInsercion(datosAscendentes);
        // clasificador.ordenarPorBurbuja(datosAscendentes);
        clasificador.ordenarPorQuickSort(datosAscendentes);
        System.out.println("Datos descendentes");
        // clasificador.ordenarPorShell(datosDescendentes);
        // clasificador.ordenarPorInsercion(datosDescendentes);
        // clasificador.ordenarPorBurbuja(datosDescendentes);
        clasificador.ordenarPorQuickSort(datosDescendentes);
    }
}