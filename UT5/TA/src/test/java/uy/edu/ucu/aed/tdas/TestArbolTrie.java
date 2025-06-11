package uy.edu.ucu.aed.tdas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestArbolTrie {

	private TArbolTrie trie;

	@BeforeEach
	void init() {
		trie = new TArbolTrie();
	}

	@Test
	public void testInsertarYBuscar() {
		trie.insertar("hola");
		trie.insertar("mundo");

		assertEquals(4, trie.buscar("hola"), "La palabra 'hola' debería estar en el trie.");
		assertEquals(5, trie.buscar("mundo"), "La palabra 'mundo' debería estar en el trie.");
		assertEquals(-1, trie.buscar("adios"), "La palabra 'adios' no debería estar en el trie.");
	}

	@Test
	public void testBuscarEnTrieVacio() {
		assertEquals(-1, trie.buscar("hola"), "No debería encontrar palabras en un trie vacío.");
	}

	@Test
	public void testImprimir() {
		trie.insertar("hola");
		trie.insertar("mundo");

		trie.imprimir();
	}
}