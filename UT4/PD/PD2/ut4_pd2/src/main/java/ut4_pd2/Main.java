package ut4_pd2;

public class Main {
    public static void main(String[] args) {
        String nombreCompletoArchivo = "C:\\AED\\UT4\\UT4_PD\\UT4_PD2\\ut4_pd2\\src\\main\\resources\\clavesPrueba.txt";
        String[] arbolDatos = ManejadorArchivosGenerico.leerArchivo(nombreCompletoArchivo);
        TArbolBB arbolBB = new TArbolBB<>();
        for (String elem : arbolDatos) {
            Integer valor = Integer.parseInt(elem);
            arbolBB.insertar(new TElementoAB<>(valor, valor));
        }
        
        String resultadoInOrden = arbolBB.inOrden();
        String[] arregloIn = resultadoInOrden.split("-");
        String archivoResultadoIn = "C:\\AED\\UT4\\UT4_PD\\UT4_PD2\\ut4_pd2\\src\\main\\resources\\clavesResultadoInorden.txt";
        ManejadorArchivosGenerico.escribirArchivo(archivoResultadoIn, arregloIn);
        
        
        String resultadoPosOrden = arbolBB.postOrden();
        String[] arregloPos = resultadoPosOrden.split("-");
        String archivoResultadoPos = "C:\\AED\\UT4\\UT4_PD\\UT4_PD2\\ut4_pd2\\src\\main\\resources\\clavesResultadoPosorden.txt";
        ManejadorArchivosGenerico.escribirArchivo(archivoResultadoPos, arregloPos);

        String resultadoPreOrden = arbolBB.preOrden();
        String[] arregloPre = resultadoPreOrden.split("-");
        String archivoResultadoPre = "C:\\AED\\UT4\\UT4_PD\\UT4_PD2\\ut4_pd2\\src\\main\\resources\\clavesResultadoPreorden.txt";
        ManejadorArchivosGenerico.escribirArchivo(archivoResultadoPre, arregloPre);
    }
}