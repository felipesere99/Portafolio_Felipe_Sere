package com.example;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

class TNodoTrie {
    Map<Character, TNodoTrie> hijos;
    boolean esPalabra;

    public TNodoTrie() {
        this.hijos = new HashMap<>();
        this.esPalabra = false;
    }

    public void insertar(String palabra) {
        TNodoTrie nodoActual = this;
        for (char c : palabra.toCharArray()) {
            nodoActual.hijos.putIfAbsent(c, new TNodoTrie());
            nodoActual = nodoActual.hijos.get(c);
        }
        nodoActual.esPalabra = true;
    }

    public boolean buscar(String palabra) {
        TNodoTrie nodoActual = this;
        for (char c : palabra.toCharArray()) {
            nodoActual = nodoActual.hijos.get(c);
            if (nodoActual == null) {
                return false;
            }
        }
        return nodoActual.esPalabra;
    }

    public void predecir(String prefijo, StringBuilder palabra, List<String> palabras) {
        if (this.esPalabra) {
            palabras.add(prefijo + palabra.toString());
        }
        for (Map.Entry<Character, TNodoTrie> entrada : hijos.entrySet()) {
            palabra.append(entrada.getKey());
            entrada.getValue().predecir(prefijo, palabra, palabras);
            palabra.deleteCharAt(palabra.length() - 1);
        }
    }
}
