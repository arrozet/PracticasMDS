import java.util.Date;

public class Context {
    private State state; //Estado actual
    public Context (State state){
        this.state = state;
    }
    /**
     * Cambia el estado del coche a "fuera de servicio".
     *
     * @param backToService Fecha hasta la cual estará fuera de servicio.
     */

    public void takeOutOfService(Date backToService) {
        state.takeOutOfService(backToService);
    }
    public State getState(){
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
