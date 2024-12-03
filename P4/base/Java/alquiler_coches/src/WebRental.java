import java.util.Date;

/**
 * Clase que representa un alquiler realizado a través de la aplicación web.
 */
class WebRental extends Rental {
    private Date deliveryTime; // Hora de devolución del coche (opcional)
    private RentalOffice deliveryOffice; // Oficina de entrega

    /**
     * Constructor de la clase WebRental.
     *
     * @param startDate      Fecha de inicio del alquiler.
     * @param endDate        Fecha de finalización del alquiler.
     * @param car            Coche asociado al alquiler.
     * @param customer       Cliente que realiza el alquiler.
     * @param deliveryTime   Hora de devolución del coche (puede ser nula).
     * @param deliveryOffice Oficina de entrega del coche.
     */
    public WebRental(Date startDate, Date endDate, Car car, Customer customer, RentalOffice pickUpOffice, Date deliveryTime,
                     RentalOffice deliveryOffice) {
        super(startDate, endDate, car, customer, pickUpOffice);

        // Restricción de integridad 4
        if (!car.getAssignedOffice().equals(deliveryOffice)) {
            throw new IllegalArgumentException("La oficina de recogida debe ser la misma que la oficina asignada al coche.");
        }

        if (deliveryOffice != null && deliveryTime != null) {
            Date limit = new Date(deliveryTime.getYear(), deliveryTime.getMonth(), deliveryTime.getDate(), 13, 0);
            if (deliveryTime.after(limit)) {
                throw new IllegalArgumentException("La hora de entrega debe ser anterior a las 13:00.");
            }
        }

        this.deliveryTime = deliveryTime;
        this.deliveryOffice = deliveryOffice;
    }

    /**
     * Obtiene la hora de devolución del coche.
     *
     * @return Hora de devolución.
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Establece la hora de devolución del coche.
     *
     * @param deliveryTime Hora de devolución.
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * Obtiene la oficina de entrega del coche.
     *
     * @return Oficina de entrega.
     */
    public RentalOffice getDeliveryOffice() {
        return deliveryOffice;
    }

    /**
     * Establece la oficina de entrega del coche.
     *
     * @param deliveryOffice Oficina de entrega.
     */
    public void setDeliveryOffice(RentalOffice deliveryOffice) {
        this.deliveryOffice = deliveryOffice;
    }

    @Override
    public String toString() {
        return "WebRental{" +
                super.toString() +
                ", deliveryTime=" + deliveryTime +
                ", deliveryOffice=" + deliveryOffice +
                '}';
    }

}
