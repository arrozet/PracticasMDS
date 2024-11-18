import java.util.Date;

class Socio {
    private Date fechaInscripcion;
    private Refugio refugioInscrito;

    public Socio(Date fechaInscripcion, Refugio refugio ) {
        this.refugioInscrito = refugio;
        this.setFechaInscripcion(fechaInscripcion);
    }
    
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	
	public Refugio getRefugio() {
		return refugioInscrito;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

    //MAL: FALTA POR IMPLEMENTAR
    @Override	
    public String toString() {
        return "";
    }
}