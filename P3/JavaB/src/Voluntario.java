import java.util.Date;

public class Voluntario implements IVoluntario,Rol{
	
	private Refugio refugio;
	
	public Voluntario( Refugio refugio ) {
		this.refugio = refugio;
	}
	
	@Override
	public void tramitarAdopcion( Animal animal, Adoptante adoptante ) throws RefugioAnimalesException {
		adoptante.adoptaAnimal(animal);
	}

	@Override
	public void registrar(Animal animal) {
		refugio.registrarAnimal(animal);
	}
	
}
