import java.util.Date;

// Debe ser una clase abstracta. No se puede instanciar un socio, sino solo adoptante, voluntario o donante
public abstract class Socio {
    private Date registro;

	// Para modelar la asociación con Refugio
    private Refugio refugioInscrito;

    public Socio(Date fechaInscripcion, Refugio refugio) {
		this.registro = fechaInscripcion;
		this.refugioInscrito = refugio;

		refugio.agregarSocio(this);
    }

	public Date getRegistro() {
		return registro;
	}
	
	public void setRegistro(Date fechaInscripcion) {
		this.registro = fechaInscripcion;
	}

	public Refugio getRefugio() {
		return refugioInscrito;
	}
	
	public void setRefugio( Refugio newRefugio ) {
		this.refugioInscrito = newRefugio;
	}

    @Override	
    public String toString() {
        return this.getClass().getName() + " Fecha de inscripción: " + getRegistro().toString() + ";Refugio: " + getRefugio().toString();
    }
}