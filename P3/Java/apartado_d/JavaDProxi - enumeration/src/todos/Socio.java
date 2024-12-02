package todos;

import GestionAdopciones.Adopcion;
import GestionAdopciones.Adoptante;
import RecepcionDonaciones.Donante;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase que representa un socio en el refugio.
 * Un socio es una persona asociada al refugio y puede desempeñar uno o más roles
 * como adoptante, voluntario o donante. Los roles se gestionan dinámicamente
 * mediante una lista. Además, el socio está asociado a un único refugio.
 */
public class Socio {

	private Date registro; // Fecha de inscripción del socio en el refugio
	private Refugio refugioInscrito; // todos.Refugio al que el socio está asociado
	private List<Rol> roles; // Lista dinámica de roles asociados al socio

	/**
	 * Constructor de la clase todos.Socio.
	 * Inicializa un socio con una fecha de inscripción y su primer rol.
	 * Valida que la fecha de inscripción y el refugio del rol no sean null.
	 *
	 * @param fechaInscripcion Fecha en la que el socio se inscribe en el refugio. No puede ser null.
	 * @param rol todos.Rol inicial del socio. No puede ser null.
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
	 * @param rol todos.Rol a agregar. No puede ser null.
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
	 * Busca y devuelve el primer rol del tipo especificado.
	 *
	 * @param rolClass La clase del rol a buscar (por ejemplo, todos.Voluntario.class).
	 * @return El rol encontrado del tipo especificado, o {@code null} si no existe.
	 */
	public Rol searchRole(Class<? extends Rol> rolClass) {
		for (Rol rol : roles) {
			if (rolClass.isInstance(rol)) {
				return rol;
			}
		}
		return null;
	}

	/**
	 * Devuelve una representación en forma de cadena de todos los roles asociados a un socio.
	 *
	 * Este método recorre los roles del socio y los concatena en una única cadena,
	 * separándolos por punto y coma (;).
	 *
	 * @param socio El socio cuyos roles se desean mostrar.
	 * @return Una cadena que contiene la representación textual de todos los roles del socio,
	 *         separados por punto y coma (;). Si no tiene roles, se devuelve una cadena vacía.
	 */
	private String mostrarRoles(Socio socio) {
		StringJoiner sj = new StringJoiner(";");
		Enumeration<Rol> roles = socio.getRoles();
		while( roles.hasMoreElements() ) {
			sj.add( roles.nextElement().toString() );
		}
		return sj.toString();
	}

	/**
	 * Devuelve la lista de roles asociados al socio.
	 *
	 * @return Lista de roles dinámicos asociados al socio.
	 */
	public Enumeration<Rol> getRoles() {
		return Collections.enumeration(roles);
	}

	/**
	 * Permite a este socio adoptar un animal.
	 * Requiere que este socio tenga el rol de GestionAdopciones.Adoptante y que el voluntario
	 * encargado de la adopción tenga el rol de todos.Voluntario.
	 *
	 * @param animal    todos.Animal a adoptar.
	 * @param voluntario todos.Socio voluntario encargado de la adopción.
	 * @throws IllegalArgumentException Si los roles requeridos no están asignados.
	 */
	public void adoptar(Animal animal, Socio voluntario){
		Rol rolAdoptante = searchRole(Adoptante.class);
		if (rolAdoptante == null) {
			throw new IllegalArgumentException("Este socio no tiene el rol de GestionAdopciones.Adoptante: " + roles.toString());
		}
		Rol rolVoluntario = voluntario.searchRole(Voluntario.class);
		if (rolVoluntario == null) {
			throw new IllegalArgumentException("Este socio no tiene el rol de todos.Voluntario: " + mostrarRoles(voluntario) );
		}
		((Adoptante) rolAdoptante).adoptar(animal, voluntario, this);
	}

	/**
	 * Tramita la adopción de un animal a través de este socio.
	 * Requiere que el socio tenga el rol de voluntario y que el adoptante tenga el rol de GestionAdopciones.Adoptante.
	 *
	 * @param animal     todos.Animal que será adoptado.
	 * @param adoptante  todos.Socio adoptante que adopta el animal.
	 * @throws IllegalArgumentException Si el adoptante o el voluntario no tienen los roles requeridos.
	 */
	public void tramitarAdopcion(Animal animal, Socio adoptante) {
		// Validar que el socio adoptante tiene el rol de GestionAdopciones.Adoptante
		Rol rolAdoptante = adoptante.searchRole(Adoptante.class);
		if (rolAdoptante == null) {
			throw new IllegalArgumentException("El socio adoptante no tiene el rol de GestionAdopciones.Adoptante: " + mostrarRoles(adoptante));
		}

		// Validar que este socio tiene el rol de todos.Voluntario
		Rol rolVoluntario = searchRole(Voluntario.class);
		if (rolVoluntario == null) {
			throw new IllegalArgumentException("El socio voluntario no tiene el rol de todos.Voluntario: " + this.getRoles().toString());
		}
		((Voluntario) rolVoluntario).tramitarAdopcion(animal,adoptante);
	}

	/**
	 * Registra un animal en el refugio a través de este socio.
	 * Requiere que el socio tenga el rol de voluntario.
	 *
	 * @param animal todos.Animal a registrar.
	 * @throws RefugioAnimalesException Si ocurre un error durante el registro.
	 * @throws IllegalStateException    Si el socio no tiene el rol de todos.Voluntario.
	 */
	public void registrar(Animal animal) throws RefugioAnimalesException {
		Rol voluntario = searchRole(Voluntario.class);
		if (voluntario == null) {
			throw new IllegalArgumentException("Este socio no tiene el rol de todos.Voluntario: " + roles.toString());
		}
		((Voluntario) voluntario).registrar(animal);
	}

	/**
	 * Permite a este socio realizar una donación al refugio.
	 * Requiere que el socio tenga el rol de RecepcionDonaciones.Donante.
	 *
	 * @param cantidad Cantidad de la donación.
	 * @throws IllegalStateException Si el socio no tiene el rol de RecepcionDonaciones.Donante.
	 */
	public void donar(double cantidad) {
		Rol donante = searchRole(Donante.class);
		if ( donante==null ) {
			throw new IllegalArgumentException("Este socio no tiene el rol de RecepcionDonaciones.Donante: " + roles.toString());
		}
		((Donante) donante).donar(cantidad);
	}

	public void ponerEnTratamiento(Animal animal){
		Rol voluntario = searchRole(Voluntario.class);
		if (voluntario == null) {
			throw new IllegalArgumentException("Este socio no tiene el rol de todos.Voluntario: " + roles.toString());
		}
		((Voluntario) voluntario).ponerEnTratamiento(animal);
	}

	/**
	 * Obtiene los trámites realizados por el voluntario asociado.
	 *
	 * @return Enumeración de adopciones tramitadas.
	 * @throws IllegalStateException Si el socio no tiene el rol de todos.Voluntario.
	 */
	public Enumeration<Adopcion> getTramites() {
		Rol voluntario = searchRole(Voluntario.class);
		if (voluntario == null) {
			throw new IllegalArgumentException("Este socio no tiene el rol de todos.Voluntario: " + roles.toString());
		}
		return ((Voluntario) voluntario).getTramites();
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
	private void setRegistro(Date fechaInscripcion) {
		if (fechaInscripcion == null) {
			throw new IllegalArgumentException("La fecha de inscripción no puede ser null.");
		}
		this.registro = fechaInscripcion;
	}

	/**
	 * Obtiene el refugio al que el socio está asociado.
	 *
	 * @return todos.Refugio asociado al socio.
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
	protected void setRefugio(Refugio newRefugio) {
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
				"; todos.Refugio: " + refugioInscrito + "; Roles: " + roles.toString();
	}
}
