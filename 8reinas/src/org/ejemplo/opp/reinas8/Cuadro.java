
package org.ejemplo.opp.reinas8;


public class Cuadro {

    private Boolean ocupado;
    private Integer fila;
    private Integer columna;    
    
    public Cuadro(Integer fila, Integer columna) {
        this.columna=columna;
        this.fila = fila;
    }
    
    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
    
    
}
