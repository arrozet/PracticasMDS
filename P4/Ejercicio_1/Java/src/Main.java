import java.util.*;
import java.text.SimpleDateFormat;

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

            // Crear clientes
            Customer customer = new Customer("12345678A", "Juan Pérez");

            // Crear oficinas de alquiler
            RentalOffice office1 = new RentalOffice("Calle Luna 5", 20);
            RentalOffice office2 = new RentalOffice("Avenida Sol 10", 30);

            // Crear coches
            Model model1 = new Model("Toyota Corolla", 50);
            Car car1 = new Car("1234ABC", office1, model1);

            // Crear alquileres
            WebRental rental1 = new WebRental(
                    dateFormat.parse("2024-12-01"),
                    dateFormat.parse("2024-12-05"),
                    car1,
                    customer,
                    office1,
                    dateFormat.parse("2024-12-05 11:00"),
                    office2
            );

            // Crear alquileres
            WebRental rental2 = new WebRental(
                    dateFormat.parse("2024-12-06"),
                    dateFormat.parse("2024-12-07"),
                    car1,
                    customer,
                    office1,
                    dateFormat.parse("2024-12-07 11:00"),
                    office1
            );

            // Añadir alquileres
            //customer.addRental(rental1);
            //customer.addRental(rental2);

            // Verificar número de alquileres con oficinas diferentes
            System.out.println("Alquileres con oficinas diferentes: " + customer.numberOfRentalsWithDifferentOffices());

            // Probar iteración y verificar integridad
            System.out.println("Alquileres actuales:");
            printIterable(customer.getRentals());

            System.out.println(customer.numberOfRentalsWithDifferentOffices());

        } catch (Exception e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
