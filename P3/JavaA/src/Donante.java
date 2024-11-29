import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un Donante en el refugio.
 * Un donante es un socio que realiza donaciones monetarias al refugio.
 */
public class Donante extends Socio {

	private List<Donacion> donaciones; // Lista de donaciones realizadas por el donante

	/**
	 * Constructor de la clase Donante.
	 * Inicializa al donante con su fecha de inscripción y el refugio al que pertenece.
	 * También inicializa la lista de donaciones vacía.
	 *
	 * @param fechaInscripcion Fecha en la que el donante se inscribe en el refugio. No puede ser null.
	 * @param refugio Refugio al que pertenece el donante. No puede ser null.
	 */
	public Donante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		donaciones = new ArrayList<>();
	}

	/**
	 * Realiza una donación al refugio.
	 * Valida que la cantidad donada sea positiva antes de registrar la donación.
	 * La fecha de la donación es la fecha actual del sistema.
	 *
	 * @param c Cantidad de dinero donada. Debe ser mayor que 0.
	 * @throws IllegalArgumentException Si la cantidad donada es menor o igual a 0.
	 */
	public void donar(double c) {
		if (c <= 0) {
			throw new IllegalArgumentException("La cantidad a donar debe ser positiva.");
		}

		// Registrar la donación con la fecha actual
		Donacion donacion = new Donacion(c, Date.from(Instant.now()));
		donaciones.add(donacion);

		// Actualizar la liquidez del refugio
		super.getRefugio().recibeDonacion(donacion);
	}

	/**
	 * Obtiene la lista de donaciones realizadas por el donante.
	 *
	 * @return Lista de donaciones realizadas por este donante.
	 */
	public List<Donacion> getDonaciones() {
		return donaciones;
	}
}
