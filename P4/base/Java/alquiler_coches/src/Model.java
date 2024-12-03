import java.util.*;

/**
 * Clase que representa un modelo de coche, incluyendo su nombre, precio por día y coches asociados.
 */
class Model {
    private String name; // Nombre del modelo del coche
    private int pricePerDay; // Precio por día del modelo
    private List<Car> cars; // Lista de coches asociados a este modelo

    /**
     * Constructor de la clase Model.
     *
     * @param name        Nombre del modelo.
     * @param pricePerDay Precio por día del modelo.
     */
    public Model(String name, int pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.cars = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del modelo del coche.
     *
     * @return Nombre del modelo.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del modelo del coche.
     *
     * @param name Nombre del modelo.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el precio por día del modelo.
     *
     * @return Precio por día.
     */
    public int getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Establece el precio por día del modelo.
     *
     * @param pricePerDay Precio por día.
     */
    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    /**
     * Obtiene un Enumeration de los coches asociados al modelo.
     *
     * @return Un Enumeration que permite iterar sobre los coches asociados al modelo.
     */
    public Enumeration<Car> getCars() {
        return Collections.enumeration(cars);
    }

    /**
     * Asocia un coche a este modelo.
     *
     * @param car Objeto Car que se desea asociar.
     */
    public void addCar(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("El coche ya está asociado a este modelo.");
        }
        this.cars.add(car);
    }

    /**
     * Elimina un coche de la lista de coches asociados al modelo.
     *
     * @param car Objeto Car que se desea eliminar.
     */
    public void removeCar(Car car) {
        if (!cars.contains(car)) {
            throw new IllegalArgumentException("El coche no está asociado a este modelo.");
        }
        this.cars.remove(car);
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", cars=" + cars +
                '}';
    }

}
