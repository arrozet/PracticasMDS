import java.util.Iterator;

/**
 * Clase que implementa un iterador concreto para recorrer la colección de alquileres.
 * Permite iterar sobre una colección de objetos de tipo Rental sin exponer
 * los detalles internos de la colección.
 */
class RentalIterator implements Iterator<Rental> {
    private Iterator<Rental> iterator;

    /**
     * Constructor de la clase RentalIterator.
     *
     * @param rentals Colección iterable de objetos Rental sobre la cual se va a iterar.
     */
    public RentalIterator(Iterable<Rental> rentals) {
        this.iterator = rentals.iterator();
    }

    /**
     * Comprueba si hay más elementos en la colección que iterar.
     *
     * @return true si hay más elementos en la colección; false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * Devuelve el siguiente elemento de la colección.
     *
     * @return El siguiente objeto Rental de la colección.
     */
    @Override
    public Rental next() {
        return iterator.next();
    }

    /**
     * Operación no soportada para este iterador.
     * Se lanza una excepción si se intenta usar.
     *
     * @throws UnsupportedOperationException Siempre que se llame a este método.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}
