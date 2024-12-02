package todos;

/**
 * Interfaz que representa un rol dentro del sistema.
 *
 * Cada rol define un comportamiento específico que puede ser desempeñado por un socio.
 * Esta interfaz actúa como un contrato que asegura que cada implementación de un rol
 * estará asociada a un refugio.
 */
public interface Rol {

    /**
     * Obtiene el refugio asociado al rol.
     *
     * Cada rol debe estar vinculado a un refugio específico, lo que asegura que
     * todas las operaciones realizadas por un rol estén relacionadas con su refugio.
     *
     * @return Refugio asociado al rol.
     */
    Refugio getRefugio();
}
