import java.util.Date;

public class Adoptante extends Socio  {

	
	public Adoptante(Date fechaInscripcion, Refugio refugio) {
		super(fechaInscripcion, refugio);
	}


	public void adoptar(Animal animal, Voluntario voluntario) {
    	assert( !animal.estaAdoptado() );
		try {
			voluntario.tramitarAdopcion(animal, this);
		} catch (RefugioAnimalesException e) {
			e.printStackTrace();
		}
    	animal.setAdoptado();
	}
}
