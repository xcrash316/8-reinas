
package org.ejemplo.opp.reinas8;


public class Validador {
    
    private Tablero tablero;
    
    public Validador(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public boolean validarPosic(Cuadro cuadro)
    {   
        return (validaVertical(cuadro) && validaHorizontal(cuadro) && validaDiagonalDerecha(cuadro) && validaDiagonalIzquierda(cuadro)) ;
    }
    private boolean validaVertical(Cuadro cuadro)
    {
        
        Integer i = cuadro.getFila();
        Integer j = cuadro.getColumna();
        
        
        if (j>0)
            for(int j2 = j; j2>=0; j2--)
            {
                Cuadro c = tablero.getCuadroByPosicion(i, j2);
                if (c.getOcupado())                    
                    return false;                            
            }
        if (j<7)
            for(int j2 = j; j2<=(this.tablero.getDimension()-1); j2++)
            {
                Cuadro c = tablero.getCuadroByPosicion(i, j2);
                if (c.getOcupado())
                    return false;                            
            }
            
        return true;
    }
    
    private boolean validaHorizontal(Cuadro cuadro)
    {
        Integer i = cuadro.getFila();
        Integer j = cuadro.getColumna();
        
        if (i>0)
            for(int i2 = i; i2>=0; i2--)
            {
                Cuadro c = tablero.getCuadroByPosicion(i2, j);
                if (c.getOcupado())                    
                    return false;                            
            }
        if (i<7)
            for(int i2 = i; i2<=(this.tablero.getDimension()-1); i2++)
            {
                Cuadro c = tablero.getCuadroByPosicion(i2, j);
                if (c.getOcupado())
                    return false;                            
            }
            
        return true;
    }
    
    private boolean validaDiagonalDerecha(Cuadro cuadro)
    {
        
        
        Integer i2 ,j2;
        
        int i = cuadro.getFila();
        int j = cuadro.getColumna();
                
        if (i!=0 && j!=(this.tablero.getDimension()-1))
        {
            j2 = j;
            for(i2 = i; i2>=0; i2--)           
            {
                Cuadro c = this.tablero.getCuadroByPosicion(i2, j2);
                if (c.getOcupado())                    
                    return false;                
                if(i2 ==0 || j2==(this.tablero.getDimension()-1))
                    break;
                
                j2++;
                
            }
            
        }   
        if(i!=(this.tablero.getDimension()-1) && j!=0)
        {
            j2 = j;        
            for( i2 = i; i2<=(this.tablero.getDimension()-1); i2++)        
            {
                Cuadro c = this.tablero.getCuadroByPosicion(i2, j2);
                if (c.getOcupado())                    
                    return false;
                
                
                
                if(i2 ==(this.tablero.getDimension()-1) || j2==0)
                    break;
                j2--;

            }
        }
        return true;
    }
    
    private boolean validaDiagonalIzquierda(Cuadro cuadro)
    {
        Integer i2 ,j2;
        
        int i = cuadro.getFila();
        int j = cuadro.getColumna();
                
        if (i!=(this.tablero.getDimension()-1) && j!=(this.tablero.getDimension()-1))
        {
            j2 = j;
            for(i2 = i; i2<=(this.tablero.getDimension()-1); i2++)           
            {
                Cuadro c = this.tablero.getCuadroByPosicion(i2, j2);
                if (c.getOcupado())                    
                    return false;
                
                    //System.out.println(i2.toString()+j2.toString());                
                
                if(i2 == (this.tablero.getDimension()-1) || j2 == (this.tablero.getDimension()-1))
                    break;
                
                j2++;
                
            }
            
        }   
        if(i!=0 && j!=0)
        {
            j2 = j;        
            for( i2 = i; i2>=0; i2--)        
            {
                Cuadro c = this.tablero.getCuadroByPosicion(i2, j2);
                if (c.getOcupado())                    
                    return false;
                
                if(i2 == 0 || j2 == 0)
                    break;
                j2--;

            }
        }
        return true;
    }

    
    
}
