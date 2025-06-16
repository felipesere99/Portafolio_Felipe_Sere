package com.example;
import java.util.Map;

public class Ejercicio1 {
    public static void eliminarValoresNull(Map<?, ?> map) {
        map.entrySet().removeIf(entry -> entry.getValue() == null);
    }
}
