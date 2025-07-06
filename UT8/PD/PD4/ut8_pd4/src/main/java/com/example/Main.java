package com.example;

import java.util.List;

import com.example.Kruskal.Edge;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
    
        Nodo cc1 = new Nodo("CC 1");
        Nodo cc2 = new Nodo("CC 2");
        Nodo cc3 = new Nodo("CC 3");
        Nodo cc4 = new Nodo("CC 4");
        Nodo cc5 = new Nodo("CC 5");
        Nodo cc6 = new Nodo("CC 6");
    
        grafo.agregarNodo(cc1);
        grafo.agregarNodo(cc2);
        grafo.agregarNodo(cc3);
        grafo.agregarNodo(cc4);
        grafo.agregarNodo(cc5);
        grafo.agregarNodo(cc6);
    
        grafo.agregarArista(cc1, cc2, 5);
        grafo.agregarArista(cc1, cc3, 7);
        grafo.agregarArista(cc1, cc4, 3);
        grafo.agregarArista(cc1, cc5, 9);
        grafo.agregarArista(cc1, cc6, 4);
    
        grafo.agregarArista(cc2, cc3, 3);
        grafo.agregarArista(cc2, cc4, 5);
        grafo.agregarArista(cc2, cc5, 7);
        grafo.agregarArista(cc2, cc6, 8);
    
        grafo.agregarArista(cc3, cc4, 4);
        grafo.agregarArista(cc3, cc5, 5);
        grafo.agregarArista(cc3, cc6, 7);
    
        grafo.agregarArista(cc4, cc5, 9);
        grafo.agregarArista(cc4, cc6, 3);
    
        grafo.agregarArista(cc5, cc6, 6);

        //Prim
        System.out.println("Algoritmo de Prim");
        Prim prim = new Prim(grafo);
        prim.calcularMST(cc1);

        prim.imprimirMST(); // Imprimir el MST


        //Kruskal 
        System.out.println("Algoritmo de Kruskal");
        Kruskal grafoK = new Kruskal (6);
        grafoK.agregarArista(1, 2, 5);
        grafoK.agregarArista(1, 3, 7);
        grafoK.agregarArista(1, 4, 3);
        grafoK.agregarArista(1, 5, 9);
        grafoK.agregarArista(1, 6, 4);


        grafoK.agregarArista(2, 3, 3);
        grafoK.agregarArista(2, 4, 5);
        grafoK.agregarArista(2, 5, 7);
        grafoK.agregarArista(2, 6, 8);

        grafoK.agregarArista(3, 4, 4);
        grafoK.agregarArista(3, 5, 5);
        grafoK.agregarArista(3, 6, 7);

        grafoK.agregarArista(4, 5, 9);
        grafoK.agregarArista(4, 6, 3);

        grafoK.agregarArista(5, 6, 6);


        List<Edge> aem = grafoK.kruskal();
        int suma = 0;
        for (Edge edge : aem) {
            System.out.println(edge.getV1() + " - " + edge.getV2() + " : " + edge.getPeso());
            suma += edge.getPeso();
        }
        System.out.println("La suma del peso total del MST (Arbol de expansión mínima) es: " + suma);

    }
}