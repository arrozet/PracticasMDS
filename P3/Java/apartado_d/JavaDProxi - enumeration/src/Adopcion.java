import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa una adopción en el refugio.
 * Cada adopción está asociada a una fecha, un animal y un adoptante.
 */
public class Adopcion {
    private Date fecha; // Fecha en la que se realizó la adopción
    private Animal animal; // Animal adoptado
    private Socio adoptante; // Adoptante que realizó la adopción

    /**
     * Constructor de la clase Adopcion.alida que la fecha, el animal y el adoptante no sean null antes de crear la instancia.
     * V
     *
     * @param fecha Fecha de la adopción. No puede ser null.
     * @param animal Animal que ha sido adoptado. No puede ser null.
     * @param adoptante Adoptante que adopta el animal. No puede ser null.
     * @throws IllegalArgumentException Si alguno de los parámetros es null.
     */
    public Adopcion(Date fecha, Animal animal, Socio adoptante) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null.");
        }
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser null.");
        }
        if (adoptante == null) {
            throw new IllegalArgumentException("El adoptante no puede ser null.");
        }
        if( !adoptante.isAdoptante()){
            throw new IllegalArgumentException("No es un adoptante");
        }

        this.fecha = fecha;
        this.animal = animal;
        this.adoptante = adoptante;
    }

    /**
     * Obtiene la fecha de la adopción.
     *
     * @return Fecha de la adopción.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece una nueva fecha para la adopción.
     *
     * @param fecha Nueva fecha de la adopción. No puede ser null.
     * @throws IllegalArgumentException Si la fecha es null.
     */
    public void setFecha(Date fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null.");
        }
        this.fecha = fecha;
    }

    /**
     * Obtiene el animal asociado a la adopción.
     *
     * @return Animal adoptado.
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Establece un nuevo animal para la adopción.
     *
     * @param animal Nuevo animal adoptado. No puede ser null.
     * @throws IllegalArgumentException Si el animal es null.
     */
    public void setAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser null.");
        }
        this.animal = animal;
    }

    /**
     * Obtiene el adoptante asociado a la adopción.
     *
     * @return Adoptante que realizó la adopción.
     */
    public Socio getAdoptante() {
        return adoptante;
    }

    /**
     * Establece un nuevo adoptante para la adopción.
     *
     * @param adoptante Nuevo adoptante. No puede ser null.
     * @throws IllegalArgumentException Si el adoptante es null.
     */
    public void setAdoptante(Socio adoptante) {
        if (adoptante == null) {
            throw new IllegalArgumentException("El adoptante no puede ser null.");
        }
        if( !adoptante.isAdoptante() ){
            throw new IllegalArgumentException("No es un adoptante");
        }
        this.adoptante = adoptante;
    }

    /**
     * Devuelve una representación en forma de cadena de la adopción.
     * Incluye la fecha, el animal y el adoptante.
     *
     * @return Cadena que describe la adopción.
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Adopcion{" +
                "fecha=" + dateFormat.format(fecha) +
                ", animal=" + animal + // Suponiendo que Animal tiene un método getNombre
                ", adoptante=" + adoptante +
                '}';
    }
}
