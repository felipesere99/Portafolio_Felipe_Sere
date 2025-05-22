package uy.edu.ucu.aed.utils;

import java.util.LinkedList;

public class main {
    public static void main(String args[]) {

        System.out.println(" UT3 _ TA 10 ");
        LinkedList list = new LinkedList<String>();
        ManejadorArchivosGenerico archivo = new ManejadorArchivosGenerico();
        String path = "C:\\Users\\alfon\\Desktop\\ut3-ta10-m301-equipo-4\\src\\main\\java\\uy\\edu\\ucu\\aed\\utils\\suc1.txt";

        String[] lista = archivo.leerArchivo(path);
        agregarSucursales agregarCiudad = new agregarSucursales();
        agregarCiudad.cargarSucursal("Rivera");

        for(String ciudad: lista){
            agregarCiudad.cargarSucursal(ciudad);
        }

        for (Object elem : lista) {
            list.add(elem);
        }

        buscarSucursal buscarSucursal = new buscarSucursal();
        String ciudad = "Seul";
        buscarSucursal.buscadorSucursales(list, ciudad);


        String Quitar = "Tokio";
        quitarSucursal quitarUnaSucursal = new quitarSucursal();
        quitarUnaSucursal.quitarSucursal(list,Quitar);

        listarSucursal listar = new listarSucursal();
        listar.listarSucursales(list);




    }
}