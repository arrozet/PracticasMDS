/**
 * Clase que representa un coche en el sistema de alquiler.
 */
class Car {
    private String licensePlate; // Matrícula del coche
    private RentalOffice assignedOffice; // Oficina a la que está asignado el coche
    private Model model; // Modelo al que pertenece el coche

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
        model.addCar(this); // Asociar este coche al modelo
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
     * Establece una nueva matrícula al coche.
     *
     * @param licensePlate Matrícula nueva.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Obtiene la oficina a la que está asignado el coche.
     *
     * @return Oficina asignada.
     */
    public RentalOffice getAssignedOffice() {
        return assignedOffice;
    }

    /**
     * Establece la oficina asignada al coche.
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
     * Asigna un nuevo modelo al coche.
     *
     * @param model Nuevo modelo del coche.
     */
    public void setModel(Model model) {
        this.model = model;
    }
}
