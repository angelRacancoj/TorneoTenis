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
    //Buscar El nombre ingresado con la busqueda Binaria
    public Jugador busquedaBinariaNombre(Jugador[] jugadores, String nombre, int numOrdenamiento){
        boolean verificarNumOrdenamiento = true;
        if (numOrdenamiento == 1) {
            ordenarBubble(jugadores);            
        }else if (numOrdenamiento == 2) {
            ordenarSeleccion(jugadores);
        }else{
            System.out.println("El numero de ordenamiento no es valido, no se realizara la busqueda");
            verificarNumOrdenamiento = false;
            return null;
        } 
        ImprimirJugadores(jugadores);
        if (verificarNumOrdenamiento) {
            int posI = 0;
            int posF = jugadores.length-1;
            while(posI <= posF){
                int centro = (int) (posI+posF)/2;
                if (jugadores[centro].getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Se encontro la informacion del jugador");
                    return jugadores[centro];
                }else if (comparacion(jugadores[centro].getNombre(),nombre)) {
                    posI = centro+1;
                } else{
                    posF = centro-1;
                }
            }
        }
        System.out.println("No se encontro al jugador");
        return null;
    }
    //Se compara cual es el nombre mayor y menor para los ordenamientos
    private boolean comparacion(String j1,String j2){
        Collator comparar = Collator.getInstance();
        comparar.setStrength(Collator.PRIMARY);
        int evaluar = comparar.compare(j1.toUpperCase(), j2.toUpperCase());
        if (evaluar == -1) {
            return true;
        }
        return false;
    }
    //Ordenamiento por el metodo burbuja
    private void ordenarBubble(Jugador[] jugadores){
        System.out.println("Ordenamento bubble sort");
        int largo = jugadores.length;
        boolean moverPosicion = true;
        while (moverPosicion == true){
            moverPosicion = false;
            for (int i = 1; i < largo; i++) {
                if (comparacion(jugadores[i].getNombre(),jugadores[i-1].getNombre())) {
                    Jugador aux = jugadores[i];
                    jugadores[i] = jugadores[i-1];
                    jugadores[i-1]=aux;
                    moverPosicion = true;
                }
            }
        }
    }
    //ordenamiento por el metodo por seleccion
    private void ordenarSeleccion(Jugador[] jugadores){
        System.out.println("Ordenamiento por seleccion");
        int largo = jugadores.length;
        for (int i = 0; i < largo-1; i++) {
            int min = i;
            for (int j = i+1; j < largo; j++) {
                if (comparacion(jugadores[j].getNombre(),jugadores[min].getNombre())) {
                    min = j;
                }
            }
            Jugador aux = jugadores[i];
            jugadores[i] = jugadores[min];
            jugadores[min] = aux;
        }
    }
    private void ImprimirJugadores(Jugador[] jugadores){
        for (Jugador jugador : jugadores) {
            jugador.printMe();
        }
    }

}