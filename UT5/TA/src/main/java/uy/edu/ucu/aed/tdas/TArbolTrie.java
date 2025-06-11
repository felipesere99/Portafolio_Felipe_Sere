package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TArbolTrie {
	private TNodoTrie raiz;

	public void insertar(String palabra) {
		if (raiz == null) {
			raiz = new TNodoTrie();
		}
		raiz.insertar(palabra);
	}

	public void imprimir() {
		if (raiz != null) {
			raiz.imprimir();
		}
	}

	public int buscar(String palabra) {
		if (raiz != null) {
			return raiz.buscar(palabra);
		}
		return -1;
	}

	public LinkedList<String> predecir(String palabra) {
		LinkedList<String> l = new LinkedList<>();
		if (raiz != null) {
			raiz.predecir(palabra, l);
		}
		return l;
	}
}
