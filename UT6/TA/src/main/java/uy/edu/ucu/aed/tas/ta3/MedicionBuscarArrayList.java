package uy.edu.ucu.aed.tas.ta3;

import java.util.ArrayList;

/**
 * Clase que mide el tiempo y memoria al buscar elementos en una ArrayList.
 * Extiende la clase Medible para realizar mediciones específicas de búsqueda.
 */
public class MedicionBuscarArrayList extends Medible {

    // Atributo que almacena la ArrayList sobre la cual se realizarán las búsquedas
    private ArrayList<String> arrayList;

    /**
     * Constructor de la clase MedicionBuscarArrayList.
     * Inicializa la ArrayList sobre la cual se realizarán las búsquedas.
     *
     * @param arrayList ArrayList que se utilizará para las búsquedas.
     */
    public MedicionBuscarArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void ejecutar(Object... params) {
        // La operación a medir es la búsqueda de elementos en la ArrayList.
        // Se espera que params contenga dos elementos: el número de repeticiones y un
        // arreglo de palabras a buscar.

        if (params.length != 2 || !(params[0] instanceof Integer) || !(params[1] instanceof String[])) {
            throw new IllegalArgumentException("Parámetros inválidos. Se esperan: (int repeticion, String[] palabras)");
        }

        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                arrayList.contains(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arrayList;
    }
}
