import java.util.Date;

public class Adopcion{
	
	private Date fecha;

	
	public Adopcion( Date fecha ) {
		this.setFecha(fecha);
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}