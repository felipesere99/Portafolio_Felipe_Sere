package com.example;
import java.util.List;
public class Main {
    public Main() {
    }
 
    public static void main(String[] args) {
       Trie trie = new Trie();
       String[] palabras = new String[]{"almacen", "almibar", "algo", "alien", "alienigena", "aliado", "alto", "altura", "alumno"};
 
       for (String palabra : palabras) {
         System.out.println("Insertando: " + palabra);
         trie.insertar(palabra);
       }
 
       String prefijo = "al";
        System.out.println("Prediciendo para el prefijo: " + prefijo);
        List<String> predicciones = trie.predecir(prefijo);
        System.out.println("Predicciones para \"" + prefijo + "\": " + predicciones);
    }
 }
 