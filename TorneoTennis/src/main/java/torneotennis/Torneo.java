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
        realizarBusqueda();

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
            nombre = nombre.toLowerCase();
            nombre = Character.toUpperCase(nombre.charAt(0)) + nombre.substring(1, nombre.length());
            System.out.println("Ingrese Punteo: ");
            int edad = Integer.parseInt(scanner.nextLine());

            jugador[i] = new Jugador(nombre, 0, edad);
        }

        return jugador;
    }

    private void buscarJugadorPunteo() {
        contJugadores.ordenarPunteoBurbuja(jugadores);
        System.out.println("Ingrese el punteo del Jugador: ");
        try {
            int punteo = Integer.parseInt(scanner.nextLine());
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

    private void buscarJugadorNombre() {
        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();
        contJugadores.ordenarNombresSeleccion(jugadores);
        Jugador jugador = contJugadores.busquedaBinariaNombre(jugadores, nombre);
        if (jugador != null) {
            System.out.println("==================================");
            jugador.printMe();
            System.out.println("==================================\n");
        } else {
            System.out.println("**El jugador no existe**");
        }
    }

    public void realizarBusqueda() {
        int opcion = 0;
        do {
            System.out.println("¿De qué forma quiere buscar al jugador?");
            System.out.println(" 1. Por Punteo");
            System.out.println(" 2. Por Nombre");
            System.out.println(" 3. Dejar de buscar");
            System.out.println("Ingrese el número de su opción:");
            try{
                opcion = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                opcion = 0;
            }
            
            switch (opcion) {
                case 1:
                    buscarJugadorPunteo();
                    break;
                case 2:
                    buscarJugadorNombre();
                    break;
                case 3:
                    opcion = -1;
                    break;
                default:
                    System.out.println("Opción Inválida");
                    break;
            }
        } while (opcion != -1);

    }

}
