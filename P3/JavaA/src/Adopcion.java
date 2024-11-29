import java.util.Date;

public class Adopcion {
    private Date fecha;
    private Animal animal;
    private Adoptante adoptante;

    public Adopcion(Date fecha, Animal animal, Adoptante adoptante) {
        assert(fecha != null) : "La fecha no puede ser null";
        assert(animal != null) : "El animal no puede ser null";
        assert(adoptante != null) : "El adoptante no puede ser null";

        this.fecha = fecha;
        this.animal = animal;
        this.adoptante = adoptante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

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
