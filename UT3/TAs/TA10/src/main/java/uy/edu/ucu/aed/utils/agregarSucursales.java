package uy.edu.ucu.aed.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.LinkedList;


public class agregarSucursales {

    LinkedList<Sucursal> listaSucursales = new LinkedList<>();

    public void cargarSucursal(String nuevaSucursal) {
        listaSucursales.add(new Sucursal(nuevaSucursal));
        System.out.println("Agregado la nueva sucursal " + nuevaSucursal);
    
    }
    
}
