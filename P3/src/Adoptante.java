import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adoptante extends Socio implements IAdoptante {
    
	private List<Animal> animalesAdoptados;
	
	public Adoptante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		super.addRol(this);
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

	@Override
	public void adoptar(Animal animal) {
		animalesAdoptados.add( animal );
	}
}
