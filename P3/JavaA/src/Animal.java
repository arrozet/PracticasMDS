import java.time.Instant;
import java.util.Date;

public class Animal {
	
	private EstadoAnimal estado;
	private Date nacimiento;
	private String nombre;
	
	public Animal( String nombre, Date nacimiento ) {
		this.setNacimiento(nacimiento);
		this.estado = EstadoAnimal.disponible;
		this.nombre = nombre;	// Se ha decidido darle nombre para que se pueda identificar fácilmente
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		assert(nacimiento.before(Date.from(Instant.now())));

		this.nacimiento = nacimiento;
	}

	public EstadoAnimal getEstadoAnimal() {
		return estado;
	}

	public void setEstadoAnimal(EstadoAnimal estado) {
		this.estado = estado;
	}
	
	public boolean estaAdoptado() {
		return estado == EstadoAnimal.adoptado;
	}
	
	public void setEnTratamiento() {
		estado = EstadoAnimal.enTratamiento;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"nombre=" + nombre +
				", estado=" + estado +
				", nacimiento=" + nacimiento +
				'}';
	}
}
