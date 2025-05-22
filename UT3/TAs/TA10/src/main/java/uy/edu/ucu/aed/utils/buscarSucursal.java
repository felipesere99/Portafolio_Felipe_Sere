package uy.edu.ucu.aed.utils;

import java.util.LinkedList;

public class buscarSucursal {
    
    public static void buscadorSucursales(LinkedList lista, String ciudad) {

        Boolean resultado = false;


        for (Object elem : lista) {
            if (elem.equals(ciudad)) {
                resultado = true;
                break;
            }
        }

        System.out.println("En la ciudad " + ciudad + " se encuentra una sucursal? " + resultado);
    }
}
