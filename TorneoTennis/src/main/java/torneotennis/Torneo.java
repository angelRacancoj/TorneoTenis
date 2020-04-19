package torneotennis;

import java.util.Scanner;
import torneotennis.entidades.Estadio;
import torneotennis.entidades.Jugador;
import torneotennis.entidades.Partida;
import torneotennis.manejador.controlJugadores;

/**
 *
 * @author angelrg
 */
public class Torneo {

    private controlJugadores contJugadores = new controlJugadores();

    private Scanner scanner = new Scanner(System.in);
    private Jugador[] jugadores;
    private Jugador[] jugadoresDisponibles;
    private Estadio[] estadios;
    private Partida[] partidas;

    public void agregarDatos() {

        System.out.println("Cuantos Jugadores desea Ingresar?");
        jugadores = getJugadores();
        jugadoresDisponibles = jugadores;
        imprimirJugadores();
        buscarJugador();

    }

    private void imprimirJugadores() {
        for (Jugador jugador : jugadores) {
            jugador.printMe();
        }
    }

    private Jugador[] getJugadores() {
        System.out.println("Cuantos jugadores Ingresara: ");
        int tamaño = Integer.parseInt(scanner.nextLine());
        Jugador[] jugador = new Jugador[tamaño];

        for (int i = 0; i < jugador.length; i++) {
            System.out.println("Ingrese el Nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese Punteo: ");
            int edad = Integer.parseInt(scanner.nextLine());

            jugador[i] = new Jugador(nombre, 0, edad);
        }

        return jugador;
    }

    public void escogerMetodoOrdenamiento(){
           int tipoMetodo = 1+metodoAleatorio.nextInt(2);
            
           if(tipoMetodo==1){
                 contJugadores.bubbleSort(jugadores);   
                 //imprimirJugadores();
           }
            
           else{//aquí va el de selección
                contJugadores.selectionSort(jugadores);
                //imprimirJugadores();
            }
    }
    
    public void buscarJugadorPorNombre(){
        String nombreJugador="";
        while(nombreJugador.compareTo("ninguno")!=0){
            System.out.println("\n\t--Ingrese el nombre del jugador a buscar--");
            System.out.println("[Ingrese -> ninguno <- si ya no desea seguir ingresando]");        
            System.out.print("->");        
            nombreJugador= scanner.nextLine();
            if(nombreJugador.compareTo("ninguno")!=0){
                    System.out.println("\n1. Busqueda secuencial \n2. Búsqueda binaria");
                    System.out.println("Ingrese el tipo de búsqueda a emplear");
                    System.out.print("->");
                    int tipoBusqueda= Integer.parseInt(scanner.nextLine());
                    try{
                          switch(tipoBusqueda){
                                   case 1:             
                                            Jugador jugadorHallado = contJugadores.buscarBinariamenteJugadorPorNombre(jugadores, nombreJugador);
                                            System.out.println("\n\n<<Jugador hallado>>\n" );
                                            jugadorHallado.printMe();
                                   break;
            
                                   case 2:
                                            Jugador jugadorEncontrado = contJugadores.buscarSecuencialmentePorNombre(jugadores, nombreJugador);
                                            System.out.println("<<Jugador hallado>>\n" );
                                            jugadorEncontrado.printMe();
                                    break;            
                                    default:
                                            System.out.println("NO ingresaste ningun numero mostrado en el menú");                                            
                          }//fin del switch
                    }     
                    catch(Exception excepcion){//yo recordaba que aquí se podían personalizar los msjes...pero creo que lo hizo para saber de que excepcion se hablaba
                           System.out.println("--Ninguno");
                           System.out.printf("--Razón -> %s\n", excepcion.getMessage()); 
                    }
            }
            
        }//fin del while        
        
    }

    private void buscarJugador() {
        System.out.println("Ingrese el punteo del Jugador: ");
        int punteo = Integer.parseInt(scanner.nextLine());
        try {
            System.out.println("Secuencial: ");
            Jugador resultadoSecuencial = contJugadores.buscarJugador(jugadores, punteo);
            resultadoSecuencial.printMe();
            System.out.println("\nBinaria: ");
            Jugador resultado = contJugadores.buscarJugadorBinario(jugadores, punteo);
            resultado.printMe();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
