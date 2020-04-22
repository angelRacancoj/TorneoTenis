package torneotennis.manejador;

import java.text.Collator;
import torneotennis.entidades.Jugador;

/**
 *
 * @author angelrg
 */
public class controlJugadores {

    private static final Collator comparar = Collator.getInstance();//Objeto para comparar Strings

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

    //Se agregan los metodo de ordenamiento mediante el nombre del jugador y 
    //se realiza la busqueda binaria tambíen con el nombre
    /**
     * Ordenamiento por el Método Burbúja
     *
     * @param ju Arreglo[] de Objetos de Jugadores
     */
    public void ordenarNombresBurbuja(Jugador[] ju) {
        Jugador aux;
        comparar.setStrength(Collator.SECONDARY);

        for (int i = 0; i < ju.length - 1; i++) {
            for (int j = 0; j < ju.length - 1; j++) {
                if (comparar.compare(ju[j + 1].getNombre(), ju[j].getNombre()) < 0) {
                    aux = ju[j + 1];
                    ju[j + 1] = ju[j];
                    ju[j] = aux;
                }
            }
        }
    }

    /**
     * Ordenamiento por el Método de Seleccion
     *
     * @param ju Arreglo[] de Objetos de Jugadores
     */
    public void ordenarNombresSeleccion(Jugador[] ju) {
        int minimo;
        Jugador aux;
        comparar.setStrength(Collator.SECONDARY);

        for (int i = 0; i < ju.length; i++) {
            minimo = i;

            for (int j = i + 1; j < ju.length; j++) {
                if (comparar.compare(ju[j].getNombre(), ju[minimo].getNombre()) < 0) {
                    minimo = j;
                }
            }

            aux = ju[i];
            ju[i] = ju[minimo];
            ju[minimo] = aux;
        }
    }

    /**
     * Se ordena la lista de jugadores según su punteo
     * @param ju
     */
    public void ordenarPunteoBurbuja(Jugador[] ju) {
        Jugador aux;

        for (int i = 0; i < ju.length - 1; i++) {
            for (int j = 0; j < ju.length - 1; j++) {
                if (ju[j].getPunteo()>ju[j+1].getPunteo()) {
                    aux = ju[j + 1];
                    ju[j + 1] = ju[j];
                    ju[j] = aux;
                }
            }
        }
    }

    public static Jugador busquedaBinariaNombre(Jugador[] ju, String nombre) {
        int inicio = 0;
        int tamaño = ju.length - 1;
        int centro;

        while (inicio <= tamaño) {
            centro = (inicio + tamaño) / 2;
            Jugador central = ju[centro];
            if (central == null) {
                return null;
            }

            if (central.getNombre().equalsIgnoreCase(nombre)) {
                return central;
            } else if (comparar.compare(nombre, central.getNombre()) < 0) {
                tamaño = centro - 1;
            } else {
                inicio = centro + 1;
            }
        }
        return null;
    }
}
