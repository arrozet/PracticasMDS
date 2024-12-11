import java.util.Date;

public class Substitute implements State{

    private Car car;

    public Substitute(Car car){
        this.car = car;
    }
    @Override
    public void takeOutOfService(Date backToService) {
        System.out.println("Este coche es sustituto, no puede ponerse fuera de servicio");
    }
}
