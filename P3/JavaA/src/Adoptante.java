import java.util.Date;

public class Adoptante extends Socio  {
	//private int animalesAdoptados; // Enunciado -> Punto 1 = Roles de los Socios
									// Adoptantes -> "han adoptado AL MENOS UN animal"
	
	// REALMENTE NO SE SI AL SER ADOPTANTE YA SE SIAB QUE HA ADOPTADO AL MENOS UN
	// ANIMAL, O HAY QUE REVISARLO
	// EN CASO DE QUE SEA AUTOMATICO, MOD LINEA 12 Y BORRAR LA 14
	public Adoptante(Date registro, Refugio refugio) {
		super(registro, refugio);
		//this.AnimalesAdoptados = animalesAdoptados;
	}

	public void adoptar(Animal animal, Voluntario voluntario) {
		assert(animal != null): "El animal es null";
		assert( !animal.estaAdoptado() ): "El animal ya estaba adoptado";

		animal.setEstadoAnimal(EstadoAnimal.adoptado);	// Ahora el animal está oficialmente adoptado
		voluntario.tramitarAdopcion(animal, this);

	}
}
