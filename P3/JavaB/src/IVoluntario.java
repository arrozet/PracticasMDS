
public interface IVoluntario {
	
	void tramitarAdopcion(Animal animal, Adoptante adoptante) throws RefugioAnimalesException;
	void registrar(Animal animal);
}
