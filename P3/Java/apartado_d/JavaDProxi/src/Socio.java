import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase que representa un socio en el refugio.
 *
 * Un socio es una persona asociada al refugio y puede desempeñar uno o más roles
 * como adoptante, voluntario o donante. Los roles se gestionan dinámicamente
 * mediante una lista. Además, el socio está asociado a un único refugio.
 */
public class Socio {

	private Date registro; // Fecha de inscripción del socio en el refugio
	private Refugio refugioInscrito; // Refugio al que el socio está asociado
	private List<Rol> roles; // Lista dinámica de roles asociados al socio

	/**
	 * Constructor de la clase Socio.
	 * Inicializa un socio con una fecha de inscripción y su primer rol.
	 * Valida que la fecha de inscripción y el refugio del rol no sean null.
	 *
	 * @param fechaInscripcion Fecha en la que el socio se inscribe en el refugio. No puede ser null.
	 * @param rol Rol inicial del socio. No puede ser null.
	 * @throws IllegalArgumentException Si la fecha o el rol son null.
	 */
	public Socio(Date fechaInscripcion, Rol rol) {
		if (fechaInscripcion == null) {
			throw new IllegalArgumentException("La fecha de inscripción no puede ser null.");
		}

		this.registro = fechaInscripcion;
		this.refugioInscrito = rol.getRefugio();
		this.roles = new ArrayList<>();
		this.roles.add(rol);

		// Agregar este socio al refugio
		rol.getRefugio().agregarSocio(this);
	}

	/**
	 * Agrega un rol al socio.
	 * Valida que el rol pertenezca al mismo refugio y que no esté ya asignado.
	 *
	 * @param rol Rol a agregar. No puede ser null.
	 * @throws IllegalArgumentException Si el rol pertenece a un refugio diferente
	 *                                  o si el rol ya está asignado al socio.
	 */
	public void agregarRol(Rol rol) {
		if (refugioInscrito != rol.getRefugio()) {
			throw new IllegalArgumentException("Todos los roles tienen que estar en el mismo refugio.");
		}
		if (roles.toString().contains(rol.toString())) {
			System.err.printf("El rol %s ya estaba asignado al socio. No se ha introducido de nuevo.%n", rol);
		} else {
			roles.add(rol);
		}
	}

	/**
	 * Devuelve la lista de roles asociados al socio.
	 *
	 * @return Lista de roles dinámicos asociados al socio.
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * Tramita la adopción de un animal a través de este socio.
	 * Requiere que el socio tenga el rol de voluntario y que el adoptante tenga el rol de Adoptante.
	 *
	 * @param animal     Animal que será adoptado.
	 * @param adoptante  Socio adoptante que adopta el animal.
	 * @throws RefugioAnimalesException Si ocurre un error durante la adopción.
	 * @throws IllegalArgumentException Si el adoptante o el voluntario no tienen los roles requeridos.
	 */
	public void tramitarAdopcion(Animal animal, Socio adoptante) throws RefugioAnimalesException {
		if (adoptante.getRoles().stream().noneMatch(rol -> rol instanceof Adoptante)) {
			throw new IllegalArgumentException("El socio adoptante no tiene el rol de Adoptante: " + adoptante.getRoles().toString());
		}
		if (this.getRoles().stream().noneMatch(rol -> rol instanceof Voluntario)) {
			throw new IllegalArgumentException("El socio voluntario no tiene el rol de Voluntario: " + this.getRoles().toString());
		}
		for (Rol rol : roles) {
			if (rol instanceof Voluntario) {
				((Voluntario) rol).tramitarAdopcion(animal, adoptante);
				return;
			}
		}
	}

	/**
	 * Registra un animal en el refugio a través de este socio.
	 * Requiere que el socio tenga el rol de voluntario.
	 *
	 * @param animal Animal a registrar.
	 * @throws RefugioAnimalesException Si ocurre un error durante el registro.
	 * @throws IllegalStateException    Si el socio no tiene el rol de Voluntario.
	 */
	public void registrar(Animal animal) throws RefugioAnimalesException {
		if (this.getRoles().stream().noneMatch(rol -> rol instanceof Voluntario)) {
			throw new IllegalArgumentException("Este socio no tiene el rol de Voluntario: " + roles.toString());
		}
		for (Rol rol : roles) {
			if (rol instanceof Voluntario) {
				((Voluntario) rol).registrar(animal);
				return;
			}
		}
	}

	/**
	 * Permite a este socio adoptar un animal.
	 * Requiere que este socio tenga el rol de Adoptante y que el voluntario
	 * encargado de la adopción tenga el rol de Voluntario.
	 *
	 * @param animal    Animal a adoptar.
	 * @param voluntario Socio voluntario encargado de la adopción.
	 * @throws RefugioAnimalesException Si ocurre un error durante la adopción.
	 * @throws IllegalArgumentException Si los roles requeridos no están asignados.
	 */
	public void adoptar(Animal animal, Socio voluntario) throws RefugioAnimalesException {
		if (this.getRoles().stream().noneMatch(rol -> rol instanceof Adoptante)) {
			throw new IllegalArgumentException("Este socio no tiene el rol de Adoptante: " + roles.toString());
		}
		if (voluntario.getRoles().stream().noneMatch(rol -> rol instanceof Voluntario)) {
			throw new IllegalArgumentException("Este socio no tiene el rol de Voluntario: " + voluntario.getRoles().toString());
		}

		for (Rol rol : roles) {
			if (rol instanceof Adoptante) {
				for (Rol r : voluntario.getRoles()) {
					if (r instanceof Voluntario) {
						((Adoptante) rol).adoptar(animal, voluntario, this);
						return;
					}
				}
			}
		}
	}

	/**
	 * Permite a este socio realizar una donación al refugio.
	 * Requiere que el socio tenga el rol de Donante.
	 *
	 * @param cantidad Cantidad de la donación.
	 * @throws IllegalStateException Si el socio no tiene el rol de Donante.
	 */
	public void donar(double cantidad) {
		if (this.getRoles().stream().noneMatch(rol -> rol instanceof Donante)) {
			throw new IllegalArgumentException("Este socio no tiene el rol de Donante: " + roles.toString());
		}
		for (Rol rol : roles) {
			if (rol instanceof Donante) {
				((Donante) rol).donar(cantidad);
				return;
			}
		}
	}

	/**
	 * Obtiene los trámites realizados por el voluntario asociado.
	 *
	 * @return Enumeración de adopciones tramitadas.
	 * @throws IllegalStateException Si el socio no tiene el rol de Voluntario.
	 */
	public Enumeration<Adopcion> getTramites() {
		if (this.getRoles().stream().noneMatch(rol -> rol instanceof Voluntario)) {
			throw new IllegalArgumentException("Este socio no tiene el rol de Voluntario: " + roles.toString());
		}
		for (Rol rol : roles) {
			if (rol instanceof Voluntario) {
				return ((Voluntario) rol).getTramites();
			}
		}
		return null; // Aquí no va a llegar nunca, pero Java necesita que ponga un return para que compile
	}

	/**
	 * Obtiene la fecha de inscripción del socio en el refugio.
	 *
	 * @return Fecha de inscripción del socio.
	 */
	public Date getRegistro() {
		return registro;
	}

	/**
	 * Establece una nueva fecha de inscripción para el socio.
	 *
	 * @param fechaInscripcion Nueva fecha de inscripción. No puede ser null.
	 * @throws IllegalArgumentException Si la fecha es null.
	 */
	public void setRegistro(Date fechaInscripcion) {
		if (fechaInscripcion == null) {
			throw new IllegalArgumentException("La fecha de inscripción no puede ser null.");
		}
		this.registro = fechaInscripcion;
	}

	/**
	 * Obtiene el refugio al que el socio está asociado.
	 *
	 * @return Refugio asociado al socio.
	 */
	public Refugio getRefugio() {
		return refugioInscrito;
	}

	/**
	 * Establece un nuevo refugio para el socio.
	 *
	 * @param newRefugio Nuevo refugio al que el socio estará asociado. No puede ser null.
	 * @throws IllegalArgumentException Si el refugio es null.
	 */
	public void setRefugio(Refugio newRefugio) {
		if (newRefugio == null) {
			throw new IllegalArgumentException("El nuevo refugio no puede ser null.");
		}
		this.refugioInscrito = newRefugio;
	}

	/**
	 * Devuelve una representación textual del socio.
	 * Incluye la fecha de inscripción, el refugio y los roles asociados.
	 *
	 * @return Cadena descriptiva del socio.
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return this.getClass().getSimpleName() + " | Fecha de inscripción: " + dateFormat.format(registro) +
				"; Refugio: " + refugioInscrito + "; Roles: " + roles.toString();
	}
}
