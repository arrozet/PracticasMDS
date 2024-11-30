import java.text.SimpleDateFormat;
import java.time.Instant;
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
public class Socio implements IVoluntario, IDonante, IAdoptante{

	private Date registro; // Fecha de inscripción del socio en el refugio
	private Refugio refugioInscrito; // Refugio al que el socio está asociado
	private boolean esVoluntario;
	private boolean esDonante;
	private boolean esAdoptante; //Representan si los métodos asociados a estas interfaces son accesibles
	private List<Donacion> donaciones; //En caso de ser donante, las donaciones realizadas.
	private List<Adopcion> tramites; //En caso de ser voluntario, los tramites realizados.
	private List<Adopcion> adopciones; //En caso de ser adoptante, las adopciones realizadas.
	/**
	 * Constructor de la clase Socio.
	 * Valida que la fecha de inscripción y el refugio no sean null.
	 *
	 * @param fechaInscripcion Fecha en la que el socio se inscribe en el refugio. No puede ser null.
	 * @param refugio Refugio al que el socio se asocia. No puede ser null.
	 * @throws IllegalArgumentException Si la fecha o el refugio son null.
	 */
	public Socio(Date fechaInscripcion, Refugio refugio, boolean esVoluntario, boolean esDonante, boolean esAdoptante) {
		if (fechaInscripcion == null) {
			throw new IllegalArgumentException("La fecha de inscripción no puede ser null.");
		}
		if (refugio == null) {
			throw new IllegalArgumentException("El refugio no puede ser null.");
		}


		this.registro = fechaInscripcion;
		this.refugioInscrito = refugio;
		this.esVoluntario = esVoluntario;
		this.esDonante = esDonante;
		this.esAdoptante = esAdoptante;
		this.donaciones = new ArrayList<>();
		this.tramites = new ArrayList<>();
		this.adopciones = new ArrayList<>();

		// Agregar este socio al refugio
		refugio.agregarSocio(this);
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
		return this.getClass().getSimpleName() +
				" Fecha de inscripción: " + dateFormat.format(registro) +
				"; Refugio: " + refugioInscrito;
	}

	@Override
	public void adoptar(Animal animal, Socio socio) throws RefugioAnimalesException {
		if(!this.esAdoptante){
			throw new RefugioAnimalesException("Este socio no es adoptante.");
		}
		if (!socio.esVoluntario()){
			throw new RefugioAnimalesException("El socio pasado por parámetro no es voluntario");
		}
		// Cambiar el estado del animal a 'adoptado'
		animal.adoptar();

		// Registrar la adopción a través del voluntario
		socio.tramitarAdopcion(animal, this);

		assert (animal.estaAdoptado()) : "El animal no está adoptado tras tramitar la adopción";
	}

	@Override
	public boolean esAdoptante() {
		return this.esAdoptante;
	}

	@Override
	public void setAdoptante(boolean esAdoptante) {
		this.esAdoptante = esAdoptante;
	}

	@Override
	public void donar(double c) throws RefugioAnimalesException {
		if (!this.esDonante){
			throw new RefugioAnimalesException("Este socio no es donante");
		}
		if (c <= 0) {
			throw new IllegalArgumentException("La cantidad a donar debe ser positiva.");
		}

		// Registrar la donación con la fecha actual
		Donacion donacion = new Donacion(c, Date.from(Instant.now()));
		donaciones.add(donacion);

		// Actualizar la liquidez del refugio
		getRefugio().recibeDonacion(donacion);
	}

	@Override
	public boolean esDonante() {
		return this.esDonante;
	}

	@Override
	public void setDonante(boolean esDonante) {
		this.esDonante = esDonante;
	}

	@Override
	public void tramitarAdopcion(Animal animal, Socio socio) throws RefugioAnimalesException {
		if (animal == null) {
			throw new RefugioAnimalesException("El animal no puede ser null.");
		}
		if (!this.esVoluntario){
			throw new RefugioAnimalesException("Este socio no es voluntario");
		}
		if (!socio.esDonante){
			throw new RefugioAnimalesException("El socio pasado por parámetro no es adoptante");
		}
		// Eliminar el animal de la lista de refugiados, ya que ha sido adoptado
		getRefugio().eliminarAnimalRefugiado(animal);

		// Registrar la adopción y añadirla a los trámites del voluntario
		Adopcion nuevaAdopcion = new Adopcion(getRegistro(), animal, socio);
		tramites.add(nuevaAdopcion);
	}

	@Override
	public boolean esVoluntario() {
		return this.esVoluntario;
	}

	@Override
	public void setVoluntario(boolean esVoluntario) {
		this.esVoluntario = esVoluntario;
	}
}
