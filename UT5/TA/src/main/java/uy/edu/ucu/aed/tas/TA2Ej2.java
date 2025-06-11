package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.TArbolTrie;

public class TA2Ej2 {
	public static void main(String[] args) {
		// Crear una instancia de un arbol Trie.
		// Leer un archivo palabras.txt
		// Para cada palabra encontrada, insertarla en el Trie
		// Por último, imprimir el trie.
		// Ejemplo de uso del Trie.
		TArbolTrie trie = new TArbolTrie();

		ManejadorArchivosGenerico manejador = new ManejadorArchivosGenerico();
		// String[] palabras = manejador.leerArchivo(
		// "C:\\Users\\barra\\OneDrive\\Escritorio\\Documentos\\Desarrollo de
		// software\\Semestre 3\\Algoritmos y estructuras de
		// datos\\UT5\\ut05-aed2025-equipo-14\\src\\main\\java\\uy\\edu\\ucu\\aed\\tas\\palabras.txt");

		// for (String palabra : palabras) {
		// trie.insertar(palabra);
		// }

		trie.insertar("ala");
		trie.insertar("alimania");
		trie.insertar("alabastro");
		trie.insertar("perro");
		trie.insertar("pera");
		trie.insertar("alimento");
		trie.insertar("casa");
		trie.insertar("casada");
		trie.insertar("cazar");
		trie.insertar("programa");
		trie.insertar("programacion");
		trie.insertar("programar");

		System.out.println("Impresión de Trie:");
		trie.imprimir();
		System.out.println();

		String palabra = "al";
		System.out.printf("Subpalabras de %s\n", palabra);
		for (String p : trie.predecir(palabra)) {
			System.out.println(p);
		}
	}
}
