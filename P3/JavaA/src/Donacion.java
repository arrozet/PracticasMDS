import java.util.Date;

public class Donacion{
	
	private double cantidadDonada;
	private Date fechaDonacion;
	
	public Donacion( double cantidad, Date fechaDonacion ) {
		this.cantidadDonada = cantidad;
		this.fechaDonacion = fechaDonacion;
	}

	public Date getFechaDonacion() {
		return fechaDonacion;
	}

	public void setFechaDonacion( Date newFecha) {
		this.fechaDonacion = newFecha;
	}

	public double getCantidadDonada() {
		return cantidadDonada;
	}

	public void setCantidadDonada( double newCantidadDonada) {
		this.cantidadDonada = newCantidadDonada;
	}
	
	
}