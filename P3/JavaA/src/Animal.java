import java.util.Date;

public class Animal {
	
	private EstadoAnimal estadoAnimal;	// Lo de los enumerados no se como va ¿Se crea una clase?
	private Date nacimiento; 
	
	public Animal( Date nacimiento ) {
		this.setNacimiento(nacimiento);
		this.estadoAnimal = EstadoAnimal.disponible;
	}
	
	/* Funciones sobre nacimiento */
	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	/* Funciones sobre el estado del animal */
	public String getEstadoAnimal() {
		return estadoAnimal.name();
	}

	public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
		this.estadoAnimal = estadoAnimal;
	}
	
	public boolean estaAdoptado() {
		return estadoAnimal == EstadoAnimal.adoptado;
	}

	public void setAdoptado() {
		estadoAnimal = EstadoAnimal.adoptado;
	}
	
	public void setEnTratamiento() {
		estadoAnimal = EstadoAnimal.enTratamiento;
	}
}
