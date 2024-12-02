package todos;

import GestionAdopciones.Adopcion;
import GestionAdopciones.Adoptante;

import java.util.*;

/**
 * Clase que representa a un todos.Voluntario en el refugio.
 *
 * Un voluntario es un socio que puede registrar animales en el refugio y tramitar adopciones.
 * Los voluntarios gestionan la relación entre los adoptantes y los animales en el refugio.
 */
public class Voluntario extends Socio {

	private List<Adopcion> tramites; // Lista de adopciones tramitadas por el voluntario

	/**
	 * Constructor de la clase todos.Voluntario.
	 * Inicializa al voluntario con la fecha de registro y el refugio al que pertenece.
	 * También inicializa la lista de trámites como vacía.
	 *
	 * @param registro Fecha de inscripción del voluntario en el refugio. No puede ser null.
	 * @param refugio todos.Refugio al que pertenece el voluntario. No puede ser null.
	 * @throws IllegalArgumentException Si la fecha o el refugio son null.
	 */
	public Voluntario(Date registro, Refugio refugio) {
		super(registro, refugio);
		tramites = new ArrayList<>();
	}

	/**
	 * Tramita la adopción de un animal por un adoptante.
	 *
	 * Este método valida que el animal no sea null y que esté presente en el refugio.
	 * Si las condiciones son válidas, el animal se elimina de la lista de animales refugiados,
	 * se registra como adoptado y se añade a la lista de trámites del voluntario.
	 *
	 * @param animal El animal a adoptar. No puede ser null.
	 * @param adoptante El adoptante que adopta el animal. No puede ser null.
	 */
	public void tramitarAdopcion(Animal animal, Adoptante adoptante) {
		if (animal == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}
		assert(animal.getRefugio().equals(adoptante.getRefugio())) : "El animal y el adoptante no están en el mismo refugio";

		// Cambiar el estado del animal a 'adoptado'
		animal.adoptar();

		// Eliminar el animal de la lista de refugiados, ya que ha sido adoptado
		getRefugio().eliminarAnimalRefugiado(animal);

		// Registrar la adopción y añadirla a los trámites del voluntario
		Adopcion nuevaAdopcion = new Adopcion(new Date(), animal, adoptante);
		tramites.add(nuevaAdopcion);
	}

	/**
	 * Registra un animal en el refugio.
	 *
	 * Este método valida que el animal no sea null y que no esté ya registrado en el refugio.
	 * Si las condiciones son válidas, el animal se añade a la lista de animales registrados
	 * y refugiados del refugio.
	 *
	 * @param animal El animal a registrar. No puede ser null.
	 */
	public void registrar(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}

		// Verificar si el animal ya está registrado en el refugio
		if (super.getRefugio().containsAnimalesRegistrados(animal)) {
			throw new IllegalArgumentException("El animal ya está registrado en el refugio.");
		}

		// Establecer el estado del animal como disponible y registrarlo en el refugio
		super.getRefugio().registrar(animal);
		assert(animal.getEstadoAnimal().equals(EstadoAnimal.disponible)) : "El estado del animal no es disponible tras registrarlo";
	}

	public void ponerEnTratamiento(Animal animal){
		animal.ponerEnTratamiento();
	}

	/**
	 * Devuelve un Enumeration que permite iterar sobre las adopciones tramitadas por el voluntario.
	 *
	 * @return Un Enumeration de las adopciones tramitadas.
	 */
	public Enumeration<Adopcion> getTramites() {
		return Collections.enumeration(tramites);
	}
}
