package torneotennis.manejador;

import torneotennis.entidades.Jugador;

public class Ordenamiento {
    
    public void Burbuja(Jugador[] jugadores){
        for (int i = 0; i < jugadores.length-1; i++) {//Las veces que se repetira
            for (int j = 0; j < jugadores.length-1; j++) {//Para cambiar los elementos de posicion
                if (jugadores[j].getNombre().compareTo(jugadores[j+1].getNombre()) > 0)  {
                    Jugador temporal = jugadores[j+1]; //Proteger al jugador para que no desaparezca e insertarlo luego
                    //Poner los elementos en su respectivo orden
                    jugadores[j+1]=jugadores[j];
                    jugadores[j]=temporal;
                }
            }
        }
    }
    

   public void Seleccion(Jugador[] jugadores){
        for (int i = 0; i < jugadores.length -1; i++) {//Nos determina las posiciones del arreglo
            int posicionJugadorIzquierda = i; //Nos indica donde se encuentra el nombre que va mas a la izquierda
            
            for (int j = i+1; j < jugadores.length; j++) {//Este compara los nombres del arreglo de jugadores
                if (jugadores[j].getNombre().compareTo(jugadores[posicionJugadorIzquierda].getNombre()) < 0) {//Comparamos la posicion actual con la que por el momento es minima se hace un cambio
                    posicionJugadorIzquierda = j;
                }
                
                Jugador jugadorTemp = jugadores[i]; //Se guarda el jugador que esta mas a la izquierda
                jugadores [i] = jugadores[posicionJugadorIzquierda];
                jugadores[posicionJugadorIzquierda] = jugadorTemp;
            }            
        }
    }
}