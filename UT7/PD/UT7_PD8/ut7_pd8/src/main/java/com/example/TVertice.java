package com.example;
import java.util.*;

public class TVertice<T> implements IVertice {
    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int tiempoDescubrimiento;
    private int tiempoFinalizacion;

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList<>();
        visitado = false;
    }


    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public void setTiempoDescubrimiento(int tiempo) {
        this.tiempoDescubrimiento = tiempo;
    }

    public int getTiempoDescubrimiento() {
        return this.tiempoDescubrimiento;
    }

    public void setTiempoFinalizacion(int tiempo) {
        this.tiempoFinalizacion = tiempo;
    }

    public int getTiempoFinalizacion() {
        return this.tiempoFinalizacion;
    }

    // DFS Visit para inicializar tiempos
    public int dfsVisit(int tiempo) {
        tiempo++;
        this.tiempoDescubrimiento = tiempo;
        this.setVisitado(true);
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                destino.dfsVisit(tiempo);
            }
        }
        tiempo++;
        this.tiempoFinalizacion = tiempo;
        return tiempo;
    }

    public void clasificarArcos(List<TArista> arcosArbol, List<TArista> arcosRetroceso,
                                List<TArista> arcosAvance, List<TArista> arcosCruzados) {
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice destino = adyacencia.getDestino();
            if (destino.getTiempoDescubrimiento() > this.getTiempoDescubrimiento()) {
                if (destino.getTiempoFinalizacion() == 0) {
                    arcosArbol.add(new TArista(this.etiqueta, destino.getEtiqueta(), adyacencia.getCosto()));
                } else {
                    arcosAvance.add(new TArista(this.etiqueta, destino.getEtiqueta(), adyacencia.getCosto()));
                }
            } else if (destino.getTiempoDescubrimiento() < this.getTiempoDescubrimiento()) {
                if (destino.getTiempoFinalizacion() == 0) {
                    arcosRetroceso.add(new TArista(this.etiqueta, destino.getEtiqueta(), adyacencia.getCosto()));
                } else {
                    arcosCruzados.add(new TArista(this.etiqueta, destino.getEtiqueta(), adyacencia.getCosto()));
                }
            }
        }
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                destino.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
            }
        }
    }
}
