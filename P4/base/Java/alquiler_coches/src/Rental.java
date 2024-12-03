import java.util.Date;

/**
 * Clase abstracta que representa un alquiler en el sistema.
 */
public abstract class Rental {
    private Date startDate; // Fecha de inicio del alquiler
    private Date endDate; // Fecha de finalización del alquiler
    private Car car; // Coche asociado al alquiler
    private Customer customer; // Cliente que realiza el alquiler

    /**
     * Constructor de la clase Rental.
     *
     * @param startDate Fecha de inicio del alquiler.
     * @param endDate   Fecha de finalización del alquiler.
     * @param car       Coche asociado al alquiler.
     * @param customer  Cliente que realiza el alquiler.
     */
    public Rental(Date startDate, Date endDate, Car car, Customer customer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.customer = customer;
        customer.addRental(this); // Asociar el alquiler al cliente
    }

    /**
     * Obtiene la fecha de inicio del alquiler.
     *
     * @return Fecha de inicio.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Establece la fecha de inicio del alquiler.
     *
     * @param startDate Nueva fecha de inicio.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Obtiene la fecha de finalización del alquiler.
     *
     * @return Fecha de finalización.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Establece la fecha de finalización del alquiler.
     *
     * @param endDate Nueva fecha de finalización.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Obtiene el coche asociado al alquiler.
     *
     * @return Coche del alquiler.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Establece el coche asociado al alquiler.
     *
     * @param car Coche del alquiler.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Obtiene el cliente que realiza el alquiler.
     *
     * @return Cliente del alquiler.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Establece el cliente que realiza el alquiler.
     *
     * @param customer Cliente del alquiler.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
