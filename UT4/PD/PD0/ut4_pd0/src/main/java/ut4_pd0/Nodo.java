package ut4_pd0;

class Nodo {
    String valor;
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;

    public Nodo(String valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
