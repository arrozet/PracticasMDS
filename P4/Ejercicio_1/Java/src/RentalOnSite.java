import java.util.Date;

/**
 * Clase que representa un alquiler realizado en una oficina física.
 */
class RentalOnSite extends Rental {
    private String comments; // Comentarios opcionales sobre el alquiler

    /**
     * Constructor de la clase RentalOnSite.
     *
     * @param startDate Fecha de inicio del alquiler.
     * @param endDate   Fecha de finalización del alquiler.
     * @param car       Coche asociado al alquiler.
     * @param customer  Cliente que realiza el alquiler.
     * @param comments  Comentarios adicionales sobre el alquiler.
     */
    public RentalOnSite(Date startDate, Date endDate, Car car, Customer customer, RentalOffice pickUpOffice, String comments) {
        super(startDate, endDate, car, customer, pickUpOffice);
        this.comments = comments;
    }

    /**
     * Obtiene los comentarios del alquiler.
     *
     * @return Comentarios del alquiler.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Establece comentarios para el alquiler.
     *
     * @param comments Comentarios adicionales.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "RentalOnSite{" +
                super.toString() +
                ", comments='" + comments + '\'' +
                '}';
    }

}
