package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        //Ejercicio1
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "uno");
        mapa.put(2, null);
        mapa.put(3, "tres");

        System.out.println("Mapa antes de eliminar valores null: " + mapa);
        Ejercicio1.eliminarValoresNull(mapa);
        System.out.println("Mapa después de eliminar valores null: " + mapa);

        //Ejercicio2
        Map<String, String> mapa2 = new HashMap<>();
        mapa2.put("uno", "1");
        mapa2.put("dos", "2");
        mapa2.put("tres", "3");

        System.out.println("Mapa antes de intercambiar: " + mapa2);
        Map<String, String> mapaIntercambiado = Ejercicio2.intercambiar(mapa2);
        System.out.println("Mapa después de intercambiar: " + mapaIntercambiado);

        //Ejercicio3
        List<String> cadenas = new ArrayList<>();
        cadenas.add("auto");
        cadenas.add("avión");
        cadenas.add("camión");
        cadenas.add("barco");
        cadenas.add("tren");
        cadenas.add("bicicleta");

        System.out.println("Cadenas antes de ordenar: " + cadenas); //Cadenas antes de ordenar
        System.out.println("Lista de cadenas ordenadas:");
        Ejercicio3.ordenarCadenas(cadenas); //Cadenas ordenadas    

        //Ejercicio4
        Ejercicio4.imprimirAleatorio("src\\main\\java\\com\\example\\ejercicio4.txt", 5);
    }
}