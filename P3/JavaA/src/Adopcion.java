import java.util.Date;

public class Adopcion {
    private Date fecha;
    private Animal animal;
    private Adoptante adoptante;

    public Adopcion(Date fecha, Animal animal, Adoptante adoptante) {
        this.fecha = fecha;
        this.animal = animal;
        this.adoptante = adoptante;
    }

    /* Funciones sobre la fecha de la adopcion */
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /* Funciones sobre el animal */
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /* Funciones sobre el adoptante */
    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    @Override
    public String toString() {
        return "Adopcion{" + "fecha=" + fecha + ", animal=" + animal + ", adoptante=" + adoptante + '}';
    }
}
