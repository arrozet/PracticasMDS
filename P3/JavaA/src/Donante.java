import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Donante extends Socio {
		
	private List<Donacion> donaciones;
	
	public Donante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
		donaciones = new ArrayList<>();
	}
	
	public void donar(double c) {
		assert( c > 0 ) : "La cantidad a donar debe ser positiva";

		Donacion donacion = new Donacion(c,Date.from(Instant.now())); // La donación se registra ahora mismo
		donaciones.add( donacion );
		super.getRefugio().recibeDonacion( donacion );
	}
	
	public List<Donacion> getDonaciones(){
		return donaciones;
	}


}
