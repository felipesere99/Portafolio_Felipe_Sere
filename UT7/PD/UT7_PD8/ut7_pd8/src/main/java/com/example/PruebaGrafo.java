package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PruebaGrafo {

    public static void main(String[] args) {
    TVertice v1 = new TVertice("A");
    TVertice v2 = new TVertice("B");
    TVertice v3 = new TVertice("C");
    TVertice v4 = new TVertice("D");

    v1.getAdyacentes().add(new TAdyacencia(1.0, v2));
    v1.getAdyacentes().add(new TAdyacencia(1.0, v3));
    v2.getAdyacentes().add(new TAdyacencia(1.0, v4));
    v3.getAdyacentes().add(new TAdyacencia(1.0, v4));

    Collection<TVertice> vertices = Arrays.asList(v1, v2, v3, v4);
    TGrafoDirigido grafo = new TGrafoDirigido(vertices);

    // Ejecutar DFS para inicializar tiempos
    grafo.recorridoEnProfundidad();

    List<TArista> arcosArbol = new ArrayList<>();
    List<TArista> arcosRetroceso = new ArrayList<>();
    List<TArista> arcosAvance = new ArrayList<>();
    List<TArista> arcosCruzados = new ArrayList<>();

    grafo.clasificarArcos("A", arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);

    System.out.println("Arcos de Árbol: " + arcosArbol); 
    System.out.println("Arcos de retrocesos: " + arcosRetroceso);
    System.out.println("Arcos de avance: "+ arcosAvance);
    System.out.println("Arcos cruzados: "+ arcosCruzados);
    }
}
