
package org.ejemplo.opp.reinas8;


public class Main {

    
    public static void main(String[] args) {
        Tablero tablero = new Tablero(9);
        Jugador jugador =  new Jugador(tablero);
        jugador.jugar();
    }
}
