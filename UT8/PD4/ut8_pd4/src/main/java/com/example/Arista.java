package com.example;

public class Arista implements Comparable<Arista> {
    private Nodo origen;
    private Nodo destino;
    private int peso;

    public Arista(Nodo origen, Nodo destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Arista other) {
        return Integer.compare(this.peso, other.peso);
    }
}