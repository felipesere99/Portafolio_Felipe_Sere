package ut4_pd0;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Expresión en notación prefija: + * 2 3 4 -> ((2 * 3) + 4)
        List<String> expresion = new ArrayList<>(Arrays.asList("+", "*", "2", "3", "4"));

        // Crear el árbol de expresión
        Arbol arbol = new Arbol(null);
        arbol.raiz = arbol.construirDesdePrefija(expresion);

        // Sustituir variables (si hubiera)
        Map<String, Integer> variables = new HashMap<>();
        // Ejemplo: variables.put("x", 5);

        arbol.sustituirVariables(arbol.raiz, variables);

        // Evaluar la expresión
        int resultado = arbol.evaluar(arbol.raiz);
        System.out.println("Resultado de la expresión: " + resultado);
    }
}
