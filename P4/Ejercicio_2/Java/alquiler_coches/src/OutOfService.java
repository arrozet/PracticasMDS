import java.util.Date;

public class OutOfService implements State{
    private Car car;
    private Date outOfServiceUntil;
    public OutOfService(Car car, Date backToService){
        this.outOfServiceUntil = backToService;
        this.car = car;
    }
    @Override
    public void takeOutOfService(Date backToService) {
        System.out.println("Este coche ya está fuera de servicio");
    }
    public Date getOutOfServiceUntil(){
        return outOfServiceUntil;
    }
    public void setOutOfServiceUntil(Date outOfServiceUntil){
        this.outOfServiceUntil = outOfServiceUntil;
    }

}
