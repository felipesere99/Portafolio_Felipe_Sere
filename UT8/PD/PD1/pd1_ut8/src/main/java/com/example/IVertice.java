package com.example;

import java.util.LinkedList;
import java.util.Collection;

public interface IVertice {
    TAdyacencia buscarAdyacencia(TVertice verticeDestino);
    Double obtenerCostoAdyacencia(TVertice verticeDestino);
    boolean insertarAdyacencia(Double costo, TVertice verticeDestino);
    boolean eliminarAdyacencia(Comparable nomVerticeDestino);
    TVertice primerAdyacente();
    TAdyacencia buscarAdyacencia(Comparable etiquetaDestino);
    void bpf(Collection<TVertice> visitados);
    TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos);
    void bea(Collection<TVertice> visitados);
    TVertice siguienteAdyacente(TVertice w);
    boolean tieneCiclo(LinkedList<Comparable> camino);
    boolean conectadoCon(TVertice destino);
}
