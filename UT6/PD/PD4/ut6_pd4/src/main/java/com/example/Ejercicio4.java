package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ejercicio4 {
    public static Map<String, Integer> contarFrecuencias(String archivo) {
        Map<String, Integer> frecuencias = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\W+"); // Dividir por palabras
                for (String palabra : palabras) {
                    if (palabra.isEmpty()) continue;
                    palabra = palabra.toLowerCase();
                    frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return frecuencias;
    }

    public static Map<String, Integer> topFrecuencias(Map<String, Integer> frecuencias, int n) {
        PriorityQueue<Map.Entry<String, Integer>> cola = new PriorityQueue<>(
            (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entrada : frecuencias.entrySet()) {
            cola.offer(entrada);
            if (cola.size() > n) {
                cola.poll();
            }
        }

        Map<String, Integer> topFrecuencias = new HashMap<>();
        while (!cola.isEmpty()) {
            Map.Entry<String, Integer> entrada = cola.poll();
            topFrecuencias.put(entrada.getKey(), entrada.getValue());
        }

        return topFrecuencias;
    }
}
