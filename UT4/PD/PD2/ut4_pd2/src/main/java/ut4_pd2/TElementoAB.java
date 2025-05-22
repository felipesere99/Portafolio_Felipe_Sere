package ut4_pd2;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T dato;

    public TElementoAB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            }
            return null;
        } else {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta);
            }
            return null;
        }
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0) {
            return false;
        } else if (etiqueta.compareTo(elemento.getEtiqueta()) > 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        }
    }

    @Override
    public String preOrden() {
        StringBuilder sb = new StringBuilder();
        preOrden(sb);
        return sb.toString();
    }

    private void preOrden(StringBuilder sb) {
        sb.append(this.etiqueta).append("-");
        if (hijoIzq != null) {
            hijoIzq.preOrden(sb);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(sb);
        }
    }

    @Override
    public String inOrden() {
        StringBuilder sb = new StringBuilder();
        inOrden(sb);
        return sb.toString();
    }

    private void inOrden(StringBuilder sb) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(sb);
        }
        sb.append(this.etiqueta).append("-");
        if (hijoDer != null) {
            hijoDer.inOrden(sb);
        }
    }

    @Override
    public String postOrden() {
        StringBuilder sb = new StringBuilder();
        postOrden(sb);
        return sb.toString();
    }

    private void postOrden(StringBuilder sb) {
        if (hijoIzq != null) {
            hijoIzq.postOrden(sb);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(sb);
        }
        sb.append(this.etiqueta).append("-");
    }

    @Override
    public T getDatos() {
        return dato;
    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
        } else {
            return quitaElNodo();
        }
        return this;
    }

    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }

        TElementoAB<T> min = hijoDer.obtenerMinimo();
        hijoDer = hijoDer.eliminar(min.getEtiqueta());
        min.setHijoIzq(hijoIzq);
        min.setHijoDer(hijoDer);
        return min;
    }

    public TElementoAB<T> obtenerMinimo() {
        if (hijoIzq != null) {
            return hijoIzq.obtenerMinimo();
        }
        return this;
    }
}
