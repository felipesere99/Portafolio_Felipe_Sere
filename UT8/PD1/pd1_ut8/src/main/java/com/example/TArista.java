package com.example;

public class TArista {
    private String origen;
    private String destino;
    private double costo;

    public TArista(String origen, String destino, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getCosto() {
        return costo;
    }
}
