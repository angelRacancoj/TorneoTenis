package torneotennis.entidades;

/**
 *
 * @author angelrg
 */
public class Jugador {

    String nombre;
    int edad;
    int punteo;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Jugador(String nombre, int edad, int punteo) {
        this.nombre = nombre;
        this.edad = edad;
        this.punteo = punteo;
    }

    /**
     * Este metodo no es util para agregar los puntos obtenidos por el jugador a
     * lo largo de los torneos
     *
     * @param punteo
     */
    public void agregarPunteo(int punteo) {
        this.punteo += punteo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getPunteo() {
        return punteo;
    }

    public void printMe() {
        System.out.println("Info: " + this.getNombre() + ", Edad: " + this.getEdad() + ", Punteo: " + this.getPunteo());
    }

}
