import java.util.ArrayList;
import java.util.List;

public class Refugio{
	
	private double liquidez;
	
	private List<Animal> animalesRegistrados;
	private List<Donacion> donaciones;
	
	public Refugio( double liquidez ) {
		this.setLiquidez(liquidez);
		animalesRegistrados = new ArrayList<>();
	}
	
	public void registrar( Animal a) {
		
	}

	public double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(double liquidez) {
		this.liquidez = liquidez;
	}
	
	public void registrarAnimal( Animal animal ) {	// Quizás debería mostrar excepción
		animalesRegistrados.add(animal);
	}
	
	public void recibeDonacion( Donacion donacion ) {
		liquidez += donacion.getCantidadDonada();
		donaciones.add(donacion);
	}
	
}