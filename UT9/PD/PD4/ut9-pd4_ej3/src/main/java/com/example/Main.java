package com.example;

public class Main {
    public static void main(String[] args) {

        // En el peor caso es de O(n + m) donde n y m son los tamaños de los conjuntos
        int[] set1 = { 1, 2, 3, 4, 5 };
        int[] set2 = { 6, 7, 8, 9, 10 };

        boolean result = Disjuntos.sonDisjuntos(set1, set2);
        System.out.println("¿Son los conjuntos disjuntos? " + result); // Devuelve true
    }
}