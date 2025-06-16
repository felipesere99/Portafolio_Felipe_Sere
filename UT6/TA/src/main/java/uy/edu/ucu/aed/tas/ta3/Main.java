package uy.edu.ucu.aed.tas.ta3;

import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;
    private static final String PREFIJO_TA = "./src/main/java/uy/edu/ucu/aed/tas/ta3/";

    private static void medibleBuscar(String[] palabrasBuscar, Medible[] medibles) {
        Medicion mi;
        int i = 0;
        Object[] params = { REPETICIONES, palabrasBuscar };
        String[] lineas = new String[6];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucionSecs().toString() + ","
                    + mi.getMemoriaMB().toString();

        }

        ManejadorArchivosGenerico.escribirArchivo(PREFIJO_TA + "buscar.csv", lineas);
    }

    private static void mediblePredecir(String prefijo, Medible[] medibles) {
        Medicion mi;
        int i = 0;
        Object[] params = { REPETICIONES, prefijo };
        String[] lineas = new String[4];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucionSecs().toString() + ","
                    + mi.getMemoriaMB().toString();

        }

        ManejadorArchivosGenerico.escribirArchivo(PREFIJO_TA + "predecir.csv", lineas);
    }

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();
        String[] palabrasclave = ManejadorArchivosGenerico
                .leerArchivo(PREFIJO_TA + "listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico
                .leerArchivo(PREFIJO_TA + "listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
            linkedList.add(p);
            arrayList.add(p);
            hashMap.put(p, p);
            treeMap.put(p, p);
        }

        Medible[] medibles = new Medible[5];
        int i = 0;
        medibles[i++] = new MedicionBuscarLinkedList(linkedList);
        medibles[i++] = new MedicionBuscarArrayList(arrayList);
        medibles[i++] = new MedicionBuscarTrie(trie);
        medibles[i++] = new MedicionBuscarHashMap(hashMap);
        medibles[i++] = new MedicionBuscarTreeMap(treeMap);
        // medibleBuscar(palabrasBuscar, medibles);

        System.out.println();

        medibles = new Medible[3];
        i = 0;
        medibles[i++] = new MedicionPredecirLinkedList(linkedList);
        medibles[i++] = new MedicionPredecirHashMap(hashMap);
        medibles[i++] = new MedicionPredecirTrie(trie);
        mediblePredecir("cas", medibles);
    }
}
