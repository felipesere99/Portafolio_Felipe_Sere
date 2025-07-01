package ut7_pd4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TVertice<T> implements IVertice, IVerticeKevinBacon {

    private final Comparable etiqueta;
    private LinkedList<IAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int bacon;

    @Override
    public int getBacon() {
        return bacon;
    }

    @Override
    public void setBacon(int newBacon) {
        this.bacon = newBacon;
    }
    
    public int numBacon(Comparable actor){
        Queue<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        cola.add(this);
        this.setBacon(0);
        while (!cola.isEmpty()) {
            TVertice x = cola.poll();
            LinkedList<TAdyacencia> adyacencias = x.getAdyacentes();
            for (TAdyacencia ady : adyacencias){
                TVertice y = (TVertice) ady.getDestino(); //y para los adyecentes (lo vecions de x)
                if(!y.visitado){
                    y.setVisitado(true);
                    y.setBacon(x.getBacon()+1); //luego de visitar, para no sobreecribir sobre el abcon
                    cola.add(y);
                }
                if (y.getEtiqueta().compareTo(actor) == 0){
                    return y.getBacon();
                }
            }
        }
        return -1; //cuando no esta
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }


    public LinkedList<IAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public IAdyacencia buscarAdyacencia(IVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(IVertice verticeDestino) {
        IAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, IVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public IVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    public IVertice siguienteAdyacente(IVertice w) {
        IAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public IAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }

    public void bpf(Collection<TVertice> visitados) {
        visitados.add(this);
        this.visitado = true;

        for (IAdyacencia a : this.adyacentes) {
            IVertice v = a.getDestino();
            if (!v.getVisitado()) {
                v.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice destino = (TVertice) adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia((TAdyacencia) adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia((TAdyacencia) adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia((TAdyacencia) adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> unCamino) {
        setVisitado(true);
        unCamino.add(this.etiqueta);
        boolean ciclo = false;
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice w = adyacencia.getDestino();
            if (!w.getVisitado()) {
                ciclo = w.tieneCiclo(unCamino);
                if (ciclo) {
                    break;
                }
            } else {
                if (unCamino.contains(w.getEtiqueta())) {
                    ciclo = true;
                    break;
                }

            }

        }
        unCamino.remove(this.getEtiqueta());
        return ciclo;
    }

    public void bea(List<TVertice> visitados) {
        Queue<TVertice> cola = new LinkedList<>();
        cola.add(this);
        visitados.add(this);
        this.visitado = true;
        while (!cola.isEmpty()) {
            TVertice x = cola.remove();
            for (TAdyacencia ady : (LinkedList<TAdyacencia>) x.getAdyacentes()) {
                TVertice y = (TVertice) ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.add(y);
                    visitados.add(y);
                }
            }
        }
    }


}
