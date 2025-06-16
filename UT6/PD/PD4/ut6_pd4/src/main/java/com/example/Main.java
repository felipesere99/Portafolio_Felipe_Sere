package com.example;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String archivo = "libro.txt";

        Map<String, Integer> frecuencias = Ejercicio4.contarFrecuencias(archivo);

        Map<String, Integer> topFrecuencias = Ejercicio4.topFrecuencias(frecuencias, 10);

        GráficoFrecuencias grafico = new GráficoFrecuencias("Frecuencias de Palabras", topFrecuencias);
        grafico.setVisible(true);
    }
}


