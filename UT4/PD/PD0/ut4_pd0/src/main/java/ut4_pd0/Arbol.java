package ut4_pd0;

import java.util.List;
import java.util.Map;

public class Arbol {
    Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public void sustituirVariables(Nodo nodo, Map<String, Integer> valoresVariables) {
        if (nodo == null) return;
        if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) {
            if (valoresVariables.containsKey(nodo.valor)) {
                nodo.valor = String.valueOf(valoresVariables.get(nodo.valor));
            }
        } else {
            sustituirVariables(nodo.hijoIzquierdo, valoresVariables);
            sustituirVariables(nodo.hijoDerecho, valoresVariables);
        }
    }

    public int evaluar(Nodo nodo) {
        if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) {
            return Integer.parseInt(nodo.valor);
        }

        int valorIzquierdo = evaluar(nodo.hijoIzquierdo);
        int valorDerecho = evaluar(nodo.hijoDerecho);

        switch (nodo.valor) {
            case "+":
                return valorIzquierdo + valorDerecho;
            case "-":
                return valorIzquierdo - valorDerecho;
            case "*":
                return valorIzquierdo * valorDerecho;
            case "/":
                return valorIzquierdo / valorDerecho;
            default:
                throw new IllegalArgumentException("Operador no válido: " + nodo.valor);
        }
    }

    public Nodo construirDesdePrefija(List<String> expresion) {
        if (expresion.isEmpty()) return null;

        String valor = expresion.remove(0);
        Nodo nodo = new Nodo(valor);

        if (esOperador(valor)) {
            nodo.hijoIzquierdo = construirDesdePrefija(expresion);
            nodo.hijoDerecho = construirDesdePrefija(expresion);
        }

        return nodo;
    }

    // Verifica si el valor es un operador
    private boolean esOperador(String valor) {
        return valor.equals("+") || valor.equals("-") || valor.equals("*") || valor.equals("/");
    }
}
