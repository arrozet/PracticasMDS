import java.util.ArrayList;
import java.util.List;

public class Refugio{
	
	private double liquidez;
	
	private List<Animal> animalesRegistrados;	/* Animales que han sido alguna vez parte del refugio */
	private List<Animal> animalesRefugiados;	/* Animales que actualmente permanecen en  el refugio */
	
	public Refugio() {
		this.setLiquidez( 0.0 );	/* Inicializamos el refugio con 0 liquidez */
		animalesRegistrados = new ArrayList<>();
		animalesRefugiados = new ArrayList<>();
	}
	
	/* Funciones sobre liquidez */
	public double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(double liquidez) {
		this.liquidez = liquidez;
	}
	
	/* Funciones sobre los animales */
	public void registrar( Animal a) {
		animalesRegistrados.add(a);
		animalesRefugiados.add(a);
	}
	
	/*
	 * Función que llama la clase Donante
	 *  Esta incrementa la liquidez, del refugio  
	 */
	public void recibeDonacion( Donacion donacion ) {
		liquidez += donacion.getCantidadDonada();
	}
	
	/* 
	 * Elimina de la lista de animales refugiados al animal adoptado
	 */
	public void animalAdoptado( Animal a) {
		animalesRefugiados.remove(a);
	}
}