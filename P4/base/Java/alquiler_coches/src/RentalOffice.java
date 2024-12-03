/**
 * Clase que representa una oficina de alquiler de coches.
 */
class RentalOffice {
    private String address; // Dirección de la oficina
    private int feeForDelivery; // Tarifa por entrega en una oficina diferente

    /**
     * Constructor de la clase RentalOffice.
     *
     * @param address       Dirección de la oficina.
     * @param feeForDelivery Tarifa por entrega en otra oficina.
     */
    public RentalOffice(String address, int feeForDelivery) {
        this.address = address;
        this.feeForDelivery = feeForDelivery;
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

    @Override
    public String toString() {
        return "RentalOffice{" +
                "address='" + address + '\'' +
                ", feeForDelivery=" + feeForDelivery +
                '}';
    }

}
