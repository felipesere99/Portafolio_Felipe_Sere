package uy.edu.ucu.aed.tas.ta3;

public class MedicionBuscarTrie extends Medible {

    private TArbolTrie arbol;

    public MedicionBuscarTrie(TArbolTrie arbol) {
        this.arbol = arbol;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                arbol.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arbol;
    }
}