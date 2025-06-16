package uy.edu.ucu.aed.tdas;

public class THashNodo<K, V> {

    private K clave;
    private V valor;

    public THashNodo(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return this.clave;
    }

    public void setClave(K nuevaClave) {
        this.clave = nuevaClave;
    }

    public V getValor() {
        return this.valor;
    }

    public void setValor(V nuevoValor) {
        this.valor = nuevoValor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        THashNodo<?, ?> nodoObj = (THashNodo<?, ?>) obj;
        return clave.equals(nodoObj.clave);
    }

    @Override
    public int hashCode() {
        return clave.hashCode();
    }

}
