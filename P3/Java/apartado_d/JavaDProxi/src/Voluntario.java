import java.util.*;

public class Voluntario implements Rol {
	private Refugio refugio;
	private List<Adopcion> tramites; // Lista de adopciones tramitadas por el voluntario

	public Voluntario(Refugio refugio) {
		this.refugio = refugio;
		tramites = new ArrayList<>();
	}

	public Refugio getRefugio() {
		return refugio;
	}

	public Date getRegistro() {
		// Aquí deberías agregar una fecha de registro si es necesario, por ejemplo:
		return new Date(); // O cualquier otra forma de obtener la fecha de registro
	}

	// Los métodos de adopción y registro permanecen iguales, pero ahora usan getRefugio() y getRegistro()
	public void tramitarAdopcion(Animal animal, Socio adoptante) throws RefugioAnimalesException {
		if (animal == null) {
			throw new RefugioAnimalesException("El animal no puede ser null.");
		}
		if(adoptante.getRoles().stream().noneMatch(rol -> rol instanceof Adoptante)){
			throw new IllegalArgumentException("No es un adoptante");
		}
		assert(animal.getRefugio().equals(adoptante.getRefugio())) : "El animal y el adoptante no están en el mismo refugio";

		// Cambiar el estado del animal a 'adoptado'
		animal.adoptar();

		// Eliminar el animal de la lista de refugiados, ya que ha sido adoptado
		refugio.eliminarAnimalRefugiado(animal);

		// Registrar la adopción y añadirla a los trámites del voluntario
		Adopcion nuevaAdopcion = new Adopcion(getRegistro(), animal, adoptante);
		tramites.add(nuevaAdopcion);
	}

	public void registrar(Animal animal) throws RefugioAnimalesException {
		if (animal == null) {
			throw new RefugioAnimalesException("El animal no puede ser null.");
		}

		// Verificar si el animal ya está registrado en el refugio
		if (refugio.containsAnimalesRegistrados(animal)) {
			throw new RefugioAnimalesException("El animal ya está registrado en el refugio.");
		}

		// Establecer el estado del animal como disponible y registrarlo en el refugio
		animal.setEstadoAnimal(EstadoAnimal.disponible);
		refugio.registrar(animal);
	}

	public Enumeration<Adopcion> getTramites() {
		return Collections.enumeration(tramites);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}