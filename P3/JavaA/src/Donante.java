import java.util.Date;

public class Donante  extends Socio {
		
	
	public Donante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
	}


	public void donar(double donacion, Date fechaDonacion) {
		super.getRefugio().recibeDonacion( new Donacion(donacion,fechaDonacion ) );
	}


}
