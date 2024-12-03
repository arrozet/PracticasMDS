import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase abstracta que representa un alquiler en el sistema.
 */
public abstract class Rental {
    private Date startDate; // Fecha de inicio del alquiler
    private Date endDate; // Fecha de finalización del alquiler
    private Car car; // Coche asociado al alquiler
    private Customer customer; // Cliente que realiza el alquiler
    private RentalOffice pickUpOffice; // Oficina de recogida del coche

    /**
     * Constructor de la clase Rental.
     *
     * @param startDate   Fecha de inicio del alquiler.
     * @param endDate     Fecha de finalización del alquiler.
     * @param car         Coche asociado al alquiler.
     * @param customer    Cliente que realiza el alquiler.
     * @param pickUpOffice Oficina de recogida del coche.
     */
    public Rental(Date startDate, Date endDate, Car car, Customer customer, RentalOffice pickUpOffice) {
        // Restricción de integridad 2: la fecha de inicio debe ser anterior a la fecha final
        if (!startDate.before(endDate)) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha final.");
        }

        // Restricción de integridad 3: la oficina de recogida debe coincidir con la oficina asignada al coche
        if (!pickUpOffice.equals(car.getAssignedOffice())) {
            throw new IllegalArgumentException("La oficina de recogida debe ser la misma que la oficina asignada al coche.");
        }

        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.customer = customer;
        this.pickUpOffice = pickUpOffice;
        customer.addRental(this); // Verifica restricciones relacionadas con el cliente
        car.addRental(this);
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

    /**
     * Obtiene la oficina de recogida del coche.
     *
     * @return Oficina de recogida.
     */
    public RentalOffice getPickUpOffice() {
        return pickUpOffice;
    }

    /**
     * Establece la oficina de recogida del coche.
     *
     * @param pickUpOffice Oficina de recogida.
     */
    public void setPickUpOffice(RentalOffice pickUpOffice) {
        if (!pickUpOffice.equals(car.getAssignedOffice())) {
            throw new IllegalArgumentException("La oficina de recogida debe ser la misma que la oficina asignada al coche.");
        }
        this.pickUpOffice = pickUpOffice;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Rental{" +
                "startDate=" + dateFormat.format(startDate) +
                ", endDate=" + dateFormat.format(endDate) +
                ", car=" + car.getLicensePlate() +
                ", customer=" + customer.getDni() +
                ", pickUpOffice=" + pickUpOffice.getAddress() +
                '}';
    }
}
