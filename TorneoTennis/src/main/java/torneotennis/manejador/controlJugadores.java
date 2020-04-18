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
    public Jugador buscarJugadorBinarioPorPunteo(Jugador[] jugadores, int punteo) throws Exception {
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
     *TIpo de búsqueda binaria de nombres
     * @param jugadores
     * @param nombreJugador
     * @return
     */
    public Jugador buscarBinariamenteJugadorPorNombre(Jugador[] jugadores, String nombreJugador){//sería útil implementar en este método el ingresar el punteo por si acaso los jugadores tuvieran el mismo nombre de pila
            int limiteIzquierdo=0;
            int  limiteDerecho=jugadores.length-1;
            int centroArreglo;            
                        
            while(limiteIzquierdo<=limiteDerecho){
                 centroArreglo=(limiteIzquierdo+limiteDerecho)/2;
                 
                 if(jugadores[centroArreglo]==null){
                     System.out.println("NO se ha encontrado al jugador");
                     return null;
                 }                 
                 if(jugadores[centroArreglo].getNombre().compareToIgnoreCase(nombreJugador)==0){
                          return jugadores[centroArreglo];
                 }
                 else if(jugadores[centroArreglo].getNombre().compareToIgnoreCase(nombreJugador)<0){
                          limiteDerecho=centroArreglo-1;  
                 }
                 
                 else{
                        limiteIzquierdo=centroArreglo+1;
                 }                                                   
            }
            
            return null;
        }//creo que para los métodos de ordenamiento por nombre solo deberé implementar a comparte to en lugar de los ifguales, puesto que el algoritmo ya se encarga de recorrer el arreglo de tal forma que quede todo ordenado
    
        public Jugador buscarSecuencialmentePorNombre(Jugador[] jugadores, String nombreJugador){
                for(int numeroJUgadorActual=0; numeroJUgadorActual<jugadores.length; numeroJUgadorActual++){
                           if(nombreJugador.compareTo(jugadores[numeroJUgadorActual].getNombre())==0) {
                                    return jugadores[numeroJUgadorActual];
                           }
                }
                
                System.out.println("\nNo se encontro a un jugador con ese nombre");
                return null;
        }
        
        public Jugador[] bubbleSort(Jugador[] jugadores){
            Jugador jugadorTemporal;
            
            for(int numeroVecesRepetido=0; numeroVecesRepetido<jugadores.length-1; numeroVecesRepetido++){
                    for(int numeroPosicionActual=0; numeroPosicionActual<jugadores.length-1; numeroPosicionActual++){
                           if(jugadores[numeroPosicionActual].getNombre().compareToIgnoreCase(jugadores[numeroPosicionActual+1].getNombre())>0) {
                                    jugadorTemporal=jugadores[numeroPosicionActual];
                                    jugadores[numeroPosicionActual]=jugadores[numeroPosicionActual+1];
                                    jugadores[numeroPosicionActual+1]=jugadorTemporal;
                           }
                    }
                
            }
            
            return jugadores;
        
        }
        
    /**
     *Corrobora por cada vuelta que el índice que posea sea el correspondiente al valor mínimo según los datos 
     * del arreglo.
     * @param jugadores
     * @return
     */
    public Jugador[] selectionSort(Jugador[] jugadores){
               Jugador jugadorTemporal;
               
               for (int lugarDelMInimoActual = 0; lugarDelMInimoActual < jugadores.length-1; lugarDelMInimoActual++) {//no es <tamArreglo, pues el último DEBE ser el > puesto que nunca se agarró
                   int indiceMInimo=lugarDelMInimoActual;
                   
                        for (int lugarARevisar = lugarDelMInimoActual+1; lugarARevisar < jugadores.length; lugarARevisar++) {
                                if(jugadores[lugarARevisar].getNombre().compareToIgnoreCase(jugadores[indiceMInimo].getNombre())<0){
                                           indiceMInimo=lugarARevisar ;
                                }                                                                                    
                   }//fin del for que se de actualizar el índice al correspondiente del dato menor
                        
                        jugadorTemporal=jugadores[lugarDelMInimoActual];
                        jugadores[lugarDelMInimoActual]=jugadores[indiceMInimo];
                        jugadores[indiceMInimo]=jugadorTemporal;                
                }               
               return jugadores;
        }
    
     //resulta eficaz puesto que sin importar que valor haya sido seleccionado como referencia
     // cuando recorres a todos los elementos involucrados, lograrás encontrar al valor más pequeño de todos ellos
     // o simplemente terminarás de confirmar que el que tenías era más pequeño de todos, por lo tanto, ya no se 
     // requiere iniciar la vuelta desde la 1ra posición puesto que ya te aseguraste de haber agarrado el menor de todos
     //lo cual te asegura que al seguir adelante solo tendrás valores iguales o mayores al más peq que encontraste en 
     // dicha vuelta.. para de último sustituir el valor que se hallaba en dicho índice y rellenar ese espacio donde se encontraba
    //con el valor que estaba en esa ubicación la cual no le correspondía, esto no genera problemas pues después el mismo método se
    //encargará de llevarlo a su lugar correspondiente si es que no estaba en el correcto	

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
