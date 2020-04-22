package torneotennis.entidades;

/**
 *
 * @author angelrg
 */
public class Partida {
    
    Jugador player1;
    Jugador player2;
    int punteoPlayer1;
    int punteoPlayer2;
    Estadio estadio;
    
    public Partida(Jugador player1, Jugador player2, int punteoPlayer1, int punteoPlayer2, Estadio estadio) {
        this.player1 = player1;
        this.player1.agregarPunteo(punteoPlayer1);
        this.player2 = player2;
        this.player2.agregarPunteo(punteoPlayer2);
        this.punteoPlayer1 = punteoPlayer1;
        this.punteoPlayer2 = punteoPlayer2;
        this.estadio = estadio;
    }

    /**
     * Devuelve el jugador con mayor punteo
     *
     * @return
     */
    public Jugador ganador() {
        if (punteoPlayer1 > punteoPlayer2) {
            return player1;
        } else {
            return player2;
        }
    }

    /**
     * Devuelve el jugador con menor punteo
     *
     * @return
     */
    public Jugador perdor() {
        if (punteoPlayer1 < punteoPlayer2) {
            return player1;
        } else {
            return player2;
        }
    }
    
    public int punteoMayor() {
        if (punteoPlayer1 > punteoPlayer2) {
            return punteoPlayer1;
        } else {
            return punteoPlayer2;
        }
    }
    
    public int punteoMenor() {
        if (punteoPlayer1 < punteoPlayer2) {
            return punteoPlayer1;
        } else {
            return punteoPlayer2;
        }
    }
    
    public Jugador getPlayer1() {
        return player1;
    }
    
    public Jugador getPlayer2() {
        return player2;
    }
    
    public int getPunteoPlayer1() {
        return punteoPlayer1;
    }
    
    public int getPunteoPlayer2() {
        return punteoPlayer2;
    }
    
    public Estadio getEstadio() {
        return estadio;
    }
    
    public void imprimirResultado() {
        System.out.println("\n**********************************************************");
        System.out.println("El ganador es: " + ganador().getNombre() + " con punteo: " + punteoMayor());
        System.out.println("El Perdedor es: " + perdor().getNombre() + " con punteo: " + punteoMenor());
        System.out.println("**********************************************************");
    }
    
}
