import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        try {
            // Formateador de fechas
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // === EXISTENTE: Inicialización de oficinas, coches, clientes y alquileres ===
            RentalOffice office1 = new RentalOffice("Calle Luna 5", 20);
            RentalOffice office2 = new RentalOffice("Avenida Sol 10", 30);

            System.out.println("Oficinas creadas:");
            System.out.println(office1);
            System.out.println(office2);

            Model model1 = new Model("Toyota Corolla", 50);
            Model model2 = new Model("Honda Civic", 60);

            System.out.println("\nModelos de coches creados:");
            System.out.println(model1);
            System.out.println(model2);

            Car car1 = new Car("1234ABC", office1, model1);
            Car car2 = new Car("5678DEF", office2, model2);

            System.out.println("\nCoches creados y asignados a oficinas:");
            System.out.println(car1);
            System.out.println(car2);

            Customer customer1 = new Customer("12345678A", "Juan Pérez");
            Customer customer2 = new Customer("87654321B", "Ana López");

            System.out.println("\nClientes creados:");
            System.out.println(customer1);
            System.out.println(customer2);

            RentalOnSite rental1 = new RentalOnSite(
                    dateFormat.parse("2024-12-01"),
                    dateFormat.parse("2024-12-05"),
                    car1,
                    customer1,
                    office1,
                    "Todo perfecto, sin incidencias"
            );

            office1.addRental(rental1);

            WebRental rental2 = new WebRental(
                    dateFormat.parse("2024-12-10"),
                    dateFormat.parse("2024-12-15"),
                    car2,
                    customer2,
                    office2,
                    dateFormat.parse("2024-12-15 12:30"),
                    office1
            );

            System.out.println("\nAlquileres creados:");
            System.out.println(rental1);
            System.out.println(rental2);

            // === NUEVO: Ejercicio 3 - Cálculo de precios con promociones ===

            // Crear promociones
            Promotion percentagePromotion = new PercentagePromotion(10); // 10% descuento
            Promotion amountPromotion = new AmountPromotion(20);        // 20€ descuento

            // Asignar promociones a los alquileres
            rental1.setPromotion(percentagePromotion);
            rental2.setPromotion(amountPromotion);

            // Calcular y mostrar precios finales de los alquileres
            System.out.println("\n=== Cálculo de precios de los alquileres ===");
            System.out.println("Precio del alquiler 1 (con promoción del 10%): " + rental1.getPrice() + " €");
            System.out.println("Precio del alquiler 2 (con promoción de 20€): " + rental2.getPrice() + " €");

            // Crear un nuevo alquiler para probar otra promoción
            System.out.println("\nCrear un alquiler nuevo con una promoción:");
            WebRental newRental = new WebRental(
                    dateFormat.parse("2024-12-20"),
                    dateFormat.parse("2024-12-25"),
                    car1,
                    customer1,
                    office1,
                    dateFormat.parse("2024-12-25 11:30"),
                    office2
            );
            newRental.setPromotion(new AmountPromotion(30)); // 30 unidades descuento
            System.out.println("Precio del nuevo alquiler: " + newRental.getPrice() + " €");

        } catch (Exception e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
