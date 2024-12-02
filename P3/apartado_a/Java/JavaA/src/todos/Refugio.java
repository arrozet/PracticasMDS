package todos;

import RecepcionDonaciones.Donacion;

import java.time.Instant;
import java.util.*;

/**
 * Clase que representa un todos.Refugio de animales.
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

	// Lista para modelar la asociación con todos.Socio
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
	protected double getLiquidez() {
		return liquidez;
	}

	/**
	 * Establece la liquidez del refugio.
	 *
	 * @param liquidez Nueva liquidez del refugio.
	 */
	private void setLiquidez(double liquidez) {
		this.liquidez = liquidez;
	}

	/**
	 * Obtiene la lista de animales registrados (adoptados y no adoptados).
	 *
	 * @return Lista de animales registrados.
	 */
	public Enumeration<Animal> getAnimalesRegistrados() {
		return Collections.enumeration(animalesRegistrados);
	}

	/**
	 * Verifica si un animal está en la lista de animales registrados.
	 *
	 * @param animal El animal a buscar en la lista de animales registrados.
	 * @return {@code true} si el animal está registrado, {@code false} en caso contrario.
	 */
	public boolean containsAnimalesRegistrados(Animal animal){
		return animalesRegistrados.contains(animal);
	}

	/**
	 * Establece una nueva lista de animales registrados.
	 *
	 * @param animalesRegistrados Lista de animales registrados.
	 */
	private void setAnimalesRegistrados(List<Animal> animalesRegistrados) {
		this.animalesRegistrados = animalesRegistrados;
	}

	/**
	 * Obtiene la lista de animales refugiados (no adoptados).
	 *
	 * @return Lista de animales refugiados.
	 */
	public Enumeration<Animal> getAnimalesRefugiados() {
		return Collections.enumeration(animalesRefugiados);
	}

	/**
	 * Verifica si un animal está en la lista de animales refugiados (no adoptados).
	 *
	 * @param a El animal a buscar en la lista de animales refugiados.
	 * @return {@code true} si el animal está en la lista de animales refugiados, {@code false} en caso contrario.
	 */
	public boolean containsAnimalesRefugiados(Animal a){
		return animalesRefugiados.contains(a);
	}

	/**
	 * Establece una nueva lista de animales refugiados.
	 *
	 * @param animalesRefugiados Lista de animales refugiados.
	 */
	private void setAnimalesRefugiados(List<Animal> animalesRefugiados) {
		this.animalesRefugiados = animalesRefugiados;
	}

	/**
	 * Registra un animal en el refugio.
	 * El animal se añade a las listas de animales registrados y refugiados.
	 *
	 * @param a todos.Animal a registrar.
	 * @throws IllegalArgumentException Si el animal es null.
	 */
	protected void registrar(Animal a) {
		// Asegurarse de que las listas estén inicializadas
		assert animalesRegistrados != null : "La lista de animales registrados no está inicializada.";
		assert animalesRefugiados != null : "La lista de animales refugiados no está inicializada.";

		if (a == null) {
			throw new IllegalArgumentException("El animal no puede ser null.");
		}

		a.setEstadoAnimal(EstadoAnimal.disponible);
		animalesRegistrados.add(a);
		animalesRefugiados.add(a);

		// Verificar que el animal fue efectivamente añadido
		assert animalesRegistrados.contains(a) : "El animal no fue añadido a la lista de animales registrados.";
		assert animalesRefugiados.contains(a) : "El animal no fue añadido a la lista de animales refugiados.";
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
	 * @param animal todos.Animal que ha sido adoptado.
	 * @throws IllegalArgumentException Si el animal es null o no está adoptado.
	 */
	protected void eliminarAnimalRefugiado(Animal animal) {
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
	 * @param socio todos.Socio a agregar.
	 * @throws IllegalArgumentException Si el socio es null.
	 */
	protected void agregarSocio(Socio socio) {
		if (socio == null) {
			throw new IllegalArgumentException("El socio no puede ser null.");
		}
		if (socios.contains(socio)){
			throw new IllegalArgumentException("El socio ya estaba asociado a este refugio.");
		}

		socios.add(socio);
		socio.setRefugio(this);
	}

	/**
	 * Devuelve un Enumeration que permite iterar sobre los socios asociados al refugio.
	 *
	 * @return Un Enumeration de los socios registrados en el refugio.
	 */
	public Enumeration<Socio> getSocios() {
		return Collections.enumeration(socios);
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
		return "todos.Refugio{" +
				"liquidez=" + liquidez + " euros" +
				", animalesRegistrados=" + animalesRegistrados.size() +
				", animalesRefugiados=" + animalesRefugiados.size() +
				", socios=" + socios.size() +
				'}';
	}

}
