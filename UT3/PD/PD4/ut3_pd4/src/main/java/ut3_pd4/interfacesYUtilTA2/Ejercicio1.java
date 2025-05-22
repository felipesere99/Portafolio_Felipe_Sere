package ut3_pd4.interfacesYUtilTA2;

public class Ejercicio1 {
    public static void actualizarAlmacenDesdeArchivo(Almacen almacen, String archivo){
        
            String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
            double valorTotalIncrementado = 0;

            for (String linea : lineas) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    try {
                        Comparable codProducto = datos[0].trim();
                        String nombre = datos[1].trim();
                        Integer precio = Integer.parseInt(datos[2].trim());
                        Integer cantidad = Integer.parseInt(datos[3].trim());

                        Producto producto = new Producto(codProducto, nombre, precio, cantidad);
                        if (almacen.buscarPorCodigo(codProducto) != null) {
                            almacen.agregarStock(codProducto, cantidad);
                        } else {
                            almacen.insertarProducto(producto);
                        }

                        valorTotalIncrementado += precio * cantidad;
                    } catch (NumberFormatException e) {
                        System.out.println("Error al procesar los datos numéricos en la línea: " + linea);
                    }
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }

            System.out.printf("Monto total incrementado en el valor del stock: %.2f%n", valorTotalIncrementado);
            System.out.println("Actualización del almacén completada.");
    }
}
