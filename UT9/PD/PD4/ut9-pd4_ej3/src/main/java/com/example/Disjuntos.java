package com.example;

import java.util.HashSet;

public class Disjuntos {

    // Método para determinar si dos conjuntos son disjuntos
    public static boolean sonDisjuntos(int[] set1, int[] set2) {
        // Chequeo que set1 sea el conjunto más pequeño
        if (set1.length > set2.length) {
            int[] temp = set1;
            set1 = set2;
            set2 = temp;
        }

        // Insertar todos los elementos de set1 en un HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : set1) {
            hashSet.add(num);
        }

        // Verificar si algún elemento de set2 está en el HashSet
        for (int num : set2) {
            if (hashSet.contains(num)) {
                return false; // Hay un elemento común
            }
        }

        return true; // No hay elementos comunes
    }
}
