import java.util.Date;

public class Donante implements IDonante,Rol{
	
	private Refugio refugio;
	
	public Donante( Refugio refugio) {
		this.refugio = refugio;
	}
	
	@Override
	public void donar(double donacion, Date fechaDonacion) {
		getRefugio().recibeDonacion( new Donacion(donacion,fechaDonacion ) );
	}
	
	private Refugio getRefugio() {
		return refugio;
	}

}
