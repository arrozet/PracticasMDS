import java.util.*;

/**
 * Clase que representa un coche en el sistema de alquiler.
 */
class Car {
    private String licensePlate; // Matrícula del coche
    private RentalOffice assignedOffice; // Oficina a la que está asignado el coche
    private Model model; // Modelo al que pertenece el coche
    private List<Rental> rentals; // Lista de alquileres asociados al coche

    /**
     * Constructor de la clase Car.
     *
     * @param licensePlate   Matrícula del coche.
     * @param assignedOffice Oficina a la que está asignado el coche.
     * @param model          Modelo al que pertenece el coche.
     */
    public Car(String licensePlate, RentalOffice assignedOffice, Model model) {
        this.licensePlate = licensePlate;
        this.assignedOffice = assignedOffice;
        this.model = model;
        this.rentals = new ArrayList<>();

        model.addCar(this);
        assignedOffice.addCar(this);
    }

    /**
     * Obtiene la matrícula del coche.
     *
     * @return Matrícula del coche.
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Establece una nueva matrícula para el coche.
     *
     * @param licensePlate Nueva matrícula.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Obtiene la oficina asignada al coche.
     *
     * @return Oficina asignada.
     */
    public RentalOffice getAssignedOffice() {
        return assignedOffice;
    }

    /**
     * Establece una nueva oficina asignada al coche.
     *
     * @param assignedOffice Nueva oficina asignada.
     */
    public void setAssignedOffice(RentalOffice assignedOffice) {
        this.assignedOffice = assignedOffice;
    }

    /**
     * Obtiene el modelo al que pertenece el coche.
     *
     * @return Modelo del coche.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Establece un nuevo modelo para el coche.
     *
     * @param model Nuevo modelo del coche.
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Obtiene un Enumeration de los alquileres asociados al coche.
     *
     * @return Un Enumeration que permite iterar sobre los alquileres del coche.
     */
    public Enumeration<Rental> getRentals() {
        return Collections.enumeration(rentals);
    }


    /**
     * Añade un alquiler a la lista de alquileres del coche.
     *
     * @param rental Alquiler que se desea añadir.
     * @throws IllegalArgumentException Si el alquiler ya está asociado al coche.
     */
    public void addRental(Rental rental) {
        if (rentals.contains(rental)) {
            throw new IllegalArgumentException("El alquiler ya está asociado a este coche.");
        }
        rentals.add(rental);
    }

    /**
     * Elimina un alquiler de la lista de alquileres del coche.
     *
     * @param rental Alquiler que se desea eliminar.
     * @throws IllegalArgumentException Si el alquiler no está asociado al coche.
     */
    public void removeRental(Rental rental) {
        if (!rentals.contains(rental)) {
            throw new IllegalArgumentException("El alquiler no está asociado a este coche.");
        }
        rentals.remove(rental);
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", assignedOffice=" + assignedOffice.getAddress() +
                ", model=" + model.getName() +
                ", rentals=" + rentals.size() +
                '}';
    }
}
