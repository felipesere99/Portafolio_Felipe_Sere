package uy.edu.ucu.aed.tas.ta3;

public class Medicion {

    private Long memoria;
    private Long tiempoEjecucion;
    private String texto;

    public Medicion(String texto, Long memoria, Long tiempoEjecucion) {
        this.texto = texto;
        this.memoria = memoria;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Long getMemoria() {
        return memoria;
    }

    public Float getMemoriaMB() {
        return memoria / (1024.0f * 1024.0f);
    }

    public void setMemoria(Long memoria) {
        this.memoria = memoria;
    }

    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public Float getTiempoEjecucionSecs() {
        return tiempoEjecucion / 1000000000.0f;
    }

    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Medicion: " + texto + " - " + "Consumo de memoria=" + getMemoriaMB()
                + " Megabytes , tiempo de ejecución ="
                + getTiempoEjecucionSecs() + " secs ";
    }

    public void print() {
        System.out.println(this.toString());
    }
}
