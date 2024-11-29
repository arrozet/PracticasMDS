import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Refugio{
	
	private double liquidez;
	
	private List<Animal> animalesRegistrados;	// Animales adoptados y no adoptados (todos los que están o alguna vez estuvieron)
	private List<Animal> animalesRefugiados;	// Solo los animales NO adoptados

	// Para modelar la asociación con Socio
	private List<Socio> socios;


	public Refugio() {
		this.setLiquidez( 0.0 );	// Inicializamos el refugio con 0 liquidez
		animalesRegistrados = new ArrayList<>();
		animalesRefugiados = new ArrayList<>();
		socios = new ArrayList<>();
	}

	public double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(double liquidez) {
		this.liquidez = liquidez;
	}

	public List<Animal> getAnimalesRegistrados() {
		return animalesRegistrados;
	}

	public void setAnimalesRegistrados(List<Animal> animalesRegistrados) {
		this.animalesRegistrados = animalesRegistrados;
	}

	public List<Animal> getAnimalesRefugiados() {
		return animalesRefugiados;
	}

	public void setAnimalesRefugiados(List<Animal> animalesRefugiados) {
		this.animalesRefugiados = animalesRefugiados;
	}

	/* Funciones sobre los animales */
	public void registrar(Animal a) {
		animalesRegistrados.add(a);
		animalesRefugiados.add(a);
	}
	
	/*
	 * Incrementa la liquidez del refugio en la cuantía de la donación
	 */
	public void recibeDonacion(Donacion donacion) {
		Date ahora = Date.from(Instant.now());
		assert(donacion.getCantidadDonada() > 0) : "La donación debe ser de una cuantía de dinero positiva";
		assert(donacion.getFechaDonacion().equals(ahora) ||
				donacion.getFechaDonacion().before(ahora)) : "La donación no puede ocurrir en el futuro";

		liquidez += donacion.getCantidadDonada();
	}
	
	/* 
	 * Elimina de la lista de animales refugiados al animal ha sido adoptado
	 */
	public void eliminarAnimalRefugiado(Animal animal) {
		assert(animal != null): "El animal es null";
		assert(animal.estaAdoptado()): "El animal no estaba adoptado";

		if(animal.estaAdoptado()){
			assert(!animalesRefugiados.contains(animal));
			animalesRefugiados.remove(animal);
		}
	}

	public void agregarSocio(Socio socio) {
		assert(socio != null) : "El socio no puede ser null";
		if (!socios.contains(socio)) {
			socios.add(socio);
			socio.setRefugio(this);
		}
	}
}