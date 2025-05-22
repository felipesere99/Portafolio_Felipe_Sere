package uy.edu.ucu.aed.utils;

import java.util.LinkedList;

public class quitarSucursal {

    public void quitarSucursal(LinkedList lista, String ciudad) {
        lista.remove(ciudad);
        System.out.println("La sucursal de la ciudad: "+ ciudad +"ha sido eliminada.");
    }

    
}
