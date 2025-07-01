package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creación de vértices y aristas para el grafo
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        TVertice v4 = new TVertice("D");

        TArista a1 = new TArista("A", "B", 2.0);
        TArista a2 = new TArista("A", "C", 1.0);
        TArista a3 = new TArista("B", "C", 4.0);
        TArista a4 = new TArista("B", "D", 3.0);
        TArista a5 = new TArista("C", "D", 5.0);

        // Creación del grafo no dirigido
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(Arrays.asList(v1, v2, v3, v4),
                Arrays.asList(a1, a2, a3, a4, a5));

        // Implementación de Prim
        System.out.println("Árbol de expansión mínimo usando Prim:");
        TGrafoNoDirigido arbolPrim = grafo.prim();
        arbolPrim.mostrarGrafo();

        // Implementación de Kruskal
        System.out.println("\nÁrbol de expansión mínimo usando Kruskal:");
        TGrafoNoDirigido arbolKruskal = grafo.kruskal();
        arbolKruskal.mostrarGrafo();
    }
}
