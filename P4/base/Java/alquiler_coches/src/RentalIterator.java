import java.util.Iterator;

/**
 * Iterador concreto para recorrer la colección de alquileres.
 */
class RentalIterator implements Iterator<Rental> {
    private Iterator<Rental> iterator;

    public RentalIterator(Iterable<Rental> rentals) {
        this.iterator = rentals.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Rental next() {
        return iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}

