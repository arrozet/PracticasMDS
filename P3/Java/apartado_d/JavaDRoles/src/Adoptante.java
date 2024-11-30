import java.util.Date;
import java.util.Optional;

/**
 * Clase que representa un Adoptante en el refugio.
 * Un adoptante es un socio que adopta al menos un animal.
 */
public class Adoptante implements Rol {


	/**
	 * Adopta un animal a través de un voluntario.
	 *
	 * Este método valida que el animal y el voluntario no sean null y que el animal no haya sido adoptado previamente.
	 * Si todas las condiciones son válidas, se cambia el estado del animal a 'adoptado' y se registra la adopción
	 * a través del voluntario.
	 *
	 * @param animal El animal a adoptar. No puede ser null.
	 * @param adoptante El voluntario que tramita la adopción. No puede ser null.
	 * @throws IllegalArgumentException Si el animal o el voluntario son null, o si el animal ya ha sido adoptado.
	 */
	public void adoptar(Animal animal,Voluntario voluntario, Socio adoptante) throws RefugioAnimalesException {
		if(!adoptante.getRoles().stream().anyMatch(r -> r instanceof Adoptante)){ // si no es voluntario
			throw new IllegalArgumentException("Este socio no es un adoptante");
		} else {
			// Validaciones de entrada
			if (animal == null) {
				throw new IllegalArgumentException("El animal no puede ser null.");
			}
			if (adoptante == null) {
				throw new IllegalArgumentException("El socio no puede ser null.");
			}
			if (animal.estaAdoptado()) {
				throw new IllegalArgumentException("El animal ya ha sido adoptado.");
			}
			if (voluntario == null) {
				throw new IllegalArgumentException("El voluntario no puede ser null.");
			}

			// Cambiar el estado del animal a 'adoptado'
			animal.adoptar();

			// Registrar la adopción a través del voluntario
			voluntario.tramitarAdopcion(animal, adoptante);

			assert (animal.estaAdoptado()) : "El animal no está adoptado tras tramitar la adopción";
		}
	}
	public String toString() {
		return "Adoptante";
	}
}
