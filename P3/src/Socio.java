import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Socio {
    private Date fechaInscripcion;
    private Refugio refugioInscrito;
    /*
     * Una clase solo puede extenderse de otra clase en Java
     * 
     * Debido a que un socio puede tener más de un rol a la vez, no podemos 
     * 	crear un diseño unicamente basado en la herencia, ya que 
     * 	los métodos y comportamientos específicos de cada rol 
     * 	se perderían si no están disponibles en una sola clase.
     * 
     * Para solucionarlo usamos "roles", una lista de clases
     */
    private List<Socio> roles;

    public Socio(Date fechaInscripcion, Refugio refugio ) {
        this.roles = new ArrayList<>();
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

    public List<Socio> getRoles() {
        return roles;
    }

    public void addRol( Socio rol ) {
        if (!roles.contains(rol)) {
            roles.add(rol);
        }
    }

    public boolean hasRole( Socio rol) {
        return roles.contains(rol);
    }

    //MAL: FALTA POR IMPLEMENTAR
    @Override	
    public String toString() {
        return "";
    }
}