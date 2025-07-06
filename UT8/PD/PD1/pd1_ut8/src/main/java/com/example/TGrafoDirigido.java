package com.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoDirigido implements IGrafoDirigido {

    protected Map<Comparable, TVertice> vertices;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            this.vertices.put(vertice.getEtiqueta(), vertice);
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        if (!vertices.containsKey(vertice.getEtiqueta())) {
            vertices.put(vertice.getEtiqueta(), vertice);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarVertice(Comparable etiqueta) {
        if (vertices.containsKey(etiqueta)) {
            vertices.remove(etiqueta);
            for (TVertice vertice : vertices.values()) {
                vertice.eliminarAdyacencia(etiqueta);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean insertarArista(TArista arista) {
        TVertice verticeOrigen = vertices.get(arista.getOrigen());
        TVertice verticeDestino = vertices.get(arista.getDestino());
        if (verticeOrigen != null && verticeDestino != null) {
            return verticeOrigen.insertarAdyacencia(arista.getCosto(), verticeDestino);
        }
        return false;
    }

    @Override
    public boolean eliminarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice verticeOrigen = vertices.get(etiquetaOrigen);
        if (verticeOrigen != null) {
            return verticeOrigen.eliminarAdyacencia(etiquetaDestino);
        }
        return false;
    }

    @Override
    public TVertice buscarVertice(Comparable etiqueta) {
        return vertices.get(etiqueta);
    }

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<TVertice> bpf() {
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public boolean esConexo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean tieneCiclo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<TVertice> todosLosCaminos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Double[][] floyd() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
