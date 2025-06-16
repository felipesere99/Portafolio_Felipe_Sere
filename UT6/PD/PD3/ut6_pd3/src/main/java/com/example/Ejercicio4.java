package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio4 {
    public static void imprimirAleatorio(String archivo, int numLineas) {
        List<String> lineas = leerArchivo(archivo);
        imprimirAleatorio(lineas, numLineas);
    }

    private static List<String> leerArchivo(String archivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    private static void imprimirAleatorio(List<String> lineas, int numLineas) {
        Random rand = new Random();
        int numTotalLineas = lineas.size();
        for (int i = 0; i < numLineas; i++) {
            int indiceAleatorio = rand.nextInt(numTotalLineas);
            System.out.println(lineas.get(indiceAleatorio));
        }
    }
}
