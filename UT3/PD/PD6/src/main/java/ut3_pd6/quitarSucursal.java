package ut3_pd6;

import java.util.LinkedList;

public class quitarSucursal {

    public static void quitarSucursal(LinkedList<Sucursal> lista, Sucursal sucursal) {
        String sucursalABorrar = sucursal.getNombre();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNombre().equals(sucursalABorrar)){
                lista.remove(i);
                System.out.println("La sucursal de la ciudad: "+ sucursalABorrar +" ha sido eliminada.");
            }
        }
        
    }
}
