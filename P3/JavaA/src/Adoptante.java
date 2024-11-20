import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adoptante extends Socio implements IAdoptante {

	private List<Animal> animalesAdoptados;
	
	public Adoptante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		animalesAdoptados = new ArrayList<>();
	}
    
    public List<Animal> getAnimalesAdoptados() {
        return animalesAdoptados;
    }

    @Override
    public String toString() {
        return super.toString() + ", Animales Adoptados: " + animalesAdoptados;
    }

	@Override
	public void adoptar(Animal animal, Voluntario voluntario) {
    	assert( !animal.estaAdoptado() );
        animalesAdoptados.add(animal);
		try {
			voluntario.tramitarAdopcion(animal, this);
		} catch (RefugioAnimalesException e) {
			e.printStackTrace();
		}
    	animal.setAdoptado();
	}
}
