package torneotennis.entidades;

/**
 *
 * @author angelrg
 */
public class Estadio {

    String nombre;
    int capacidad;

    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public void imprimirDatos() {
        System.out.println("Nombre: " + this.nombre + ", Capacidad: " + this.capacidad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

}
