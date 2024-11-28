import java.util.Date;

class Socio {
    private Date registro;
    private Refugio refugioInscrito;

    public Socio(Date fechaInscripcion, Refugio refugio ) {
        this.refugioInscrito = refugio;
        this.setRegistro(registro);
    }
    
    // MÉTODOS PARA EL REGISTRO
	public Date getRegistro() {
		return registro;
	}
	
	public void setRegistro(Date fechaInscripcion) {
		this.registro = fechaInscripcion;
	}
	
	// MÉTODOS PARA EL REFUGIO
	public Refugio getRefugio() {
		return refugioInscrito;
	}
	
	public void setRefugio( Refugio newRefugio ) {
		this.refugioInscrito = newRefugio;
	}

    @Override	
    public String toString() {
        return this.getClass().getName() + " Inscrito: " + getRegistro().toString() + "; En el refugio: " + getRefugio().toString();
    }
}