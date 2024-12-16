import java.util.Date;

/**
 * Clase que representa el estado "En Servicio" de un coche.
 */
public class InService extends State {

    /**
     * Constructor de la clase InService.
     *
     * @param car El coche que se encuentra en el estado "En Servicio".
     */
    public InService(Car car) {
        this.car = car;
    }

    /**
     * Cambia el estado del coche a "Fuera de Servicio".
     * Si se encuentra un coche sustituto disponible, se asignará como sustituto.
     *
     * @param backToService Fecha hasta la cual el coche estará fuera de servicio.
     */
    @Override
    public void takeOutOfService(Date backToService) {
        // Buscar un coche sustituto
        Car substituteCar = findSubstituteCar(car.getModel(), car.getAssignedOffice(), car.getLicensePlate());
        if (substituteCar != null) {
            substituteCar.setState(new Substitute(car));
            System.out.println("Coche sustituto asignado: " + substituteCar.getLicensePlate());
        } else {
            System.out.println("No hay coches sustitutos disponibles.");
        }

        // Cambiar el estado del coche a "Fuera de Servicio"
        car.setState(new OutOfService(car, backToService));
        System.out.println("Coche marcado como fuera de servicio hasta: " + backToService);
    }

    /**
     * Busca un coche sustituto disponible que pertenezca al mismo modelo y oficina.
     *
     * @param model Modelo del coche original.
     * @param office Oficina asignada al coche original.
     * @return Un coche sustituto disponible, o null si no se encuentra ninguno.
     */
    private Car findSubstituteCar(Model model, RentalOffice office, String licensePlate) {
        return car.allTheCars.stream()
                .filter(c -> car.getModel().equals(model) &&
                        c.getAssignedOffice().equals(office) &&
                        c.getState() instanceof InService &&
                        !c.getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElse(null);
    }
}
