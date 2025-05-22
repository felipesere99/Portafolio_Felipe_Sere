package uy.edu.ucu.aed.tdas;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestAltura {
    private IArbolBB<Integer> arbol;

    @BeforeEach
    void init() {
        arbol = new TArbolBB<>();
    }

    @Test
    public void dadoArbolVacio_EntoncesMenosUno() {
        // Dado
        assertTrue(arbol.esVacio());

        // Cuando
        Integer resultado = arbol.getAltura();

        // Entonces
        assertEquals(resultado, Integer.valueOf(-1));
    }

    @Test
    public void dadoArbolConUnNodo_EntoncesCero() {
        // Dado
        assertTrue(arbol.esVacio());
        arbol.insertar(3, 1);
        assertFalse(arbol.esVacio());

        // Cuando
        Integer resultado = arbol.getAltura();

        // Entonces
        assertEquals(resultado, Integer.valueOf(0));
    }

    @Test
    public void dadoArbolCompletoConTresElementos_EntoncesUno() {
        // Dado
        assertTrue(arbol.esVacio());
        arbol.insertar(2, 2);
        arbol.insertar(3, 3);
        arbol.insertar(1, 1);
        assertFalse(arbol.esVacio());

        // Cuando
        Integer resultado = arbol.getAltura();

        // Entonces
        assertEquals(resultado, Integer.valueOf(1));
    }

    @Test
    public void dadoArbolConUnSoloHijo_EntoncesUno() {
        // Dado
        assertTrue(arbol.esVacio());
        arbol.insertar(2, 2);
        arbol.insertar(3, 3);
        assertFalse(arbol.esVacio());

        // Cuando
        Integer resultado = arbol.getAltura();

        // Entonces
        assertEquals(resultado, Integer.valueOf(1));
    }

    @Test
    public void dadoArbolCompletoConSieteNodos_EntoncesDos() {
        // Dado
        assertTrue(arbol.esVacio());
        arbol.insertar(5, 5);
        arbol.insertar(3, 3);
        arbol.insertar(1, 1);
        arbol.insertar(4, 4);
        arbol.insertar(8, 8);
        arbol.insertar(7, 7);
        arbol.insertar(10, 10);

        assertFalse(arbol.esVacio());

        // Cuando
        Integer resultado = arbol.getAltura();

        // Entonces
        assertEquals(resultado, Integer.valueOf(2));
    }
}
