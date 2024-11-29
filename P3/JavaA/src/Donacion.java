import java.util.Date;

public class Donacion{
	
	private double cantidad;
	private Date fecha;
	
	public Donacion( double cantidad, Date fecha ) {
		assert(cantidad > 0):"La cantidad a donar debe ser positiva";
		assert(fecha != null):"La fecha debe ser distinta de null";
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Date getFechaDonacion() {
		return fecha;
	}

	public void setFechaDonacion( Date fecha) {
		assert(fecha != null):"La fecha debe ser distinta de null";
		this.fecha = fecha;
	}

	public double getCantidadDonada() {
		return cantidad;
	}

	public void setCantidadDonada( double newCantidadDonada) {
		assert(cantidad > 0):"La cantidad a donar debe ser positiva";
		this.cantidad = newCantidadDonada;
	}
	
	
}