package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.TArbolBB;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

public class Main {
    public static void main(String[] args) {
        TArbolBB<Integer> arbol = new TArbolBB<Integer>();

        ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();
        String[] listaArchivo = manejadorArchivosGenerico
                .leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\utils\\clavesPrueba.txt");
        for (String linea : listaArchivo) {
            Integer etiqueta = Integer.parseInt(linea);
            arbol.insertar(etiqueta, etiqueta);
        }

        // System.out.println("Recorrido en preorden: " + arbol.buscar(130));
    }
}