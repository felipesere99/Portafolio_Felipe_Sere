package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TNodoTrie {
	private static final int CANT_CHR_ABECEDARIO = 26;
	private TNodoTrie[] hijos;
	private boolean esPalabra;

	public TNodoTrie() {
		hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
		esPalabra = false;
	}

	public void insertar(String unaPalabra) {
		TNodoTrie nodo = this;
		for (int c = 0; c < unaPalabra.length(); c++) {
			int indice = unaPalabra.charAt(c) - 'a';
			if (nodo.hijos[indice] == null) {
				nodo.hijos[indice] = new TNodoTrie();
			}
			nodo = nodo.hijos[indice];
		}
		nodo.esPalabra = true;
	}

	private void imprimir(String s, TNodoTrie nodo) {
		if (nodo != null) {
			if (nodo.esPalabra) {
				System.out.println(s);
			}
			for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
				if (nodo.hijos[c] != null) {
					imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
				}
			}
		}
	}

	public void imprimir() {
		imprimir("", this);
	}

	public int buscar(String unaPalabra) {
		TNodoTrie nodoActual = this;
		int comparaciones = 0;
		for (int c = 0; c < unaPalabra.length(); c++) {
			int indice = unaPalabra.charAt(c) - 'a';
			TNodoTrie unHijo = nodoActual.hijos[indice];
			if (unHijo == null) {
				return -1;
			} else {
				nodoActual = unHijo;
				comparaciones++;
			}
		}
		if (nodoActual.esPalabra) {
			return comparaciones;
		} else {
			return -1;
		}
	}

	public void subPalabras(String prefijo, LinkedList<String> l) {
		for (int i = 0; i < this.hijos.length; ++i) {
			TNodoTrie unHijo = this.hijos[i];
			if (unHijo == null) {
				continue;
			}

			String newPrefix = prefijo + (char) (i + 'a');
			if (unHijo.esPalabra) {
				l.add(newPrefix);
			}

			unHijo.subPalabras(newPrefix, l);
		}

	}

	public void predecir(String prefijo, LinkedList<String> ret) {
		TNodoTrie nodoActual = this;
		for (int c = 0; c < prefijo.length(); c++) {
			int indice = prefijo.charAt(c) - 'a';
			TNodoTrie unHijo = nodoActual.hijos[indice];
			if (unHijo == null) {
				return;
			}

			nodoActual = unHijo;
		}

		nodoActual.subPalabras(prefijo, ret);
	}
}
