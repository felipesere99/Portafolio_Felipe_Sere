package ut3_pd3;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }
    @Override
    public void insertar(Nodo<T> nodo){
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nodo;
        }
    }

    @Override
    public void insertar(Comparable clave, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(clave, dato);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
            while (actual != null) {
                if (actual.etiqueta.equals(clave)) {
                    return actual.dato;
                }
                actual = actual.siguiente;
            }
            return null; // No encontrado
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.etiqueta.equals(clave)) {
            primero = primero.siguiente;
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.siguiente != null && !actual.siguiente.etiqueta.equals(clave)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente == null) {
            return false; // No encontrado
        }
        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
            Nodo<T> actual = primero;
            while (actual != null) {
                sb.append(actual.dato.toString());
                actual = actual.siguiente;
                if (actual != null) {
                    sb.append(", ");
                }
            }
            return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.dato.toString());
            actual = actual.siguiente;
            if (actual != null) {
                sb.append(separador);
            }
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
    @Override
    public boolean esVacia() {
        return primero == null;
    }


    @Override
    public void setPrimero(Nodo<T> unNodo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrimero'");
    }

    @Override
    public Nodo<T> getPrimero(){
        return primero;
    }

    // implementar los metodos indicados en la interfaz
}
