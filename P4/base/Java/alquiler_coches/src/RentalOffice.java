import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una oficina de alquiler de coches.
 */
class RentalOffice {
    private String address; // Dirección de la oficina
    private int feeForDelivery; // Tarifa por entrega en una oficina diferente
    private List<Rental> rentals; // Lista de todos los alquileres asociados a la oficina
    private List<WebRental> webRentals; // Lista específica de alquileres web asociados a la oficina
    private List<Car> cars; // Lista de coches asignados a la oficina

    /**
     * Constructor de la clase RentalOffice.
     *
     * @param address       Dirección de la oficina.
     * @param feeForDelivery Tarifa por entrega en otra oficina.
     */
    public RentalOffice(String address, int feeForDelivery) {
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        this.rentals = new ArrayList<>();
        this.webRentals = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    /**
     * Obtiene la dirección de la oficina.
     *
     * @return Dirección de la oficina.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece una nueva dirección para la oficina.
     *
     * @param address Nueva dirección.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtiene la tarifa por entrega en una oficina diferente.
     *
     * @return Tarifa por entrega.
     */
    public int getFeeForDelivery() {
        return feeForDelivery;
    }

    /**
     * Establece una nueva tarifa por entrega en otra oficina.
     *
     * @param feeForDelivery Nueva tarifa por entrega.
     */
    public void setFeeForDelivery(int feeForDelivery) {
        this.feeForDelivery = feeForDelivery;
    }

    /**
     * Obtiene la lista de todos los alquileres asociados a la oficina.
     *
     * @return Lista de alquileres.
     */
    public List<Rental> getRentals() {
        return rentals;
    }

    /**
     * Añade un alquiler a la lista de alquileres.
     *
     * @param rental Alquiler que se desea añadir.
     */
    public void addRental(Rental rental) {
        this.rentals.add(rental);
        if (rental instanceof WebRental) {
            this.webRentals.add((WebRental) rental);
        }
    }

    /**
     * Elimina un alquiler de la lista de alquileres.
     *
     * @param rental Alquiler que se desea eliminar.
     */
    public void removeRental(Rental rental) {
        this.rentals.remove(rental);
        if (rental instanceof WebRental) {
            this.webRentals.remove((WebRental) rental);
        }
    }

    /**
     * Obtiene la lista de alquileres web asociados a la oficina.
     *
     * @return Lista de alquileres web.
     */
    public List<WebRental> getWebRentals() {
        return webRentals;
    }

    /**
     * Obtiene la lista de coches asignados a la oficina.
     *
     * @return Lista de coches.
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * Añade un coche a la lista de coches asignados a la oficina.
     *
     * @param car Coche que se desea añadir.
     */
    public void addCar(Car car) {
        this.cars.add(car);
    }

    /**
     * Elimina un coche de la lista de coches asignados a la oficina.
     *
     * @param car Coche que se desea eliminar.
     */
    public void removeCar(Car car) {
        this.cars.remove(car);
    }

    @Override
    public String toString() {
        return "RentalOffice{" +
                "address='" + address + '\'' +
                ", feeForDelivery=" + feeForDelivery +
                ", rentals=" + rentals.size() +
                ", webRentals=" + webRentals.size() +
                ", cars=" + cars.size() +
                '}';
    }
}
