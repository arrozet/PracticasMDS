import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que representa un Donante en el refugio.
 * Un donante es un socio que realiza donaciones monetarias al refugio.
 */
public class Donante implements Rol {

	private HashMap<Socio, Donacion> donaciones; // Lista de donaciones realizadas por todos los donantes

	/**
	 * Constructor de la clase Donante.
	 * Inicializa al donante con su fecha de inscripción y el refugio al que pertenece.
	 * También inicializa la lista de donaciones vacía.
	 *
	 */
	public Donante() {
		donaciones = new HashMap<>();
	}

	/**
	 * Realiza una donación al refugio.
	 * Valida que la cantidad donada sea positiva antes de registrar la donación.
	 * La fecha de la donación es la fecha actual del sistema.
	 *
	 * @param c Cantidad de dinero donada. Debe ser mayor que 0.
	 * @throws IllegalArgumentException Si la cantidad donada es menor o igual a 0.
	 */
	public void donar(double c, Socio socio) {
		if(!socio.getRoles().stream().anyMatch(r -> r instanceof Donante)){ // si no es donante
			throw new IllegalArgumentException("Este socio no es un voluntario");
		} else {
			if (c <= 0) {
				throw new IllegalArgumentException("La cantidad a donar debe ser positiva.");
			}

			// Registrar la donación con la fecha actual
			Donacion donacion = new Donacion(c, Date.from(Instant.now()));
			donaciones.put(socio,donacion);

			// Actualizar la liquidez del refugio
			socio.getRefugio().recibeDonacion(donacion);
		}
	}

	/**
	 * Obtiene la lista de donaciones realizadas por el donante.
	 *
	 * @return Lista de donaciones realizadas por este donante.
	 */
	public HashMap<Socio, Donacion> getDonaciones() {
		return donaciones;
	}
	public String toString() {
		return "Donante";
	}
}
