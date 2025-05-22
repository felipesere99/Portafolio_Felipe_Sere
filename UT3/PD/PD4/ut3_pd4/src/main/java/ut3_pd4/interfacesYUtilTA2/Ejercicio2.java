package ut3_pd4.interfacesYUtilTA2;

public class Ejercicio2 {
     public static void procesarVentas(Almacen almacen, String archivo){
       
            String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
            double valorTotalReducido = 0;
    
            for (String linea : lineas) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    try {
                        Comparable codProducto = datos[0].trim();
                        Integer cantidad = Integer.parseInt(datos[1].trim());
    
                        Integer stockRestante = almacen.restarStock(codProducto, cantidad);
                        if (stockRestante != null) {
                            double precioUnitario = almacen.buscarPorCodigo(codProducto).getPrecio();
                            valorTotalReducido += (precioUnitario * (cantidad - stockRestante));
                        } else {
                            System.out.println("Producto con código " + codProducto + " no encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error al procesar los datos numéricos en la línea: " + linea);
                    }
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
    
            System.out.printf("Monto total reducido en el valor del stock: %.2f%n", valorTotalReducido);
            System.out.println("Procesamiento de ventas completado.");
        
    }
}
