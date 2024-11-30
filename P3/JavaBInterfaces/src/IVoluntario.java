public interface IVoluntario {
    public void tramitarAdopcion(Animal animal, Socio socio) throws RefugioAnimalesException;
    public boolean esVoluntario();
    public void setVoluntario(boolean esVoluntario);
}
