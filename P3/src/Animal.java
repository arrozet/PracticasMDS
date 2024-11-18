import java.util.Date;

public class Animal {
	
	private String estadoAnimal;	// Lo de los enumerados no se como va ¿Se crea una clase?
	private Date nacimiento; 
	
	public Animal( String estadoAnimal, Date nacimiento ) {
		this.setEstadoAnimal(estadoAnimal);
		this.setNacimiento(nacimiento);
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getEstadoAnimal() {
		return estadoAnimal;
	}

	public void setEstadoAnimal(String estadoAnimal) {
		this.estadoAnimal = estadoAnimal;
	}
	
}
