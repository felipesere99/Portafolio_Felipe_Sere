import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
       String[] abonadosArchivo = ManejadorArchivosGenerico.leerArchivo(
        "codigo y datos pd7\\src\\abonados.txt");
        for (String str : abonadosArchivo) {
            String[] elementos = str.split(",");
            String telefono = elementos[0];
            String nombre = elementos[1];
            TAbonado abonado = new TAbonado(nombre, telefono);
            trieAbonados.insertar(abonado);
            
        }
                
        String codigoPais = "598" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "93" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        String[] lista = new String[ab.size()];
        int indice = 0;
        
        for (TAbonado a : ab) {
            String nombre = a.getNombre();
            String telefono = a.getTelefono();
            String abonado = nombre + ", " + telefono;
            lista[indice] = abonado;
            indice++;
        }
        
        Arrays.sort(lista);

        ManejadorArchivosGenerico.escribirArchivo("codigo y datos pd7\\src\\salida.txt", lista);

        
    }
}