import java.util.List;

public interface IDonante {
    public void donar(double c) throws RefugioAnimalesException;
    public boolean esDonante();
    public void setDonante(boolean esDonante);
}
