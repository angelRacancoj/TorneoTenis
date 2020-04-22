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
        buscarJugadorPorNombre(); //se agrega el metodo a agregarDatos para poder ser ejecutado en el main

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
    
    //Se agrega y crea el metodo buscarJugadorPorNombre para determinar que metodo de ordenacion queremos utilizar
    private void buscarJugadorPorNombre(){
        boolean salir = false;
        do{
        System.out.println("Ingrese el nombre del Jugador: ");
        String nombreJugador = scanner.nextLine();
        try{
            System.out.println("\nQue quieres hacer: ");
            System.out.println("1. Busqueda Binaria por Ordenamiento BubbleSort \n2. Busqueda Binaria por Ordenamiento por Seleccion \n3. Salir del buscador");
            System.out.println("\nIngresa el numero de la opcion que seleccionaste: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    System.out.println("\nBubbleSort: ");
                    //contJugadores.OrdenamientoBubbleSort(jugadores);
                    Jugador resultadoBubbleSort = contJugadores.buscarNombreJugadorBinario(contJugadores.OrdenamientoBubbleSort(jugadores), nombreJugador);
                    resultadoBubbleSort.printMe();
                    break;
                    
                case 2:
                    System.out.println("\nOrdenamiento por Seleccion: ");
                    //contJugadores.ordenamientoPorSeleccion(jugadores);
                    Jugador resultadoSeleccion = contJugadores.buscarNombreJugadorBinario(contJugadores.ordenamientoPorSeleccion(jugadores), nombreJugador);
                    resultadoSeleccion.printMe();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println(">>>>Ingresaste un numero no valido<<<<");
                    break;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }while(!salir);
    }

}
