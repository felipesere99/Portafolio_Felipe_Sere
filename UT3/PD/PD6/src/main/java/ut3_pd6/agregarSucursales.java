package ut3_pd6;
import java.util.LinkedList;


public class agregarSucursales {
    public static void cargarSucursal(String nuevaSucursal, LinkedList lista) {
        lista.add(new Sucursal(nuevaSucursal));
        //System.out.println("Agregado la nueva sucursal " + nuevaSucursal);
    
    }
    
}
