import java.util.Date;

public class Voluntario extends Socio implements IVoluntario{
	
	
	
	public Voluntario(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
	}

	@Override
	public void tramitarAdopcion( Animal animal, Adoptante adoptante ) throws RefugioAnimalesException {
		adoptante.adoptaAnimal(animal);
		getRefugio().animalAdoptado(animal);
	}

	@Override
	public void registrar(Animal animal) {
		super.getRefugio().registrarAnimal(animal);
	}
	
}
