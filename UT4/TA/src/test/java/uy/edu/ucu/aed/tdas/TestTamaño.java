package uy.edu.ucu.aed.tdas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class TestTamaño {

// Test para verificar el tamaño del árbol
    @Test
    public void testTamañoArbol() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(10, 10);
        arbol.insertar(5, 5);
        arbol.insertar(15, 15);

        assertEquals(3, arbol.obtenerTamaño());
    }

    @Test
    public void testTamañoArbolVacio() {
        TArbolBB<Integer> arbol = new TArbolBB<>();

        assertEquals(0, arbol.obtenerTamaño());
    }

    @Test
    public void testTamañoArbolConUnElemento() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(10, 10);

        assertEquals(1, arbol.obtenerTamaño());
    }
}