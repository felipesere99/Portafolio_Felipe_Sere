package ut3_pd4.interfacesYUtilTA2;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen("Almacenardo", "8 de Octubre", "098765432");
        String archString = "C:\\AED\\UT3\\UT3_EJERCICIOS_DOMICILIARIOS\\PD4\\ut3_pd4\\src\\main\\java\\ut3_pd4\\interfacesYUtilTA2\\archivos almacen\\altas.txt";
        Ejercicio1.actualizarAlmacenDesdeArchivo(almacen, archString);
        System.out.println(almacen.listaProductos.primero.dato.getNombre());

        System.out.println(almacen.listaProductos.primero.dato.getStock());

        String archString2 = "C:\\AED\\UT3\\UT3_EJERCICIOS_DOMICILIARIOS\\PD4\\ut3_pd4\\src\\main\\java\\ut3_pd4\\interfacesYUtilTA2\\archivos almacen\\ventas.txt";

        Ejercicio2.procesarVentas(almacen, archString2);
        System.out.println(almacen.listaProductos.primero.dato.getStock());
    }
}