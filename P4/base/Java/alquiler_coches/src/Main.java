import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        try {
            // Formateador de fechas
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Crear oficinas de alquiler
            RentalOffice office1 = new RentalOffice("Calle Luna 5", 20);
            RentalOffice office2 = new RentalOffice("Avenida Sol 10", 30);

            System.out.println("Oficinas creadas:");
            System.out.println(office1);
            System.out.println(office2);

            // Crear modelos de coches
            Model model1 = new Model("Toyota Corolla", 50);
            Model model2 = new Model("Honda Civic", 60);

            System.out.println("\nModelos de coches creados:");
            System.out.println(model1);
            System.out.println(model2);

            // Crear coches
            Car car1 = new Car("1234ABC", office1, model1);
            Car car2 = new Car("5678DEF", office2, model2);

            System.out.println("\nCoches creados:");
            System.out.println(car1);
            System.out.println(car2);

            System.out.println("\nModelos de coches creados:");
            System.out.println(model1);
            System.out.println(model2);

            // Crear clientes
            Customer customer1 = new Customer("12345678A", "Juan Pérez");
            Customer customer2 = new Customer("87654321B", "Ana López");

            System.out.println("\nClientes creados:");
            System.out.println(customer1);
            System.out.println(customer2);

            // Crear alquileres en oficina
            RentalOnSite rental1 = new RentalOnSite(
                    dateFormat.parse("2024-12-01"),
                    dateFormat.parse("2024-12-05"),
                    car1,
                    customer1,
                    "Todo perfecto, sin incidencias"
            );

            // Crear alquileres web
            WebRental rental2 = new WebRental(
                    dateFormat.parse("2024-12-10"),
                    dateFormat.parse("2024-12-15"),
                    car2,
                    customer2,
                    dateFormat.parse("2024-12-15 12:30"),
                    office2
            );

            System.out.println("\nAlquileres creados:");
            System.out.println(rental1);
            System.out.println(rental2);

            // Probar métodos de acceso y modificación
            System.out.println("\nPruebas de métodos:");
            office1.setAddress("Calle Estrella 20");
            System.out.println("Nueva dirección de la oficina 1: " + office1);

            model1.setPricePerDay(55);
            System.out.println("Nuevo precio por día del modelo 1: " + model1);

            car1.setLicensePlate("9876GHI");
            System.out.println("Nueva matrícula del coche 1: " + car1);

            System.out.println("\nAlquileres del cliente 1:");
            for (Rental rental : customer1.getRentals()) {
                System.out.println(rental);
            }
        } catch (Exception e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
