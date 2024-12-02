package RecepcionDonaciones;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa una donación realizada al refugio.
 * Cada donación incluye una cantidad de dinero y la fecha en la que se realizó.
 */
public class Donacion {

	private double cantidad; // Cantidad de dinero donada
	private Date fecha;      // Fecha en la que se realizó la donación

	/**
	 * Constructor de la clase RecepcionDonaciones.Donacion.
	 * Valida que la cantidad sea positiva y que la fecha no sea null.
	 *
	 * @param cantidad Cantidad de dinero donada. Debe ser mayor que 0.
	 * @param fecha Fecha en la que se realizó la donación. No puede ser null.
	 * @throws IllegalArgumentException Si la cantidad es menor o igual a 0, o si la fecha es null.
	 */
	public Donacion(double cantidad, Date fecha) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad a donar debe ser positiva.");
		}
		if (fecha == null) {
			throw new IllegalArgumentException("La fecha de la donación no puede ser null.");
		}
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	/**
	 * Obtiene la fecha de la donación.
	 *
	 * @return Fecha de la donación.
	 */
	public Date getFechaDonacion() {
		return fecha;
	}

	/**
	 * Establece una nueva fecha para la donación.
	 *
	 * @param fecha Nueva fecha de la donación. No puede ser null.
	 * @throws IllegalArgumentException Si la fecha es null.
	 */
	public void setFechaDonacion(Date fecha) {
		if (fecha == null) {
			throw new IllegalArgumentException("La fecha de la donación no puede ser null.");
		}
		this.fecha = fecha;
	}

	/**
	 * Obtiene la cantidad de dinero donada.
	 *
	 * @return Cantidad donada.
	 */
	public double getCantidadDonada() {
		return cantidad;
	}

	/**
	 * Establece una nueva cantidad de dinero para la donación.
	 *
	 * @param newCantidadDonada Nueva cantidad de dinero donada. Debe ser mayor que 0.
	 * @throws IllegalArgumentException Si la cantidad es menor o igual a 0.
	 */
	public void setCantidadDonada(double newCantidadDonada) {
		if (newCantidadDonada <= 0) {
			throw new IllegalArgumentException("La cantidad a donar debe ser positiva.");
		}
		this.cantidad = newCantidadDonada;
	}

	/**
	 * Devuelve una representación textual de la donación.
	 * Incluye la cantidad donada y la fecha en formato "dd/MM/yyyy HH:mm:ss".
	 *
	 * @return Cadena descriptiva de la donación.
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "RecepcionDonaciones.Donacion{" +
				"cantidad=" + cantidad +
				", fecha=" + dateTimeFormat.format(fecha) +
				'}';
	}
}
