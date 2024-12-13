import java.util.Date;

/**
 * Interfaz que define el estado de un coche en el sistema.
 * Proporciona una operación común que todos los estados deben implementar.
 */
public interface State {

    /**
     * Cambia el estado de un coche a "Fuera de Servicio".
     *
     * @param backToService Fecha hasta la cual el coche estará fuera de servicio.
     *                      Cada implementación del estado manejará esta operación
     *                      de manera específica.
     */
    public void takeOutOfService(Date backToService);
}
