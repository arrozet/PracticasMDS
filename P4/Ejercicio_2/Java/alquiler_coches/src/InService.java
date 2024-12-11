import java.util.Date;

public class InService implements State{
    private Car car;
    public InService(Car car){
        this.car = car;
    }
    @Override
    public void takeOutOfService(Date backToService) {
        // Buscar un coche sustituto
        Car substituteCar = findSubstituteCar(car.getModel(), car.getAssignedOffice());
        if (substituteCar != null) {
            substituteCar.setState(new Substitute(car));
            System.out.println("Coche sustituto asignado: " + substituteCar.getLicensePlate());
        } else {
            System.out.println("No hay coches sustitutos disponibles.");
        }

        car.setState(new OutOfService(car, backToService));
        System.out.println("Coche marcado como fuera de servicio hasta: " + backToService);
    }
    private Car findSubstituteCar(Model model, RentalOffice office) {
        return car.allTheCars.stream()
                .filter(c -> car.getModel().equals(model) &&
                        c.getAssignedOffice().equals(office) &&
                        c.getState() instanceof InService)
                .findFirst()
                .orElse(null);
    }
}
