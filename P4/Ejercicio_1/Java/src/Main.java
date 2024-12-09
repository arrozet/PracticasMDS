import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    /**
     * Método auxiliar para imprimir elementos de una Iterable.
     *
     * @param iterable Colección iterable.
     * @param <T> Tipo de elementos.
     */
    private static <T> void printIterable(Iterable<T> iterable) {
        for (T element : iterable) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Crear cliente
            Customer customer = new Customer("12345678A", "Juan Pérez");

            // Crear oficinas de alquiler
            RentalOffice office1 = new RentalOffice("Calle Luna 5", 20);
            RentalOffice office2 = new RentalOffice("Avenida Sol 10", 30);

            // Crear coche
            Model model1 = new Model("Toyota Corolla", 50);
            Car car1 = new Car("1234ABC", office1, model1);

            int N = 10; // Número de alquileres a añadir

            System.out.println("INTRODUCIENDO " +  N + " ALQUILERES CON DISTINTAS OFICINAS DE RECOGIDA Y ENTREGA...\n");
            for (int i = 0; i < N; i++) {
                // Fechas dinámicas para cada alquiler
                Date pickupDate = dateFormat.parse("2024-12-" + String.format("%02d", 1 + i));
                Date returnDate = dateFormat.parse("2024-12-" + String.format("%02d", 2 + i));

                RentalOffice returnOffice = (i % 2 == 0) ? office2 : office1;

                // Usar el método 'alquilarDesdeWeb' para crear el alquiler
                WebRental rental = customer.alquilarDesdeWeb(pickupDate, returnDate, car1.getLicensePlate(), returnOffice);

                // Devolvemos el coche
                customer.devolverCocheAlquiladoEnWeb(rental);

                // Asignar la oficina de devolución actual para que sea la de recogida del próximo alquiler
            }

            System.out.println("INTRODUCIENDO " +  N + " ALQUILERES CON MISMAS OFICINAS DE RECOGIDA Y ENTREGA...\n");
            for (int i = 0; i < N; i++) {
                // Fechas dinámicas para cada alquiler
                Date pickupDate = dateFormat.parse("2024-12-" + String.format("%02d", N + 1 + i));
                Date returnDate = dateFormat.parse("2024-12-" + String.format("%02d", N + 2 + i));


                // Usar el método 'alquilarDesdeWeb' para crear el alquiler
                WebRental rental = customer.alquilarDesdeWeb(pickupDate, returnDate, car1.getLicensePlate(), car1.getAssignedOffice());

                // Devolvemos el coche
                customer.devolverCocheAlquiladoEnWeb(rental);

                // Asignar la oficina de devolución actual para que sea la de recogida del próximo alquiler
            }

            // Verificar número de alquileres con oficinas diferentes
            int rentalCount = 0;
            for (Rental rental : customer.getRentals()) {
                if(rental instanceof WebRental){
                    rentalCount++;
                }
            }

            System.out.println("Alquileres: " + rentalCount);
            System.out.println("Alquileres con oficinas diferentes: " + customer.numberOfRentalsWithDifferentOffices());

            // Probar iteración y verificar integridad
            System.out.println("Alquileres actuales:");
            printIterable(customer.getRentals());

        } catch (Exception e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
