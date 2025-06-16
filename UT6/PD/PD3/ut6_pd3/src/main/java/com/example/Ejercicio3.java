package com.example;

import java.util.Comparator;
import java.util.List;

public class Ejercicio3 {
    public static void ordenarCadenas(List<String> cadenas) {
        cadenas.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        cadenas.forEach(System.out::println);
    }
}
