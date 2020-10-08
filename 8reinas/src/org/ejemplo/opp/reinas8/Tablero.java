
package org.ejemplo.opp.reinas8;

import java.util.ArrayList;
import java.util.List;


public class Tablero {
    private Integer soluciones;
    private Integer dimension;
    protected List<Cuadro> cuadricula = new ArrayList<>();

    public Tablero(Integer dimension) 
    {
        soluciones = 0;
       this.dimension = dimension;
       
       for(int i=0;i<dimension;i++) {
           for(int j=0;j<dimension;j++)
               cuadricula.add(new Cuadro(i,j));
       }
       
       resetTablero();
    }
    
    
    public Integer getReinasColocadas() {
        int i =0;
        for(Cuadro c:cuadricula)
            i+=c.getOcupado()?1:0;
        
        return i;
    }
    
    
    
    
    
    public void resetTablero()
    {
        for(Cuadro c: this.cuadricula) 
            c.setOcupado(false);
    }

    public boolean setPosicion(int i, int j)
    {
        if (i>(this.dimension-1) || i<0 || j>(this.dimension-1) || j<0)
            return false;
        
        Validador valida = new Validador(this);        
        
        Cuadro cuadro = getCuadroByPosicion(i, j);
        
        cuadro.setOcupado(valida.validarPosic(cuadro));
        
        return cuadro.getOcupado();
    }
    
    public void quitPosicion(int i, int j)
    {
        if (i>(this.dimension-1) || i<0 || j>(this.dimension-1) || j<0)
            return;
        
        Cuadro cuadro = getCuadroByPosicion(i, j);
        
        cuadro.setOcupado(false);
    }
  

    public Integer iterar(Integer i)
    {
        for (Integer j = 0; j <= (this.dimension-1); j++)            
        {            
            if (setPosicion(i, j))
            {                
                iterar(i+1);
                if (getReinasColocadas() == this.dimension)     
                    imprimirSolucion();
                
                quitPosicion(i,j);
            }
        }
        
        return getReinasColocadas();
    }
    
    public Cuadro getCuadroByPosicion(Integer i, Integer j) {
        Cuadro cuadro=null;
        for(Cuadro c:cuadricula) {
            if (c.getFila().equals(i) && c.getColumna().equals(j)) {
                cuadro = c;
                break;
            }                
        }
        return cuadro;
    }

    public Integer getDimension() {
        return dimension;
    }

    public List<Cuadro> getCuadricula() {
        return cuadricula;
    }

    private void imprimirSolucion() {
        String linea = "";
        soluciones ++;
        //Esta parte simplemente imprime el tablero cuando ya colocó las 8 reinas.
        for (Integer i = 0; i <= (this.getDimension()-1); i++)
        {
            for (Integer j = 0; j <= (this.getDimension()-1); j++)
            {
                Cuadro c = getCuadroByPosicion(i, j);
                linea += c.getOcupado()?"1":"0";
                linea +="|";

            }
            System.out.println(linea);
            linea = "";
        }
        System.out.println();
        System.out.println("Solución:"+soluciones.toString());
        System.out.println("------------------------");
        System.out.println();
    }
    
}
