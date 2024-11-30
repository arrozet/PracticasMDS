import java.util.Date;

/**
 * Clase que representa un Adoptante en el refugio.
 * Un adoptante es un socio que adopta al menos un animal.
 */
public class Adoptante extends Socio {

	/**
	 * Constructor de la clase Adoptante.
	 *
	 * @param registro Fecha en la que el adoptante se inscribe en el refugio. No puede ser null.
	 * @param refugio Refugio al que pertenece el adoptante. No puede ser null.
	 */
	public Adoptante(Date registro, Refugio refugio) {
		super(registro, refugio);
	}

	/**
	 * Adopta un animal a través de un voluntario.
	 *
	 * Este método valida que el animal y el voluntario no sean null y que el animal no haya sido adoptado previamente.
	 * Si todas las condiciones son válidas, se cambia el estado del animal a 'adoptado' y se registra la adopción
	 * a través del voluntario.
	 *
	 * @param animal El animal a adoptar. No puede ser null.
	 * @param voluntario El voluntario que tramita la adopción. No puede ser null.
	 * @throws IllegalArgumentException Si el animal o el voluntario son null, o si el animal ya ha sido adoptado.
	 */
	public void adoptar(Animal animal, Voluntario voluntario) throws RefugioAnimalesException {
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

		// Registrar la adopción a través del voluntario
		voluntario.tramitarAdopcion(animal, this);

		assert (animal.estaAdoptado()) : "El animal no está adoptado tras tramitar la adopción";
	}
}
