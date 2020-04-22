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
        jugadores = ordenarJugadoresMen(jugadores); 
        menuBusquedas();
        
        
        
    }
    
    
    private void menuBusquedas(){
        
        while(true){
        
            try{
            System.out.println("\n\n");
            imprimirJugadores();
            System.out.println("Seleccione el tipo de busqueda que quiere realizar: ");
            System.out.println("1.- Por punteo");
            System.out.println("2.- Por nombre");
            System.out.println("3.- Salir");
            int choice =  Integer.parseInt(scanner.nextLine());

            if(choice == 3){
                break;
            }
            
            System.out.println("Cuantas veces quieres repetir la busqueda: ");

            for(int times = Integer.parseInt(scanner.nextLine()); times>0;times--){ 
                System.out.print(times+".-" );
                switch(choice){
                    case 1:
                        buscarJugador();
                        break;

                    case 2:
                        buscarNombre();
                        break;

                    default:
                        System.out.println("Opcion equivocada vuelva a intentar");

                }
            }

            }catch(Exception e){
                System.out.println("Error: " +e);
            }
        
        }
    }
    private Jugador[] ordenarJugadoresMen(Jugador[] jugadores) {
        
        try{
            System.out.println("Selecciona el método para ordenar");
            System.out.println("1.- Burbuja");
            System.out.println("2.- Seleccion");
            int seleccion = Integer.parseInt(scanner.nextLine());
            switch(seleccion){
                case 1:
                    jugadores = contJugadores.ordenarJugadorBurbujaNombres(jugadores);
                    break;

                case 2:
                    jugadores = contJugadores.ordenarJugadorSeleccionNombres(jugadores);
                    break;


                default:
                    System.out.println("Se escogio el metodo burbuja por defecto");
                    jugadores = contJugadores.ordenarJugadorBurbujaNombres(jugadores);
        }
        
        }catch(Exception e){
            System.out.println("Error: "+e);
            System.out.println("Se escogio el metodo burbuja por defecto");
            jugadores = contJugadores.ordenarJugadorBurbujaNombres(jugadores);
        }
        return jugadores;        
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
    
    private void buscarNombre(){
        
        try{
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        Jugador resultadoNombre = contJugadores.buscarJugadorNombre(jugadores, nombre);
        resultadoNombre.printMe();
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }

}
