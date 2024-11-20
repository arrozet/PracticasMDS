import java.util.Date;
import java.util.List;

public class Voluntario extends Socio implements IVoluntario{
	
	private List<Adopcion> tramites;
	
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
		tramiteAdopcion();
		super.getRefugio().registrar(animal);
	}
	
	private void tramiteAdopcion() {
		tramites.add(new Adopcion( getFechaInscripcion()) );
	}
}
