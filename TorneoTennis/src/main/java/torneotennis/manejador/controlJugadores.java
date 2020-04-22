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
    //Se agrega el Ordenamiento BubbleSort en base al nombre del jugador
    public Jugador [] OrdenamientoBubbleSort(Jugador[] jugadores){
        Jugador cambioJugador;
        
        for (int i = 0; i < jugadores.length-1; i++) {
            for (int j = 0; j < jugadores.length-1; j++) {
                if(jugadores[j].getNombre().compareToIgnoreCase(jugadores[j+1].getNombre()) > 0){ 
                    cambioJugador = jugadores[j]; 
                    jugadores[j] = jugadores[j+1]; 
                    jugadores[j+1] = cambioJugador; 
                }
            }
        }
        return jugadores;
    }
    //Se agrega el ordenamiento por seleccion en base al nombre del jugador
    public Jugador[] ordenamientoPorSeleccion(Jugador[] jugadores){
        Jugador cambioJugador;
        for (int i = 0; i < jugadores.length-1; i++) {
            int minimo = i;
            for (int j = minimo+1; j < jugadores.length; j++) {
                if(jugadores[j].getNombre().compareToIgnoreCase(jugadores[minimo].getNombre()) < 0){
                    minimo = j;
                }
            }
            
            cambioJugador = jugadores[i];
            jugadores[i] = jugadores[minimo];
            jugadores[minimo] = cambioJugador;
        }
        
        
        return jugadores;
        
    }
    
    //Se agrega buqueda binaria segun el nombre del jugador
    public Jugador buscarNombreJugadorBinario(Jugador[] jugadores, String nombreJugador)throws Exception{
        int pInicio = 0;
        int pFinal = jugadores.length - 1;
        while(pInicio <= pFinal){
            int centro = (pInicio + pFinal) / 2;
            if(jugadores[centro].getNombre().compareToIgnoreCase(nombreJugador) == 0){
                return jugadores[centro];
            }else if(jugadores[centro].getNombre().compareToIgnoreCase(nombreJugador) > 0){
                pFinal = centro-1;
            }else if(jugadores[centro].getNombre().compareToIgnoreCase(nombreJugador) < 0){
                pInicio = centro+1;
            }
        }
        throw  new Exception("No se ha encontrado al jugador");
    }
    
    public Jugador buscarJugadorBinario(Jugador[] jugadores, int punteo) throws Exception {
        //Lo utilizamos para mostrar los ciclos realizados
        int ciclos = 0;

        int pInicio = 0;
        int pFinal = jugadores.length - 1;

        do {
            ciclos++;
            int centro = (int) (pInicio + pFinal) / 2;
            if (jugadores[centro].getPunteo() == punteo) {
                System.out.println("Ciclos busqueda secuencial: " + ciclos);
                return jugadores[centro];
            } else if (jugadores[centro].getPunteo() > punteo) {
                pFinal = centro - 1;
            } else if (jugadores[centro].getPunteo() < punteo) {
                pInicio = centro + 1;
            }
        } while (pInicio != pFinal || pInicio > pFinal);
        throw new Exception("No se ha encontrado al jugador");
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
