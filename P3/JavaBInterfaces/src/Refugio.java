import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un Refugio de animales.
 *
 * El refugio gestiona los animales registrados (tanto adoptados como no adoptados),
 * los animales refugiados (no adoptados) y los socios que interactúan con el refugio.
 * Además, controla las donaciones y la liquidez del refugio.
 */
public class Refugio {

	private double liquidez; // Liquidez total del refugio

	// Listas para gestionar los animales
	private List<Animal> animalesRegistrados; // Todos los animales registrados en el refugio
	private List<Animal> animalesRefugiados;  // Solo los animales NO adoptados

	// Lista para modelar la asociación con Socio
	private List<Socio> socios;

	/**
	 * Constructor del refugio.
	 * Inicializa el refugio con una liquidez de 0 y listas vacías de animales y socios.
	 */
	public Refugio() {
		this.setLiquidez(0.0); // Inicializamos el refugio con 0 liquidez
		animalesRegistrados = new ArrayList<>();
		animalesRefugiados = new ArrayList<>();
		socios = new ArrayList<>();
	}

	/**
	 * Obtiene la liquidez actual del refugio.
	 *
	 * @return Liquidez del refugio.
	 */
	public double getLiquidez() {
		return liquidez;
	}

	/**
	 * Establece la liquidez del refugio.
	 *
	 * @param liquidez Nueva liquidez del refugio.
	 */
	public void setLiquidez(double liquidez) {
		this.liquidez = liquidez;
	}

	/**
	 * Obtiene la lista de animales registrados (adoptados y no adoptados).
	 *
	 * @return Lista de animales registrados.
	 */
	public List<Animal> getAnimalesRegistrados() {
		return animalesRegistrados;
	}

	/**
	 * Establece una nueva lista de animales registrados.
	 *
	 * @param animalesRegistrados Lista de animales registrados.
	 */
	public void setAnimalesRegistrados(List<Animal> animalesRegistrados) {
		this.animalesRegistrados = animalesRegistrados;
	}

	/**
	 * Obtiene la lista de animales refugiados (no adoptados).
	 *
	 * @return Lista de animales refugiados.
	 */
	public List<Animal> getAnimalesRefugiados() {
		return animalesRefugiados;
	}

	/**
	 * Establece una nueva lista de animales refugiados.
	 *
	 * @param animalesRefugiados Lista de animales refugiados.
	 */
	public void setAnimalesRefugiados(List<Animal> animalesRefugiados) {
		this.animalesRefugiados = animalesRefugiados;
	}

	/**
	 * Registra un animal en el refugio.
	 * El animal se añade a las listas de animales registrados y refugiados.
	 *
	 * @param a Animal a registrar.
	 * @throws IllegalArgumentException Si el animal es null.
	 */
	public void registrar(Animal a) {
		if (a == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}
		animalesRegistrados.add(a);
		animalesRefugiados.add(a);
	}

	/**
	 * Incrementa la liquidez del refugio según la cantidad de una donación.
	 *
	 * @param donacion Donación recibida por el refugio.
	 * @throws IllegalArgumentException Si la cantidad de la donación es menor o igual a 0,
	 *                                  o si la fecha de la donación es en el futuro.
	 */
	public void recibeDonacion(Donacion donacion) {
		if (donacion.getCantidadDonada() <= 0) {
			throw new IllegalArgumentException("La donación debe ser de una cuantía de dinero positiva.");
		}
		if (donacion.getFechaDonacion().after(Date.from(Instant.now()))) {
			throw new IllegalArgumentException("La fecha de la donación no puede ser en el futuro.");
		}
		liquidez += donacion.getCantidadDonada();
	}

	/**
	 * Elimina un animal de la lista de animales refugiados si ha sido adoptado.
	 *
	 * @param animal Animal que ha sido adoptado.
	 * @throws IllegalArgumentException Si el animal es null o no está adoptado.
	 */
	public void eliminarAnimalRefugiado(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}
		if (!animal.estaAdoptado()) {
			throw new IllegalArgumentException("El animal no está adoptado.");
		}
		animalesRefugiados.remove(animal);
	}

	/**
	 * Agrega un socio al refugio y establece la relación bidireccional entre
	 * el socio y el refugio.
	 *
	 * @param socio Socio a agregar.
	 * @throws IllegalArgumentException Si el socio es null.
	 */
	public void agregarSocio(Socio socio) {
		if (socio == null) {
			throw new IllegalArgumentException("El socio no puede ser null.");
		}
		if (!socios.contains(socio)) {
			socios.add(socio);
			socio.setRefugio(this);
		}
	}

	/**
	 * Obtiene la lista de socios asociados al refugio.
	 *
	 * @return Lista de socios registrados en el refugio.
	 */
	public List<Socio> getSocios() {
		return socios;
	}

	/**
	 * Devuelve una representación textual del refugio.
	 * Incluye la liquidez, la cantidad de animales registrados y refugiados,
	 * y la cantidad de socios asociados al refugio.
	 *
	 * @return Cadena descriptiva del refugio.
	 */
	@Override
	public String toString() {
		return "Refugio{" +
				"liquidez=" + liquidez + " euros" +
				", animalesRegistrados=" + animalesRegistrados.size() +
				", animalesRefugiados=" + animalesRefugiados.size() +
				", socios=" + socios.size() +
				'}';
	}

}