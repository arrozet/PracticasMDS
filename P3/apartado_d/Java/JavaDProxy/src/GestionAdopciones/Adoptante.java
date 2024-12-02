package GestionAdopciones;

import todos.*;

/**
 * Clase que representa un GestionAdopciones.Adoptante en el refugio.
 * Un adoptante es un socio que adopta al menos un animal.
 */
public class Adoptante implements Rol {

	private Refugio refugio;
	/**
	 * Constructor de la clase GestionAdopciones.Adoptante.
	 *

	 */
	public Adoptante(Refugio refugio) {
		this.refugio=refugio;
	}

	public Refugio getRefugio() {
		return refugio;
	}

	/**
	 * Adopta un animal a través de un voluntario.
	 * Este método valida que el animal y el voluntario no sean null y que el animal no haya sido adoptado previamente.
	 * Si todas las condiciones son válidas, se cambia el estado del animal a 'adoptado' y se registra la adopción
	 * a través del voluntario.
	 *
	 * @param animal El animal a adoptar. No puede ser null.
	 * @param voluntario El voluntario que tramita la adopción. No puede ser null.
	 * @throws IllegalArgumentException Si el animal o el voluntario son null, o si el animal ya ha sido adoptado.
	 */
	public void adoptar(Animal animal, Socio voluntario, Socio adoptante) {
		// Validaciones de entrada
		if (animal == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}
		if (voluntario == null) {
			throw new IllegalArgumentException("El voluntario no puede ser null.");
		}
		if (animal.estaAdoptado()) {
			throw new IllegalArgumentException("El animal ya ha sido adoptado.");
		}

		// Todas las personas involucradas deben estar en el mismo refugio
		assert(adoptante.getRefugio().equals(voluntario.getRefugio())) : "todos.Voluntario y adoptante deben estar en el mismo refugio";

		// Registrar la adopción a través del voluntario
		voluntario.tramitarAdopcion(animal, adoptante);

		assert (animal.estaAdoptado()) : "El animal no está adoptado tras tramitar la adopción";
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
