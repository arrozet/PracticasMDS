import java.util.Date;

public class Donante  extends Socio {
		
	
	public Donante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
	}

	/*
	 * Debemos comprobar que la donación sea mayor que 0
	 */
	@Override
	public void donar(double donacion, Date fechaDonacion) {
		assert( donacion > 0 );
		super.getRefugio().recibeDonacion( new Donacion(donacion,fechaDonacion ) );
	}


}
