package com.example;

import java.util.List;
import com.example.Kruskal.Edge;

public class Main {
    public static void main(String[] args) {
        System.out.println("Arbol de Expansión Mínima de Kruskal");
        Kruskal g = new Kruskal(5);
        g.agregarArista(0, 1, 2);
        g.agregarArista(0, 2, 3);
        g.agregarArista(1, 2, 1);
        g.agregarArista(1, 3, 4);
        g.agregarArista(2, 3, 5);
        g.agregarArista(3, 4, 6);

        List<Edge> aem = g.kruskal();
        int suma = 0;
        for (Edge edge : aem) {
            System.out.println(edge.getV1() + " - " + edge.getV2() + " : " + edge.getPeso());
            suma += edge.getPeso();
        }
        System.out.println("La suma del peso total del MST (Arbol de expansión mínima) es: " + suma);
    }
}