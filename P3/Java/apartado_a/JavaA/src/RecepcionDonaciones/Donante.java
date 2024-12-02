package RecepcionDonaciones;

import todos.Refugio;
import todos.Socio;

import java.time.Instant;
import java.util.*;

/**
 * Clase que representa un RecepcionDonaciones.Donante en el refugio.
 * Un donante es un socio que realiza donaciones monetarias al refugio.
 */
public class Donante extends Socio {

	private List<Donacion> donaciones; // Lista de donaciones realizadas por el donante

	/**
	 * Constructor de la clase RecepcionDonaciones.Donante.
	 * Inicializa al donante con su fecha de inscripción y el refugio al que pertenece.
	 * También inicializa la lista de donaciones vacía.
	 *
	 * @param fechaInscripcion Fecha en la que el donante se inscribe en el refugio. No puede ser null.
	 * @param refugio todos.Refugio al que pertenece el donante. No puede ser null.
	 */
	public Donante(Date fechaInscripcion, Refugio refugio, double cantidad) {
		super(fechaInscripcion, refugio);
		donaciones = new ArrayList<>();
		this.donar(cantidad);
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
		//double liquidezAnterior = super.getRefugio().getLiquidez();	// Para el assert
		super.getRefugio().recibeDonacion(donacion);
		//assert((super.getRefugio().getLiquidez() - liquidezAnterior) == donacion.getCantidadDonada())
		//		: "La donación no se ha completado con éxito";
	}

	/**
	 * Devuelve un Enumeration que permite iterar sobre las donaciones realizadas.
	 *
	 * @return Un Enumeration de las donaciones registradas.
	 */
	public Enumeration<Donacion> getDonaciones() {
		return Collections.enumeration(donaciones);
	}
}
