import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.*;

/**
 * Clase que representa un cliente que puede realizar alquileres.
 */
class Customer {
    private String dni; // DNI del cliente
    private String name; // Nombre del cliente
    private Iterable<Rental> rentals; // Colección iterable de alquileres realizados por el cliente

    /**
     * Constructor de la clase Customer.
     *
     * @param dni  Identificador único del cliente.
     * @param name Nombre del cliente.
     */
    public Customer(String dni, String name, Collection<Rental> rentals) {
        this.dni = dni;
        this.name = name;
        this.rentals = rentals; // Por defecto, usamos ArrayList
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Método que devuelve el número de alquileres web donde las oficinas de recogida y entrega son diferentes.
     *
     * @return Número de alquileres con oficinas diferentes.
     */
    public int numberOfRentalsWithDifferentOffices() {
        RentalIterator iterator = new RentalIterator(rentals);
        int count = 0;
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            if (rental instanceof WebRental) {
                WebRental webRental = (WebRental) rental;
                if (!webRental.getPickUpOffice().equals(webRental.getDeliveryOffice())) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Obtiene un Enumeration de los alquileres realizados por el cliente.
     *
     * @return Un Enumeration que permite iterar sobre los alquileres del cliente.
     */
    public Iterable<Rental> getRentals() {
        return rentals;
    }

    /**
     * Añade un nuevo alquiler al cliente, verificando solapamientos.
     *
     * @param rental Alquiler que se desea añadir.
     * @throws IllegalArgumentException Si el nuevo alquiler se solapa con uno existente.
     */
    public void addRental(Rental rental) {
        if (!(rentals instanceof Collection)) {
            throw new UnsupportedOperationException("La colección actual no permite modificaciones.");
        }
        Collection<Rental> modifiableRentals = (Collection<Rental>) rentals;
        if (modifiableRentals.contains(rental)) {
            throw new IllegalArgumentException("El alquiler ya está asociado al cliente.");
        }

        // Restricción de integridad 1: un cliente no puede tener alquileres solapados.
        for (Rental existingRental : modifiableRentals) {
            if (rental.getStartDate().before(existingRental.getEndDate())
                    && rental.getEndDate().after(existingRental.getStartDate())) {
                throw new IllegalArgumentException("El nuevo alquiler se solapa con uno existente.");
            }
        }

        modifiableRentals.add(rental);
    }


    /**
     * Crea un alquiler web para el cliente.
     *
     * @param fechaInicial Fecha de inicio del alquiler.
     * @param fechaFinal   Fecha de fin del alquiler.
     * @param matricula    Matrícula del coche que se desea alquilar.
     * @param devolucion   Oficina de devolución del coche.
     * @return Un objeto de tipo {@code WebRental} que representa el alquiler creado.
     * @throws IllegalArgumentException Si el coche con la matrícula especificada no existe o no cumple las restricciones del alquiler.
     */
    public WebRental alquilarDesdeWeb(Date fechaInicial, Date fechaFinal, String matricula, RentalOffice devolucion) {
        // Buscar el coche por matrícula
        Car coche = Car.findCarByLicensePlate(matricula);

        // Crear el alquiler web con las restricciones del sistema
        WebRental alquiler = new WebRental(fechaInicial, fechaFinal, coche, this,
                coche.getAssignedOffice(), null, devolucion);

        return alquiler;
    }

    /**
     * Registra la devolución de un coche alquilado en la web.
     *
     * Este método valida que la hora de devolución sea anterior a las 13:00 si las oficinas
     * de recogida y entrega son diferentes, conforme a las restricciones del sistema.
     * También actualiza la oficina asignada al coche y registra la hora de devolución.
     *
     * @param wr El objeto {@code WebRental} correspondiente al alquiler que se desea finalizar.
     * @return Un mensaje que indica la fecha y hora de devolución del coche.
     * @throws IllegalArgumentException Si las oficinas son diferentes y la hora de devolución
     *                                  es posterior a las 13:00.
     */

    public String devolverCocheAlquiladoEnWeb(WebRental wr) {
        LocalTime ahora = LocalTime.now();
        // Restricción 4: Si las oficinas de recogida y entrega son diferentes, validar hora de entrega
        if (!wr.getPickUpOffice().equals(wr.getDeliveryOffice())) {
            LocalTime limit = LocalTime.of(15,0);
            if (ahora.isAfter(limit)) {
                throw new IllegalArgumentException("La hora de entrega debe ser anterior a las 13:00 si las oficinas son diferentes.");
            }
        }

        // Registrar la hora de finalización del alquiler
        wr.setDeliveryTime(ahora);

        // Actualizar la oficina asignada del coche al devolverlo
        wr.getCar().setAssignedOffice(wr.getDeliveryOffice());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "El coche ha sido devuelto el día " + dateFormat.format(wr.getEndDate()) + " a las " + wr.getDeliveryTime();
    }


    @Override
    public String toString() {
        return "Customer{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", rentals=" + rentals +
                '}';
    }

}
