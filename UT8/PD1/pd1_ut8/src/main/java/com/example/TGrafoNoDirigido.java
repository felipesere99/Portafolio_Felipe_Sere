package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    private Map<Comparable, TVertice> vertices;
    private List<TArista> aristas;

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        if (super.insertarArista(arista)) {
            TArista aristaInversa = new TArista(arista.getDestino(), arista.getOrigen(), arista.getCosto());
            return super.insertarArista(aristaInversa);
        }
        return false;
    }

    public Collection<TArista> getAristas() {
        return aristas;
    }

    public Collection<TVertice> getVertices() {
        return vertices.values();
    }

    public void mostrarGrafo() {
        System.out.println("Vértices:");
        for (TVertice vertice : getVertices()) {
            System.out.println(vertice.getEtiqueta());
        }

        System.out.println("Aristas:");
        for (TArista arista : getAristas()) {
            System.out.println(
                    arista.getOrigen() + " - " + arista.getDestino() + ": " + arista.getCosto());
        }
    }

    public TGrafoNoDirigido kruskal() {
        List<TArista> aristas = new ArrayList<>(this.getAristas());
        aristas.sort(Comparator.naturalOrder());

        Map<Comparable, Comparable> parent = new HashMap<>();
        for (Comparable vertice : this.vertices.keySet()) {
            parent.put(vertice, vertice);
        }

        List<TArista> aristasMST = new ArrayList<>();

        for (TArista arista : aristas) {
            Comparable raizOrigen = find(parent, arista.getOrigen());
            Comparable raizDestino = find(parent, arista.getDestino());

            if (!raizOrigen.equals(raizDestino)) {
                aristasMST.add(arista);
                union(parent, raizOrigen, raizDestino);
            }
        }

        Collection<TVertice> vertices = new ArrayList<>(this.vertices.values());
        return new TGrafoNoDirigido(vertices, aristasMST);
    }

    private Comparable find(Map<Comparable, Comparable> parent, Comparable vertice) {
        if (!parent.get(vertice).equals(vertice)) {
            parent.put(vertice, find(parent, parent.get(vertice)));
        }
        return parent.get(vertice);
    }

    private void union(Map<Comparable, Comparable> parent, Comparable vertice1, Comparable vertice2) {
        Comparable raiz1 = find(parent, vertice1);
        Comparable raiz2 = find(parent, vertice2);
        parent.put(raiz1, raiz2);
    }

    public TGrafoNoDirigido prim() {
        List<TArista> arbolExpMinimo = new ArrayList<>();
        Set<TVertice> verticesVisitados = new HashSet<>();
        PriorityQueue<TArista> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(TArista::getCosto));
    
        // Empezar desde un vértice aleatorio o específico
        TVertice primerVertice = vertices.get(0); // Ejemplo: empezar desde el primer vértice
    
        verticesVisitados.add(primerVertice);
        colaPrioridad.addAll(primerVertice.getAdyacentes());
    
        while (!colaPrioridad.isEmpty()) {
            TArista aristaActual = colaPrioridad.poll();
            TVertice verticeDestino = aristaActual.getDestino();
    
            if (!verticesVisitados.contains(verticeDestino)) {
                verticesVisitados.add(verticeDestino);
                arbolExpMinimo.add(aristaActual);
                colaPrioridad.addAll(verticeDestino.getAdyacentes());
            }
        }
    
        return new TGrafoNoDirigido(new ArrayList<>(verticesVisitados), arbolExpMinimo);
    }
    

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<TVertice> bpf() {
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : this.vertices.values()) {
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
