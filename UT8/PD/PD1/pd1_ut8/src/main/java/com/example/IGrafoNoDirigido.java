package com.example;

import java.util.LinkedList;
import java.util.Collection;

public interface IGrafoNoDirigido {
    Collection<TVertice> bea();
    Collection<TVertice> bpf();
    boolean esConexo();
    boolean tieneCiclo();
    LinkedList<TVertice> todosLosCaminos();
    Double[][] floyd();
    boolean insertarArista(TArista arista);
}
