import java.time.LocalTime;
import java.util.Date;

/**
 * Clase que representa un alquiler realizado a través de la aplicación web.
 */
class WebRental extends Rental {
    private LocalTime deliveryTime; // Hora de devolución del coche (opcional)
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
    public WebRental(Date startDate, Date endDate, Car car, Customer customer, RentalOffice pickUpOffice, LocalTime deliveryTime,
                     RentalOffice deliveryOffice) {
        super(startDate, endDate, car, customer, pickUpOffice);

        // Restricción 4: Si las oficinas de recogida y entrega son diferentes, validar hora de entrega
        /*
        if (!pickUpOffice.equals(deliveryOffice)) {
            if (deliveryTime == null) {
                throw new IllegalArgumentException("La hora de entrega es obligatoria si las oficinas de recogida y entrega son diferentes.");
            }
            Date limit = new Date(deliveryTime.getYear(), deliveryTime.getMonth(), deliveryTime.getDate(), 13, 0);
            if (deliveryTime.after(limit)) {
                throw new IllegalArgumentException("La hora de entrega debe ser anterior a las 13:00 si las oficinas son diferentes.");
            }
        }
        */


        this.deliveryTime = deliveryTime;
        this.deliveryOffice = deliveryOffice;

        
        deliveryOffice.addWebRental(this);
    }

    /**
     * Obtiene la hora de devolución del coche.
     *
     * @return Hora de devolución.
     */
    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Establece la hora de devolución del coche.
     *
     * @param deliveryTime Hora de devolución.
     */
    public void setDeliveryTime(LocalTime deliveryTime) {
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
    
    /**
     * Obtiene el precio final del alquiler
     * 
     * @return Precio final
     */
    @Override
    public int getPrice() {
        return super.getPrice() + getDeliveryOffice().getFeeForDelivery();
    }
    

    @Override
    public String toString() {
        return "WebRental{" +
                super.toString() +
                ", deliveryTime=" + deliveryTime +
                ", deliveryOffice=" + deliveryOffice +
                ", Price=" + this.getPrice() +
                '}';
    }

}
