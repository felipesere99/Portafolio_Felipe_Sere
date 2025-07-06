package com.example;

import java.util.Collection;
import java.util.LinkedList;

public interface IGrafoDirigido {
    boolean insertarVertice(TVertice vertice);
    boolean eliminarVertice(Comparable etiqueta);
    boolean insertarArista(TArista arista);
    boolean eliminarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino);
    TVertice buscarVertice(Comparable etiqueta);
    Collection<TVertice> bea();
    Collection<TVertice> bpf();
    boolean esConexo();
    boolean tieneCiclo();
    LinkedList<TVertice> todosLosCaminos();
    Double[][] floyd();
}
