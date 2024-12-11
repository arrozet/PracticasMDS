import java.util.*;

/**
 * Clase que representa un coche en el sistema de alquiler.
 */
class Car {
    private String licensePlate; // Matrícula del coche
    private RentalOffice assignedOffice; // Oficina a la que está asignado el coche
    private Model model; // Modelo al que pertenece el coche
    private List<Rental> rentals; // Lista de alquileres asociados al coche
    public static List<Car> allTheCars = new ArrayList<>();
    private State state; //Estado actual del coche


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
        this.state = new InService(this);

        model.addCar(this);
        allTheCars.add(this);
        assignedOffice.addCar(this);
    }

    /**
     * Encuentra un coche por su matrícula.
     *
     * @param licensePlate Matrícula del coche a buscar.
     * @return El coche con la matrícula especificada.
     * @throws IllegalArgumentException Si no se encuentra un coche con la matrícula proporcionada.
     */
    public static Car findCarByLicensePlate(String licensePlate) {
        return allTheCars.stream()
                .filter(car -> licensePlate.compareTo(car.getLicensePlate())==0)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Coche no encontrado con la matrícula especificada: " + licensePlate));
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
     * Obtiene un Enumeration del estado actual del coche
     *
     * @return Un Enumeration que informando del estado del coche
     */
    public State getState() {
        return state;
    }

    /**
     * Obtiene la fecha hasta la que el coche está fuera de servicio, en caso de que lo esté.
     *
     * @return Un Date indicando la fecha hasta la que está fuera de servicio, o null si no lo está.
     */



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
    /**
     * Cambia el estado del coche a "fuera de servicio".
     *
     * @param backToService Fecha hasta la cual estará fuera de servicio.
     */
    public void takeOutOfService(Date backToService) {
        state.takeOutOfService(backToService);
    }




    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", state=" + state.getClass() +
                ", assignedOffice=" + assignedOffice.getAddress() +
                ", model=" + model.getName() +
                ", rentals=" + rentals.size() +
                '}';
    }

    public void setState(State state) {
        this.state = state;
    }


}
