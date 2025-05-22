package ut3_pd3;

public class Main {

    public static void main(String[] args) {
        Nodo<String> nodo1 = new Nodo<>("A", "Hola");
        Nodo<String> nodo2 = new Nodo<>("B", "Mundo");
        Nodo<String> nodo3 = new Nodo<>("C", "!");

        nodo1.setSiguiente(nodo2);
        nodo2.setSiguiente(nodo3);

        Lista<String> lista = new Lista<>();

        lista.insertar(nodo1);
        lista.insertar(nodo2);
        lista.insertar(nodo3);

        System.out.println("Nodo buscado: " + lista.buscar(nodo3.etiqueta));

        String etiquetaAEliminar = "B";

        System.out.println("Lista: "+lista.imprimir());

        System.out.println("Se elimino el nodo con la etiqueta "+
            etiquetaAEliminar+ ": "+ lista.eliminar(etiquetaAEliminar));
    }
    
}