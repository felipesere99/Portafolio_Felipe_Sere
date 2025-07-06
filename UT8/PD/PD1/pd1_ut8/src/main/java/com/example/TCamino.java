package com.example;

import java.util.LinkedList;

public class TCamino {
    private LinkedList<TVertice> vertices;
    private Double costoTotal;

    public TCamino() {
        this.vertices = new LinkedList<>();
        this.costoTotal = 0.0;
    }

    public void agregarVertice(TVertice vertice, Double costo) {
        this.vertices.add(vertice);
        this.costoTotal += costo;
    }

    public LinkedList<TVertice> getVertices() {
        return vertices;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }
}

