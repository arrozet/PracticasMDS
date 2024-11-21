import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Donante extends Socio {
		
	private List<Donacion> donaciones;
	
	public Donante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		donaciones = new ArrayList<>();
	}
	
	public void donar(double cantidad) {
		assert( cantidad > 0 );
		Donacion donacion = new Donacion(cantidad,null);	/* ESTA MAL NO SE QUE PONER DE FECHA */
		donaciones.add( donacion );
		super.getRefugio().recibeDonacion( donacion );
	}
	
	public List<Donacion> getDonaciones(){
		return donaciones;
	}


}
