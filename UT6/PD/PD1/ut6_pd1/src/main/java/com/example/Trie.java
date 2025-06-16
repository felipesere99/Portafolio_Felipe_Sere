package com.example;
import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TNodoTrie raiz;

    public Trie() {
        this.raiz = new TNodoTrie();
    }

    public void insertar(String palabra) {
        raiz.insertar(palabra);
    }

    public boolean buscar(String palabra) {
        return raiz.buscar(palabra);
    }

    public List<String> predecir(String prefijo) {
        List<String> palabras = new ArrayList<>();
        TNodoTrie nodoActual = raiz;
        for (char c : prefijo.toCharArray()) {
            nodoActual = nodoActual.hijos.get(c);
            if (nodoActual == null) {
                return palabras;
            }
        }
        nodoActual.predecir(prefijo, new StringBuilder(), palabras);
        return palabras;
    }
}
