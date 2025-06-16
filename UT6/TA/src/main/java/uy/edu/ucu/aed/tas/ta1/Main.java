/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ucu.aed.tas.ta1;

import uy.edu.ucu.aed.tdas.THash;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crear una tabla de tipo THash e insertar las claves del archivo
        // "claves_insertar.txt"
        String[] clavesInsertar = ManejadorArchivosGenerico
                .leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\tas\\ta1\\claves_insertar.txt");
        THash<Integer, String> tablaHash = new THash(200);
        System.out.println("Tamaño de la tabla: " + tablaHash.getM());
        for (String clave : clavesInsertar) {
            int claveInt = Integer.parseInt(clave);
            tablaHash.insertar(claveInt, clave);
        }

        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo
        // "claves_buscar.txt"

        String[] clavesBuscar = ManejadorArchivosGenerico
                .leerArchivo(
                        "src\\main\\java\\uy\\edu\\ucu\\aed\\tas\\ta1\\claves_buscar.txt");
        for (String clave : clavesBuscar) {
            int claveInt = Integer.parseInt(clave);
            System.out.println("Clave buscada: " + clave + ": " + tablaHash.buscar(claveInt));
        }
    }
}
