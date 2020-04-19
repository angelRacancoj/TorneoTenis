package torneotennis.manejador;

import java.text.Collator;
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
    
    
    /**
     * Se verifica que nombre va antes por orden alfabetico
     *
     * @param nombreJugador1
     * @param nombreJugador2
     */
    private boolean esMenorQue(String nombreJugador1,String nombreJugador2){
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.PRIMARY);
        int valorComparacion = comparador.compare(nombreJugador1.toUpperCase(), nombreJugador2.toUpperCase());
        if(valorComparacion == -1){
            return true;
        }
        return false;
    }

    /**
     * Se ordena un arreglo por orden alfabetico
     * siguiendo la logica del metodo Burbuja
     *
     * @param jugadores
     */
    public void ordenamientoPorBurbuja(Jugador[] jugadores){
        int largoArreglo = jugadores.length;
        for (int i = 0; i < largoArreglo; i++) {
            for (int j = (largoArreglo-1); j > i; j--) {                
                if (esMenorQue(jugadores[j].getNombre(), jugadores[j-1].getNombre())) {
                    Jugador jugadorTemporal = jugadores[j];
                    jugadores[j] = jugadores[j-1];
                    jugadores[j-1] = jugadorTemporal;
                }
            }
        }        
    }
    
    /**
     * Se ordena un arreglo por orden alfabetico
     * siguiendo la logica del ordenamiento por seleccion
     *
     * @param jugadores
     */
    public void ordenamientoPorSeleccion(Jugador[] jugadores){
        int largoArreglo = jugadores.length;
        for (int i = 0; i < largoArreglo; i++) {
            int valorMinimo = i;
            for (int j = valorMinimo+1; j < largoArreglo; j++) {             
                if (esMenorQue(jugadores[j].getNombre(), jugadores[valorMinimo].getNombre())) {
                    valorMinimo = j;
                }
            }
            Jugador jugadorTemporal = jugadores[i];
            jugadores[i] = jugadores[valorMinimo];
            jugadores[valorMinimo] = jugadorTemporal;
        }
    }
}
