import java.util.Date;

class Socio {
    private Date fechaInscripcion;
    private Refugio refugioInscrito;

    public Socio(Date fechaInscripcion, Refugio refugio ) {
        this.refugioInscrito = refugio;
        this.setFechaInscripcion(fechaInscripcion);
    }
    
    /* Funcioens sobre la fecha de inscripción */
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	/* Funciones sobre el refugio */
	public Refugio getRefugio() {
		return refugioInscrito;
	}
	
	public void setRefugio( Refugio newRefugio ) {
		this.refugioInscrito = newRefugio;
	}

    @Override	
    public String toString() {
        return this.getClass().getName() + " Inscrito: " + getFechaInscripcion().toString() + "; En el refugio: " + getRefugio().toString();
    }
}