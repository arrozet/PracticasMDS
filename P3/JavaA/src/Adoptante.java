import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adoptante extends Socio  {

	private List<Animal> animalesAdoptados;
	
	public Adoptante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		animalesAdoptados = new ArrayList<>();
	}
	
    public void adoptaAnimal(Animal animal) throws RefugioAnimalesException {
        
    	if (!animal.estaAdoptado()) {
            animal.setAdoptado();
            animalesAdoptados.add(animal);
        }else {
        	throw new RefugioAnimalesException("El animal ya se encontraba adoptado");
        }
    }
    
    public List<Animal> getAnimalesAdoptados() {
        return animalesAdoptados;
    }

    @Override
    public String toString() {
        return super.toString() + ", Animales Adoptados: " + animalesAdoptados;
    }


	public void adoptar(Animal animal, Voluntario voluntario) {
		try {
			voluntario.tramitarAdopcion(animal, this);
		} catch (RefugioAnimalesException e) {
			System.err.print(e.getMessage());
		}
	}
}
