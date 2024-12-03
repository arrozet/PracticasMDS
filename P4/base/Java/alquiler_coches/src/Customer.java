import java.util.*;

/**
 * Clase que representa un cliente que puede realizar alquileres.
 */
class Customer {
    private String dni; // DNI del cliente
    private String name; // Nombre del cliente
    private List<Rental> rentals; // Lista de alquileres realizados por el cliente

    /**
     * Constructor de la clase Customer.
     *
     * @param dni  Identificador único del cliente.
     * @param name Nombre del cliente.
     */
    public Customer(String dni, String name) {
        this.dni = dni;
        this.name = name;
        this.rentals = new ArrayList<>();
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
     * Obtiene un Enumeration de los alquileres realizados por el cliente.
     *
     * @return Un Enumeration que permite iterar sobre los alquileres del cliente.
     */
    public Enumeration<Rental> getRentals() {
        return Collections.enumeration(rentals);
    }

    /**
     * Añade un nuevo alquiler al cliente, verificando solapamientos.
     *
     * @param rental Alquiler que se desea añadir.
     * @throws IllegalArgumentException Si el nuevo alquiler se solapa con uno existente.
     */
    public void addRental(Rental rental) {
        // Añadida restricción de integridad 1
        for (Rental existingRental : rentals) {
            if (rental.getStartDate().before(existingRental.getEndDate())
                    && rental.getEndDate().after(existingRental.getStartDate())) {
                throw new IllegalArgumentException("El nuevo alquiler se solapa con uno existente.");
            }
        }
        this.rentals.add(rental);
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
