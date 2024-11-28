import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voluntario extends Socio {

	private List<Adopcion> tramites;
	
	public Voluntario(Date registro, Refugio refugio) {
		super(registro, refugio);
		tramites = new ArrayList<>();
	}
	

	public void tramitarAdopcion( Animal animal, Adoptante adoptante ) throws RefugioAnimalesException {
		getRefugio().animalAdoptado(animal);
		tramites.add( new Adopcion(adoptante, animal,super.getRegistro()) );// creo que hay q crear una clase fechapor eso esta dando fallos
		// el Date es de SQL noenq porqu me recomienda que lo caste con java.SQL.Date o algo ansin
	}

	public void registrar(Animal animal) {
		super.getRefugio().registrar(animal);
	}
	
	public List<Adopcion> getTramites(){
		return tramites;
	}

}
