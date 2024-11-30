import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase abstracta que representa un socio en el refugio.
 *
 * Un socio es una persona asociada al refugio y puede ser un adoptante,
 * voluntario o donante. No se puede instanciar directamente, ya que
 * siempre pertenece a una subclase concreta.
 */
public class Socio {

	private Date registro; // Fecha de inscripción del socio en el refugio
	private Refugio refugioInscrito; // Refugio al que el socio está asociado
	private List<Rol> roles;


	/**
	 * Constructor de la clase Socio.
	 * Valida que la fecha de inscripción y el refugio no sean null.
	 *
	 * @param fechaInscripcion Fecha en la que el socio se inscribe en el refugio. No puede ser null.
	 * @param refugio Refugio al que el socio se asocia. No puede ser null.
	 * @throws IllegalArgumentException Si la fecha o el refugio son null.
	 */
	public Socio(Date fechaInscripcion, Refugio refugio, Rol rol) {
		if (fechaInscripcion == null) {
			throw new IllegalArgumentException("La fecha de inscripción no puede ser null.");
		}
		if (refugio == null) {
			throw new IllegalArgumentException("El refugio no puede ser null.");
		}

		this.registro = fechaInscripcion;
		this.refugioInscrito = refugio;
		this.roles = new ArrayList<>();
		this.roles.add(rol);

		// Agregar este socio al refugio
		refugio.agregarSocio(this);
	}
	// Añadir un rol al socio
	public void agregarRol(Rol rol) {
		if (!roles.contains(rol)) {
			roles.add(rol);
		}
	}

	// Métodos proxy para delegar la llamada a los roles específicos
	public void tramitarAdopcion(Animal animal, Socio adoptante) throws RefugioAnimalesException {
		if(adoptante.getRoles().stream().noneMatch(rol -> rol instanceof Adoptante)){
			throw new IllegalArgumentException("No es un adoptante");
		}
		for (Rol rol : roles) {
			if (rol instanceof Voluntario) {
				((Voluntario) rol).tramitarAdopcion(animal, adoptante);
				return;
			}
		}
		throw new IllegalStateException("Este socio no tiene el rol de Voluntario.");
	}

	public void registrar(Animal animal) throws RefugioAnimalesException {
		for (Rol rol : roles) {
			if (rol instanceof Voluntario) {
				((Voluntario) rol).registrar(animal);
				return;
			}
		}
		throw new IllegalStateException("Este socio no tiene el rol de Voluntario y no puede registrar animales.");
	}

	public void adoptar(Animal animal, Socio voluntario) throws RefugioAnimalesException {
		for (Rol rol : roles) {
			if (rol instanceof Adoptante) {
				for(Rol r : voluntario.getRoles()){
					if (r instanceof Voluntario) {
						((Adoptante) rol).adoptar(animal, voluntario, this);
					}

				}
			}
		}
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void donar(double cantidad) {
		for (Rol rol : roles) {
			if (rol instanceof Donante) {
				((Donante) rol).donar(cantidad);
				return;
			}
		}
		throw new IllegalStateException("Este socio no tiene el rol de Donante.");
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
	 * Asocia el socio a un nuevo refugio.
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
	 * Incluye la clase específica del socio, la fecha de inscripción y el refugio asociado.
	 *
	 * @return Cadena descriptiva del socio.
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return this.getClass().getSimpleName().toUpperCase() +
				" | Fecha de inscripción: " + dateFormat.format(registro) +
				"; Refugio: " + refugioInscrito + "; Roles: " + roles.toString();
	}
}
