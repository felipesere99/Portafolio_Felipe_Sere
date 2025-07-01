package com.example;
import java.util.*;

public class TGrafoDirigido {
    private Map<Comparable, TVertice> vertices;

    public TGrafoDirigido(Collection<TVertice> vertices) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            this.vertices.put(vertice.getEtiqueta(), vertice);
        }
    }

    public void clasificarArcos(Comparable etiquetaOrigen, List<TArista> arcosArbol,
                                List<TArista> arcosRetroceso, List<TArista> arcosAvance,
                                List<TArista> arcosCruzados) {
        TVertice verticeOrigen = vertices.get(etiquetaOrigen);
        if (verticeOrigen != null) {
            verticeOrigen.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        }
    }
    
    // Método de recorrido en profundidad para inicializar los tiempos de descubrimiento y finalización
    public void recorridoEnProfundidad() {
        int tiempo = 0;
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                tiempo = vertice.dfsVisit(tiempo);
            }
        }
    }
}
