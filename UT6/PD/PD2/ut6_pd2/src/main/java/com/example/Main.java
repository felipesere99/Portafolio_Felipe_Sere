package com.example;
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        // Definir el rango de factores de carga a evaluar
        double[] loadFactors = {0.70, 0.75, 0.80, 0.85, 0.90, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97, 0.98, 0.99};

        try {
            // Leer archivos de prueba
            List<String> clavesInsertar = readLinesFromFile("claves_buscar.txt");
            List<String> clavesBuscar = readLinesFromFile("claves_buscar.txt");

            // Evaluar rendimiento para cada factor de carga
            for (double loadFactor : loadFactors) {
                int capacity = (int) (clavesInsertar.size() / loadFactor);

                HashTable<String, String> hashTable = new HashTable<>(capacity);
                int totalInsertComparisons = 0;
                int totalSearchComparisons = 0;
                int successfulSearches = 0;
                int failedSearches = 0;

                // Insertar claves
                for (String clave : clavesInsertar) {
                    int comparisons = hashTable.insert(clave, "valor");
                    totalInsertComparisons += comparisons;
                }

                // Buscar claves
                for (String clave : clavesBuscar) {
                    int comparisons = hashTable.search(clave);
                    totalSearchComparisons += comparisons;
                    if (comparisons > 0) {
                        successfulSearches++;
                    } else {
                        failedSearches++;
                    }
                }

                // Calcular promedios
                double avgInsertComparisons = (double) totalInsertComparisons / clavesInsertar.size();
                double avgSuccessfulSearchComparisons = successfulSearches > 0 ? (double) totalSearchComparisons / successfulSearches : 0;
                double avgFailedSearchComparisons = failedSearches > 0 ? (double) totalSearchComparisons / failedSearches : 0;

                // Imprimir resultados
                System.out.printf("Factor de carga: %.2f%%\n", loadFactor * 100);
                System.out.printf("Prom. Comparaciones Inserción: %.2f\n", avgInsertComparisons);
                System.out.printf("Prom. Comparaciones Búsqueda exitosa: %.2f\n", avgSuccessfulSearchComparisons);
                System.out.printf("Prom. Comparaciones Búsqueda sin éxito: %.2f\n", avgFailedSearchComparisons);
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Error al leer los archivos: " + e.getMessage());
        }
    }

    private static List<String> readLinesFromFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line.trim());
        }
        reader.close();
        return lines;
    }
}
