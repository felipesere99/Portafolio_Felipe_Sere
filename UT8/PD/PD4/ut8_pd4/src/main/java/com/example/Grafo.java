package com.example;

import java.util.*;

class Grafo {
    private Map<Nodo, List<Arista>> aristas;

    public Grafo() {
        this.aristas = new HashMap<>();
    }

    public void agregarNodo(Nodo nodo) {
        aristas.put(nodo, new ArrayList<>());
    }

    public void agregarArista(Nodo nodo1, Nodo nodo2, int peso) {
        Arista arista1 = new Arista(nodo1, nodo2, peso);
        aristas.get(nodo1).add(arista1);
        Arista arista2 = new Arista(nodo2, nodo1, peso);
        aristas.get(nodo2).add(arista2);
    }

    public List<Arista> getAristas(Nodo nodo) {
        return aristas.get(nodo);
    }

    public List<Nodo> getNodos() {
        return new ArrayList<>(aristas.keySet());
    }
}