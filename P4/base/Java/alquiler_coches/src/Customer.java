import java.util.ArrayList;
import java.util.List;

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
     * Obtiene la lista de alquileres realizados por el cliente.
     *
     * @return Lista de objetos Rental asociados al cliente.
     */
    public List<Rental> getRentals() {
        return rentals;
    }

    /**
     * Añade un nuevo alquiler a la lista de alquileres del cliente.
     *
     * @param rental Alquiler que se desea asociar al cliente.
     */
    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }
}
