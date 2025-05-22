package uy.edu.ucu.aed.utils;

import java.util.LinkedList;

public class listarSucursal {
    
    public void listarSucursales(LinkedList lista) {
        int cant = lista.size();
        for (int i = 0; i < cant; i++) {
            System.out.println(lista.get(i));
        }
    }
    
}
