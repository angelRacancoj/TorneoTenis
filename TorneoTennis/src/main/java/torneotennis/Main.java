package torneotennis;

/**
 *
 * @author angelrg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        torneo.agregarDatos();
	torneo.escogerMetodoOrdenamiento();
        torneo.escogerMetodoOrdenamiento();
        torneo.buscarJugadorPorNombre();
    }

}
