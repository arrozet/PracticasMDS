import java.util.Date;

public interface IAdoptante {
    public void adoptar(Animal animal, Socio socio) throws RefugioAnimalesException;
    public boolean esAdoptante();
    public void setAdoptante(boolean esAdoptante);
}
