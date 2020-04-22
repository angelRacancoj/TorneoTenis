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
           
        elegirMetododeOrdenamiento();
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

    private void buscarJugadorPunteo() {
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
    //    Ordenamiento por metodo Burbuja
    
//    Para la comparacion de los nombre se aboco al metodo compareTo, el cual se encarga de comprar los nombres
//    de cada jugador, evaluando y regresando un valor ya se 0,1 o -1, para cumplir o no con la condicion
    private void ordenarJugadoresBurbuja() {
        Jugador temp;
        for (int i = 1; i < jugadores.length; i++) {
            for (int j = 0; j < jugadores.length - 1; j++) {
                if ((jugadores[j].getNombre().compareToIgnoreCase(jugadores[j + 1].getNombre())) > 0) {
                    temp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = temp;
                }
            }
        }
    }
    
    //Ordenamiento por metodo Seleccion
    private void ordenarJugadoresSeleccion() {
        
        int minimo;
        Jugador aux;
        
        for (int i = 0; i < jugadores.length-1; i++) {
            minimo = i;
            for (int j = i+1; j < jugadores.length; j++) {
                if ((jugadores[j].getNombre().compareToIgnoreCase(jugadores[minimo].getNombre())) < 0) {
                    minimo = j;
                }
            }
            aux=jugadores[i];
            jugadores[i] = jugadores[minimo];
            jugadores[minimo]= aux;
            
        }
    }
    
//    Menu de busqueda de Jugador
    private void buscarJugador(){
        
        System.out.println("¿Que tipo de busqueda desea realizar?\n");        
        System.out.println("1. Busqueda por punteo\n2. Busqueda por nombre\n");
        int eleccion = Integer.parseInt(scanner.nextLine());
        
        switch (eleccion){
            case 1: buscarJugadorPunteo(); break;
            case 2: buscarJugadorNombre(); break;
            default: System.out.println("Opcion Incorrecta"); buscarJugador(); break;   
        }
    }
    
//    Menu de eleccion de metodo de ordenamiento
        private void elegirMetododeOrdenamiento(){
        
        System.out.println("¿Que tipo de ordenamiento desea implementar?\n");        
        System.out.println("1. Metodo Burbuja \n2. Metodo por Seleccion\n");
        int eleccion = Integer.parseInt(scanner.nextLine());
        
        switch (eleccion){
            case 1: ordenarJugadoresBurbuja(); break;
            case 2: ordenarJugadoresSeleccion(); break;
            default: System.out.println("Opcion Incorrecta"); elegirMetododeOrdenamiento(); break;
        }
    }
             private void buscarJugadorNombre () {
        System.out.println("Ingrese el nombre del Jugador: ");
        String nombre = scanner.nextLine();
        try {
            System.out.println("Secuencial: ");
            Jugador resultadoSecuencial = contJugadores.buscarJugador(jugadores, nombre);
            resultadoSecuencial.printMe();
            System.out.println("\nBinaria: ");
            Jugador resultado = contJugadores.buscarJugadorNombre(jugadores, nombre);
            resultado.printMe();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
