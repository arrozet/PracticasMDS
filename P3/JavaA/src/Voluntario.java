import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voluntario extends Socio {
	
	private List<Adopcion> tramites;
	
	public Voluntario(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		tramites = new ArrayList<>();
	}

	public void tramitarAdopcion( Animal animal, Adoptante adoptante ) throws RefugioAnimalesException {
		registrar(animal);
		getRefugio().animalAdoptado(animal);
	}


	public void registrar(Animal animal) {
		super.getRefugio().registrar(animal);
		tramiteAdopcion();
	}
	
	private void tramiteAdopcion() {
		tramites.add(new Adopcion( getFechaInscripcion()) );
	}
	
	public List<Adopcion> getTramites(){
		return tramites;
	}
}
