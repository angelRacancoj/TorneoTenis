package torneotennis.manejador;

import torneotennis.entidades.Jugador;

/**
 *
 * @author angelrg
 */
public class controlJugadores {

    /**
     * Se Obtiene el jugador mediante busqueda secuencial
     *
     * @param jugadores
     * @param nombre
     * @return
     */
    public Jugador buscarJugador(Jugador[] jugadores, String nombre) {
        //Lo utilizamos para mostrar los ciclos realizados
        int i = 0;

        for (Jugador jugador : jugadores) {
            i++;
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ciclos busqueda secuencial: " + i);
                return jugador;
            }
        }
        return null;
    }

    /**
     * Se busca al jugador en base a su punteo (como valor principal),
     * utilizando busqueda secuencial
     *
     * @param jugadores
     * @param punteo
     * @return
     */
    public Jugador buscarJugador(Jugador[] jugadores, int punteo) {
        //Lo utilizamos para mostrar los ciclos realizados
        int i = 0;
        jugadores = this.ordenarJugadorBurbujaA(jugadores);
        for (Jugador jugador : jugadores) {
            i++;
            if (jugador.getPunteo() == punteo) {
                System.out.println("Ciclos busqueda secuencial: " + i);
                return jugador;
            }
        }
        return null;
    }

    /**
     * Se busca al jugador en base a su punteo (como valor principal),
     * utilizando busqueda binaria
     *
     * @param jugadores
     * @param punteo
     * @return
     * @throws java.lang.Exception
     */
    public Jugador buscarJugadorBinario(Jugador[] jugadores, int punteo) throws Exception {
        //Lo utilizamos para mostrar los ciclos realizados
        int ciclos = 0;

        int pInicio = 0;
        int pFinal = jugadores.length - 1;
        int centro;
        jugadores = this.ordenarJugadorBurbujaA(jugadores);
        do {
            ciclos++;
            centro = (int) (pInicio + pFinal) / 2;
            if (jugadores[centro].getPunteo() == punteo) {
                System.out.println("Ciclos busqueda secuencial: " + ciclos);
                return jugadores[centro];
            } else if (jugadores[centro].getPunteo() > punteo) {
                pFinal = centro - 1;
            } else if (jugadores[centro].getPunteo() < punteo) {
                pInicio = centro + 1;
            }
            
            //Para arreglar el error de que no puede buscar en los limites del vector
            if(pInicio == pFinal && jugadores[(pInicio+pFinal)/2].getPunteo() == punteo){
                System.out.println("Ciclos busqueda secuencial: " + ciclos);
                return jugadores[(pInicio+pFinal)/2];
            }
        } while (pInicio != pFinal || pInicio > pFinal);
        throw new Exception("No se ha encontrado al jugador");
    }
    
    /**
     *  Metodo para buscar el nombre indicado, sin embargo este metodo solo funciona con las primeras letras del nombre
     * @param jugadores
     * @param nombre
     * @return
     * @throws Exception
     */
    public Jugador buscarJugadorNombre(Jugador[] jugadores, String nombre) throws Exception{
        int pInicio = 0;
        int pFinal = jugadores.length - 1;
        int centro;
        jugadores = ordenarJugadorBurbujaNombres(jugadores);
        do {
            
            centro = (int) (pInicio + pFinal) / 2;
            if (jugadores[centro].getNombre().equalsIgnoreCase(nombre.toUpperCase())) {
                return jugadores[centro];
            } else if (jugadores[centro].getNombre().toUpperCase().compareTo(nombre.toUpperCase()) >0) {
                pFinal = centro - 1;
            } else if ( jugadores[centro].getNombre().toUpperCase().compareTo(nombre.toUpperCase()) <0) {
                pInicio = centro + 1;
            }
            
            //Para arreglar el error de que no puede buscar en los limites del vector
            if(pInicio == pFinal && jugadores[(pInicio+pFinal)/2].getNombre().equalsIgnoreCase(nombre)){
                return jugadores[(pInicio+pFinal)/2];
            }
        } while (pInicio != pFinal || pInicio > pFinal);
        
        throw new Exception ("No se ha encontrado el jugador");
    }
    
    //Ordenamos el listado de jugadores por medio del metodo de ordenamiento burbuja
    private Jugador[] ordenarJugadorBurbujaA(Jugador[] jugadores){
        Jugador[] newPlayersList = jugadores;
        Jugador auxPlayer;
        
        for(int indexI = 1; indexI < newPlayersList.length; indexI++){
            
            for (int indexJ = 0; indexJ < (newPlayersList.length - indexI); indexJ++){
                if(newPlayersList[indexJ].getPunteo() > newPlayersList[indexJ+1].getPunteo()){
                    auxPlayer = newPlayersList[indexJ];
                    newPlayersList[indexJ] = newPlayersList[indexJ +1];
                    newPlayersList[indexJ +1] = auxPlayer;     
                } 
            }
        }
        
        
        
        return newPlayersList;
    }

    /**
     * Ordena los jugadores por sus nombres y utilizando el metodo burbuja
     * @param jugadores
     * @return
     */
    public Jugador[] ordenarJugadorBurbujaNombres(Jugador[] jugadores){
        
        
        Jugador[] newPlayersList = jugadores;
        Jugador auxPlayer;
        
        for(int indexI = 1; indexI < newPlayersList.length; indexI++){
            
            for (int indexJ = 0; indexJ < (newPlayersList.length - indexI); indexJ++){
                
                // elevamos ambos strings hacia mayusculas y usamos el metodo compareTo que nos devuelve un valor negativo si la primera cadena
                // es inferior alfabeticamente y valor positivo si la segunda cadena es inferior alfabeticamente
                if(newPlayersList[indexJ].getNombre().toUpperCase().compareTo(newPlayersList[indexJ+1].getNombre().toUpperCase()) > 0){
                    auxPlayer = newPlayersList[indexJ];
                    newPlayersList[indexJ] = newPlayersList[indexJ +1];
                    newPlayersList[indexJ +1] = auxPlayer;     
                }
            }
           
        }
        
        
        
        return newPlayersList;
    }
    
    /**
     * Ordenamos la lista de jugadores alfabeticamente, utilizando el metodo de seleccion
     * @param jugadores
     * @return
     */
    public Jugador[] ordenarJugadorSeleccionNombres(Jugador[] jugadores){
        int letra=0;
        Jugador[] newPlayersList = jugadores;
        Jugador auxPlayer;

        for (int indexI =0 ; indexI<newPlayersList.length-1;indexI++){
            int menor = indexI;
                for (int indexJ = indexI+1; indexJ < newPlayersList.length ; indexJ++){
                    
                    if(newPlayersList[indexJ].getNombre().toUpperCase().compareTo(newPlayersList[menor].getNombre().toUpperCase()) <0){
                        menor = indexJ;
                    }
                }
                
            if( menor != indexI){
                auxPlayer = newPlayersList[indexI];
                newPlayersList[indexI] = newPlayersList[menor];
                newPlayersList[menor] = auxPlayer;
            }
        }
        
        return newPlayersList;
    }
    /**
     * Se devuelte una arreglo con el tamaño redimensionado
     *
     * @param jugadores
     * @param nombre
     * @return
     */
    public Jugador[] eliminarJugador(Jugador[] jugadores, String nombre) {

        int tamañoActual = 0;

        //Este metodo se encarga de eliminar al jugador
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getNombre().equalsIgnoreCase(nombre)) {
                jugadores[i] = null;
            } else {
                tamañoActual++;
            }
        }

        Jugador[] sinUnJugador = new Jugador[tamañoActual - 1];

        //con este metodo se redimensiona
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null) {
                sinUnJugador = agregarjugador(sinUnJugador, jugadores[i]);
            }
        }
        return sinUnJugador;
    }

    private Jugador[] agregarjugador(Jugador[] jugadores, Jugador jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores == null) {
                jugadores[i] = jugador;
                break;
            }
        }
        return jugadores;
    }

}
