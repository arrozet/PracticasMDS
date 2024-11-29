import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voluntario extends Socio {

	private List<Adopcion> tramites;
	
	public Voluntario(Date registro, Refugio refugio) {
		super(registro, refugio);
		tramites = new ArrayList<>();
	}

	public void tramitarAdopcion( Animal animal, Adoptante adoptante ) {
		assert(animal != null) : "El animal es null";

		getRefugio().eliminarAnimalRefugiado(animal);	// El animal ya no está refugiado, ya que ha sido adoptado

		Adopcion nuevaAdopcion = new Adopcion(super.getRegistro(), animal, adoptante);
		tramites.add(nuevaAdopcion);	// Se registra la nueva adopción
	}

	public void registrar(Animal animal) {
		assert(animal != null): "El animal es null";

		assert(super.getRefugio().getAnimalesRegistrados().contains(animal)) : "El animal ya está registrado.";

		animal.setEstadoAnimal(EstadoAnimal.disponible); // Puede que fuese adoptado y lo mandasen de vuelta al refugio
		super.getRefugio().registrar(animal);
	}
	
	public List<Adopcion> getTramites(){
		return tramites;
	}

}
