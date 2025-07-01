package com.example;

import java.util.LinkedList;

public class TCaminos {
    private LinkedList<TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }

    public void agregarCamino(TCamino camino) {
        this.caminos.add(camino);
    }

    public LinkedList<TCamino> getCaminos() {
        return caminos;
    }
}
