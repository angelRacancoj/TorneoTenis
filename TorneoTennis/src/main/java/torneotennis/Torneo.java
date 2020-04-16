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
