import java.util.ArrayList;
import java.util.List;

public class Refugio{
	
	private double liquidez;
	
	private List<Animal> animalesRegistrados;
	private List<Animal> animalesRefugiados;
	private List<Donacion> donaciones;
	
	public Refugio( double liquidez ) {
		this.setLiquidez(liquidez);
		animalesRegistrados = new ArrayList<>();
		animalesRefugiados = new ArrayList<>();
	}
	
	public void registrar( Animal a) {
		animalesRegistrados.add(a);
		animalesRefugiados.add(a);
	}

	public double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(double liquidez) {
		this.liquidez = liquidez;
	}
	
	/*
	 * Función que llama la clase Donante
	 *  Esta incrementa la liquidez, del refugio  
	 */
	public void recibeDonacion( Donacion donacion ) {
		liquidez += donacion.getCantidadDonada();
		donaciones.add(donacion);
	}
	
	/* 
	 * Elimina de la lista de animales refugiados al animal adoptado
	 */
	public void animalAdoptado( Animal a) {
		animalesRefugiados.remove(a);
		a.setAdoptado();
	}
}