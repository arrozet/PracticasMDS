import java.util.Date;

/**
 * Clase que representa el estado "Fuera de Servicio" de un coche.
 */
public class OutOfService extends State {
    private Date outOfServiceUntil;

    /**
     * Constructor de la clase OutOfService.
     *
     * @param car El coche que se encuentra en estado "Fuera de Servicio".
     * @param backToService Fecha hasta la cual el coche estará fuera de servicio.
     */
    public OutOfService(Car car, Date backToService) {
        this.outOfServiceUntil = backToService;
        this.car = car;
    }

    /**
     * Indica que el coche ya se encuentra en estado "Fuera de Servicio".
     *
     * @param backToService Fecha propuesta para el estado "Fuera de Servicio". No tiene efecto,
     *                      ya que el coche ya está fuera de servicio.
     */
    @Override
    public void takeOutOfService(Date backToService) {
        System.out.println("Este coche ya está fuera de servicio");
    }

    /**
     * Obtiene la fecha hasta la cual el coche estará fuera de servicio.
     *
     * @return La fecha de finalización del estado "Fuera de Servicio".
     */
    public Date getOutOfServiceUntil() {
        return outOfServiceUntil;
    }

    /**
     * Actualiza la fecha hasta la cual el coche estará fuera de servicio.
     *
     * @param outOfServiceUntil Nueva fecha de finalización del estado "Fuera de Servicio".
     */
    public void setOutOfServiceUntil(Date outOfServiceUntil) {
        this.outOfServiceUntil = outOfServiceUntil;
    }
}
