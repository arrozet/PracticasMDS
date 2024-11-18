import java.util.Date;

public class Voluntario extends Socio implements IVoluntario{
	
	

	public Voluntario(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		super.addRol(this);
	}

	@Override
	public void tramitarAdopcion( Animal animal, Adoptante adoptante ) throws RefugioAnimalesException {
		adoptante.adoptaAnimal(animal);
	}

	@Override
	public void registrar(Animal animal, Refugio refugio) {
		refugio.registrarAnimal(animal);
	}
	
}
