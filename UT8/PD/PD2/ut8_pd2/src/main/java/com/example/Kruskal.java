package com.example; 

import java.util.*;

class Kruskal {
    private int numVertices;
    private List<List<Edge>> adyacencia;

    public Kruskal(int numVertices) {
        this.numVertices = numVertices;
        this.adyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int v1, int v2, int peso) {
        adyacencia.get(v1).add(new Edge(v1, v2, peso));
        adyacencia.get(v2).add(new Edge(v2, v1, peso)); // grafo no dirigido
    }

    public List<Edge> kruskal() {
        // Crear un heap para ordenar las aristas por peso
        PriorityQueue<Edge> heap = new PriorityQueue<>();
        for (int v1 = 0; v1 < numVertices; v1++) {
            for (Edge edge : adyacencia.get(v1)) {
                heap.add(edge);
            }
        }

        // Crear un conjunto de conjuntos disjuntos para los vértices
        int[] conjuntos = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            conjuntos[i] = i;
        }

        // Crear el árbol de expansión mínima
        List<Edge> aem = new ArrayList<>();
        while (!heap.isEmpty()) {
            Edge edge = heap.poll();
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            if (find(conjuntos, v1) != find(conjuntos, v2)) {
                aem.add(edge);
                union(conjuntos, v1, v2);
            }
        }

        return aem;
    }

    private int find(int[] conjuntos, int v) {
    if (conjuntos[v] != v) {
        conjuntos[v] = find(conjuntos, conjuntos[v]);
    }
    return conjuntos[conjuntos[v]]; // Devuelve el representante del conjunto
    }

    private void union(int[] conjuntos, int v1, int v2) {
        int root1 = find(conjuntos, v1);
        int root2 = find(conjuntos, v2);
        if (root1 != root2) {
            conjuntos[root1] = root2; // Une los conjuntos
        }
    }

    static class Edge implements Comparable<Edge> {
        private int v1;
        private int v2;
        private int peso;
    
        public Edge(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getPeso() {
            return peso;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.peso, other.peso);
        }
    }
}