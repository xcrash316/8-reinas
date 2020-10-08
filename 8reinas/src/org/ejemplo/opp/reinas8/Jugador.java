
package org.ejemplo.opp.reinas8;

import java.util.ArrayList;
import java.util.List;


public class Jugador {
    
    private Tablero tablero;
    
    public Jugador(Tablero tablero) {
        this.tablero=tablero;
    }
    
    public void jugar()
    {
        
        tablero.iterar(0);
    }

    
    
}
