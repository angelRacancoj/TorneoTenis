package torneotennis;

import java.util.Scanner;
import torneotennis.entidades.Estadio;
import torneotennis.entidades.Jugador;
import torneotennis.entidades.Partida;
import torneotennis.manejador.Ordenamiento;
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
        imprimirJugadores(); //Forma desordenada
        tipoOrdenamiento(); //Ordenan y se imprimin de forma ordenada
        bucarJugadorPorNombre();

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

    private void buscarJugadorPorPunteo() {
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

    private void bucarJugadorPorNombre() {
        boolean seguir = false;
        while (!seguir) {
            System.out.println("\n¿De qué tipo de busqueda desea realizar?");
            System.out.println("1. Secuencial \n2. Binaria");
            String decision = scanner.next();
            System.out.println("Que nombre desea buscar?");
            String nombreJ = scanner.next();

            try {
                switch (decision) {
                    case "1":
                        Jugador resultadoSecuencial = contJugadores.buscarJugador(jugadores, nombreJ);
                        resultadoSecuencial.printMe();
                        break;
                    case "2":
                        Jugador resultadoBinario = contJugadores.buscarJugadorBinario(jugadores, nombreJ);
                        resultadoBinario.printMe();
                        break;
                    default:
                        System.out.println("Escoja una opcion correcta");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
            
            System.out.println("Desea realizar otra busqueda? \n1)Si \n2)No");
            String elegir = scanner.next();
            if (elegir.equals("1")) {
                seguir=false;
            }
            else if (elegir.equals("2")) {
                seguir=true;
            }
        }
    }

    private void tipoOrdenamiento() {
        boolean seguir = false;
        Ordenamiento ordenar = new Ordenamiento();

        while (!seguir) {
            System.out.println("\n¿De qué forma quisiera ud ordenar el arreglo de jugadores?");
            System.out.println("1. Bubble Sort \n2. Seleccion");
            String eleccion = scanner.next();
            switch (eleccion) {
                case "1":
                    ordenar.Burbuja(jugadores);
                    seguir = true;
                    break;
                case "2":
                    ordenar.Seleccion(jugadores);
                    seguir = true;
                    break;
                default:
                    System.out.println("Escoja una opcion correcta");
                    break;
            }
        }
        imprimirJugadores(); //Ya se imprimen de forma ordenada
    }
}
