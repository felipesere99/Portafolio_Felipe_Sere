package com.example;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio2 {
    public static Map<String, String> intercambiar(Map<String, String> mapa) {
        if (mapa.size() != mapa.values().stream().distinct().count()) {
            throw new IllegalArgumentException("El mapa contiene valores duplicados");
        }

        Map<String, String> resultado = new HashMap<>();
        mapa.forEach((clave, valor) -> resultado.put(valor, clave));
        return resultado;
    }
}
