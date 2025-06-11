package ut5_pd2;

public class Main {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("ut5_pd2\\src\\main\\java\\ut5_pd2\\palabras.txt");
        for (String p : palabrasclave) {
            //System.out.println(p);
                trie.insertar(p);
        }
        trie.imprimir();  
        
        System.out.println("");
        System.out.println("Buscar paginas ");
        System.out.println(trie.buscar("ala"));
    }
}