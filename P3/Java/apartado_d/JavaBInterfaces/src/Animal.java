import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Clase que representa un Animal en el refugio.
 * Incluye información sobre su nombre, fecha de nacimiento y estado.
 */
public class Animal {

	private EstadoAnimal estado; // Estado actual del animal (disponible, adoptado, en tratamiento)
	private Date nacimiento; // Fecha de nacimiento del animal
	private String nombre; // Nombre del animal para su identificación

	/**
	 * Constructor de la clase Animal.
	 * Valida que el nombre y la fecha de nacimiento sean válidos.
	 *
	 * @param nombre Nombre del animal. No puede ser null ni vacío.
	 * @param nacimiento Fecha de nacimiento del animal. No puede ser null ni en el futuro.
	 * @throws IllegalArgumentException Si el nombre es null o vacío, o si la fecha es inválida.
	 */
	public Animal(String nombre, Date nacimiento) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede ser null o vacío.");
		}
		if (nacimiento == null) {
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser null.");
		}
		if (nacimiento.after(Date.from(Instant.now()))) {
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
		}

		this.nacimiento = nacimiento;
		this.estado = EstadoAnimal.disponible; // Por defecto, el animal está disponible
		this.nombre = nombre;
	}

	/**
	 * Obtiene la fecha de nacimiento del animal.
	 *
	 * @return Fecha de nacimiento del animal.
	 */
	public Date getNacimiento() {
		return nacimiento;
	}

	/**
	 * Establece la fecha de nacimiento del animal.
	 *
	 * @param nacimiento Nueva fecha de nacimiento.
	 * @throws IllegalArgumentException Si la fecha es en el futuro.
	 */
	public void setNacimiento(Date nacimiento) {
		if (nacimiento == null) {
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser null.");
		}
		if (nacimiento.after(Date.from(Instant.now()))) {
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
		}

		this.nacimiento = nacimiento;
	}

	/**
	 * Obtiene el estado actual del animal.
	 *
	 * @return Estado actual del animal.
	 */
	public EstadoAnimal getEstadoAnimal() {
		return estado;
	}

	/**
	 * Establece el estado del animal.
	 *
	 * @param estado Nuevo estado del animal.
	 */
	public void setEstadoAnimal(EstadoAnimal estado) {
		this.estado = estado;
	}

	/**
	 * Verifica si el animal ha sido adoptado.
	 *
	 * @return true si el estado del animal es 'adoptado', false en caso contrario.
	 */
	public boolean estaAdoptado() {
		return estado == EstadoAnimal.adoptado;
	}

	/**
	 * Cambia el estado del animal a 'adoptado'.
	 *
	 * @throws IllegalStateException Si el animal no está disponible para adopción.
	 */
	public void adoptar() {
		if (estado != EstadoAnimal.disponible) {
			throw new IllegalStateException("Solo se pueden adoptar animales disponibles.");
		}
		estado = EstadoAnimal.adoptado;
	}

	/**
	 * Cambia el estado del animal a 'en tratamiento'.
	 *
	 * @throws IllegalStateException Si el animal ya ha sido adoptado.
	 */
	public void ponerEnTratamiento() {
		if (estado == EstadoAnimal.adoptado) {
			throw new IllegalStateException("No se puede poner en tratamiento un animal adoptado.");
		}
		estado = EstadoAnimal.enTratamiento;
	}

	/**
	 * Devuelve una representación en forma de cadena del animal.
	 *
	 * @return Cadena que describe el nombre, estado y fecha de nacimiento del animal.
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Animal{" +
				"nombre='" + nombre + '\'' +
				", estado=" + estado +
				", nacimiento=" + dateFormat.format(nacimiento) +
				'}';
	}
}
