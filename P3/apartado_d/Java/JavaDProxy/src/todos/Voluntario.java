package todos;

import GestionAdopciones.Adopcion;
import GestionAdopciones.Adoptante;

import java.util.*;

/**
 * Clase que representa el rol de Voluntario dentro del sistema.
 *
 * Un Voluntario es un socio que tiene la capacidad de registrar nuevos animales en el refugio,
 * tramitar adopciones y poner animales en tratamiento. Además, lleva un registro de todas las
 * adopciones que ha tramitado.
 */
public class Voluntario implements Rol {
	private Refugio refugio; // Refugio asociado al voluntario
	private List<Adopcion> tramites; // Lista de adopciones tramitadas por el voluntario

	/**
	 * Constructor de la clase Voluntario.
	 *
	 * @param refugio Refugio al que está asociado el voluntario. No puede ser null.
	 * @throws IllegalArgumentException Si el refugio es null.
	 */
	public Voluntario(Refugio refugio) {
		if (refugio == null) {
			throw new IllegalArgumentException("El refugio no puede ser null.");
		}
		this.refugio = refugio;
		tramites = new ArrayList<>();
	}

	/**
	 * Obtiene el refugio asociado al voluntario.
	 *
	 * @return Refugio asociado al voluntario.
	 */
	public Refugio getRefugio() {
		return refugio;
	}

	/**
	 * Tramita la adopción de un animal por parte de un socio adoptante.
	 *
	 * @param animal    Animal a ser adoptado. No puede ser null.
	 * @param adoptante Socio adoptante que adopta al animal. Debe tener el rol de Adoptante.
	 * @throws IllegalArgumentException Si el animal es null, el adoptante no tiene el rol de Adoptante
	 *                                  o si el animal y el adoptante no pertenecen al mismo refugio.
	 */
	public void tramitarAdopcion(Animal animal, Socio adoptante) {
		if (animal == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}
		if (adoptante.searchRole(Adoptante.class) == null) {
			throw new IllegalArgumentException("El socio no tiene el rol de Adoptante.");
		}
		assert (animal.getRefugio().equals(adoptante.getRefugio())) : "El animal y el adoptante no están en el mismo refugio.";

		// Cambiar el estado del animal a 'adoptado'
		animal.adoptar();

		// Eliminar el animal de la lista de refugiados, ya que ha sido adoptado
		refugio.eliminarAnimalRefugiado(animal);

		// Registrar la adopción y añadirla a los trámites del voluntario
		Adopcion nuevaAdopcion = new Adopcion(new Date(), animal, adoptante);
		tramites.add(nuevaAdopcion);
	}

	/**
	 * Registra un nuevo animal en el refugio.
	 *
	 * @param animal Animal a registrar. No puede ser null.
	 * @throws IllegalArgumentException Si el animal es null o ya está registrado en el refugio.
	 * @throws AssertionError           Si el estado del animal no es 'disponible' tras registrarlo.
	 */
	public void registrar(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}

		// Verificar si el animal ya está registrado en el refugio
		if (refugio.containsAnimalesRegistrados(animal)) {
			throw new IllegalArgumentException("El animal ya está registrado en el refugio.");
		}

		// Establecer el estado del animal como disponible y registrarlo en el refugio
		refugio.registrar(animal);
		assert (animal.getEstadoAnimal().equals(EstadoAnimal.disponible)) : "El estado del animal no es disponible tras registrarlo.";
	}

	/**
	 * Cambia el estado de un animal a 'en tratamiento'.
	 *
	 * @param animal Animal que será puesto en tratamiento.
	 */
	public void ponerEnTratamiento(Animal animal) {
		animal.ponerEnTratamiento();
	}

	/**
	 * Obtiene un enumerador de las adopciones tramitadas por el voluntario.
	 *
	 * @return Enumeración de adopciones tramitadas.
	 */
	public Enumeration<Adopcion> getTramites() {
		return Collections.enumeration(tramites);
	}

	/**
	 * Devuelve una representación textual del voluntario.
	 *
	 * @return Nombre de la clase del rol (Voluntario).
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
