package com.example;
import java.util.*;
public class Prim {
    private Grafo grafo;
    private PriorityQueue<Arista> cola;
    private List<Arista> mst;
    private Set<Nodo> nodosEnMST;
    private Map<Nodo, Integer> distancias;
    private Map<Nodo, Nodo> predecesores;

    public Prim(Grafo grafo) {
        this.grafo = grafo;
    }

    public void calcularMST(Nodo inicio) {
        cola = new PriorityQueue<Arista>();
        mst = new ArrayList<Arista>();
        nodosEnMST = new HashSet<Nodo>();
        distancias = new HashMap<Nodo, Integer>();
        predecesores = new HashMap<Nodo, Nodo>();
    
        for (Nodo nodo : grafo.getNodos()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);
    
        cola.add(new Arista(inicio, inicio, 0)); // Inicializamos la cola con el nodo de inicio
    
        while (!cola.isEmpty()) {
            Arista arista = cola.poll();
            Nodo nodo = arista.getOrigen();
            Nodo nodoVecino = arista.getDestino();
            int peso = arista.getPeso();
    
            if (nodosEnMST.contains(nodoVecino)) {
                continue;
            }
    
            if (peso < distancias.get(nodoVecino)) {
                distancias.put(nodoVecino, peso);
                predecesores.put(nodoVecino, nodo);
            }
    
            mst.add(arista);
            nodosEnMST.add(nodoVecino);
    
            for (Arista aristaVecina : grafo.getAristas(nodoVecino)) {
                Nodo nodoVecino2 = aristaVecina.getDestino();
                int pesoVecino = aristaVecina.getPeso();
    
                if (pesoVecino < distancias.get(nodoVecino2)) {
                    distancias.put(nodoVecino2, pesoVecino);
                    predecesores.put(nodoVecino2, nodoVecino);
                    cola.add(aristaVecina);
                }
            }
        }
    }

    public List<Arista> getMST() {
        return mst;
    }

    public void imprimirMST() {
        System.out.println("Minimum Spanning Tree:");
        for (Arista arista : mst) {
            System.out.println(arista.getOrigen() + " - " + arista.getDestino() + " : " + arista.getPeso());
        }
    }
}