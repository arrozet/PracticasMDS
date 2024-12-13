import java.util.Date;

/**
 * Clase que representa el estado "Sustituto" de un coche.
 * Un coche en estado "Sustituto" no puede ser marcado como "Fuera de Servicio".
 */
public class Substitute implements State {

    private Car car;

    /**
     * Constructor de la clase Substitute.
     *
     * @param car El coche que se encuentra en estado "Sustituto".
     */
    public Substitute(Car car) {
        this.car = car;
    }

    /**
     * Indica que un coche en estado "Sustituto" no puede ser puesto fuera de servicio.
     *
     * @param backToService Fecha propuesta para el estado "Fuera de Servicio". No tiene efecto,
     *                      ya que los coches sustitutos no pueden cambiar a este estado.
     */
    @Override
    public void takeOutOfService(Date backToService) {
        System.out.println("Este coche es sustituto, no puede ponerse fuera de servicio");
    }
}
