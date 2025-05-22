package ut3_pd6;

import java.util.LinkedList;

public class Main {
    public static void main(String args[]) {

        LinkedList<Sucursal> list = new LinkedList<Sucursal>();
        ManejadorArchivosGenerico archivo = new ManejadorArchivosGenerico();
        String path = "C:\\AED\\UT3\\UT3_EJERCICIOS_DOMICILIARIOS\\UT3_PD6\\ut3_pd6\\src\\main\\resources\\suc1.txt";

        String[] lista = archivo.leerArchivo(path);
        
        for(String ciudad: lista){
            agregarSucursales.cargarSucursal(ciudad, list);
        }
        

        
        /*Descargar el archivo “suc1.txt”, guardarlo en el directorio raíz de su implementación como “sucursales.txt” y
            ejecutar el programa, emitiendo por consola la cantidad de elementos y la lista de ciudades contenida en la
            estructura. La cantidad de elementos es:
            a) 104
            b) 105
            c) 106
            d) 107 */
        System.out.println("Parte 1: " + cantidadSucursales.cantSucursales(list));


        /*2. Eliminar la ciudad “Chicago”- listar nuevamente el conjunto de sucursales. Dada la ciudad ·“Hong Kong”, la
            que le sigue en la lista es la ciudad ….
            a) Buenos Aires
            b) Tokio
            c) Shenzhen
            d) Cleveland
            */

        quitarSucursal.quitarSucursal(list, new Sucursal("Chicago"));

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNombre().equals("Hong Kong")){
                System.out.println("Parte 2 :" + list.get(i+1).getNombre());
            }
        }



        buscarSucursal buscarSucursal = new buscarSucursal();
        String ciudad = "Seul";
        buscarSucursal.buscadorSucursales(list, ciudad);


        /* String Quitar = "Tokio";
        quitarSucursal quitarUnaSucursal = new quitarSucursal();
        quitarUnaSucursal.quitarSucursal(list,Quitar);
 */
        /* listarSucursal listar = new listarSucursal();
        listar.listarSucursales(list);
 */



    }
}