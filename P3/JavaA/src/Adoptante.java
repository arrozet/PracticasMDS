import java.util.Date;

public class Adoptante extends Socio  {
	
	
	private int AnimalesAdoptados; // Enunciado -> Punto 1 = Roles de los Socios
									// Adoptantes -> "han adoptado AL MENOS UN animal"
	
	// REALMENTE NO SE SI AL SER ADOPTANTE YA SE SIAB QUE HA ADOPTADO AL MENOS UN
	// ANIMAL, O HAY QUE REVISARLO
	// EN CASO DE QUE SEA AUTOMATICO, MOD LINEA 12 Y BORRAR LA 14
	public Adoptante(Date registro, Refugio refugio, int animalesAdoptados) {
		super(registro, refugio);
		this.AnimalesAdoptados = animalesAdoptados;
	}

	public void adoptar(Animal animal, Voluntario voluntario) {
    	assert( !animal.estaAdoptado() );

		try 
		{
			voluntario.tramitarAdopcion(animal, this);
		} 
		catch (RefugioAnimalesException e) {
			e.printStackTrace();
		}
    	animal.setAdoptado();
	}
}
