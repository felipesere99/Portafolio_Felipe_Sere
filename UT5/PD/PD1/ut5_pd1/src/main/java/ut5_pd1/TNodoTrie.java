package ut5_pd1;


import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    public boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }

    private TNodoTrie obtenerHijo(char letra){
        int indice = letra - 'a';
        return hijos[indice];
    }
    
    public int buscarNodoTrie(String s) {
        int contador = 0;
        TNodoTrie nodo = this;
        for(char car : s.toCharArray()){
            TNodoTrie unHijo = nodo.obtenerHijo(car);
            if (unHijo == null) {
                return 0;
            }
            else {
                nodo = unHijo;
                contador++;
            }
        }
        if (nodo.esPalabra) {
            return contador;
        }
        else {
            return 0;
        }

    }
    

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie unHijo = this;
        TNodoTrie nodoActual = this;
        for (char c: prefijo.toCharArray()) {
            unHijo = nodoActual.obtenerHijo(c);
            if (unHijo == null){
                return;
            } else {
                nodoActual = unHijo;
                
            }
        }
        acumulaPalabras(nodoActual, palabras, prefijo);
    
    }

    public void acumulaPalabras(TNodoTrie unHijo, LinkedList palabras, String prefijo){
        if (unHijo.esPalabra){
            palabras.add(prefijo);
        }
        for (int c= 0; c< CANT_CHR_ABECEDARIO; c++){
            TNodoTrie hijo = unHijo.hijos[c];
            if (hijo!=null){
                char s = (char) (c + 'a');
                
                acumulaPalabras(hijo, palabras, prefijo + s);
            }
        }
    }


    @Override
    public int buscar(String s) {
        return buscarNodoTrie(s);
    }
  
}
