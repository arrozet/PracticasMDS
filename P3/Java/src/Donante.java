import java.util.Date;

public class Donante  extends Socio implements IDonante{
		
	
	public Donante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
	}

	@Override
	public void donar(double donacion, Date fechaDonacion) {
		super.getRefugio().recibeDonacion( new Donacion(donacion,fechaDonacion ) );
	}


}
