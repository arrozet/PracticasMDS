import java.time.LocalTime;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

public class Main {
    /**
     * Imprime los elementos de una enumeración.
     *
     * @param <T> Tipo de los elementos en la enumeración.
     * @param enumeration Enumeración que se desea imprimir.
     */
    private static <T> void printEnumeration(Enumeration<T> enumeration) {
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

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

            System.out.println("\nCoches creados y asignados a oficinas:");
            System.out.println(car1);
            System.out.println(car2);

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
                    office1,
                    "Todo perfecto, sin incidencias"
            );

            office1.addRental(rental1);
            //car1.addRental(rental1); // Esto se hace dentro del constructor, por eso da fallo

            // Crear alquileres web
            WebRental rental2 = new WebRental(
                    dateFormat.parse("2024-12-10"),
                    dateFormat.parse("2024-12-15"),
                    car2,
                    customer2,
                    office2,
                    LocalTime.of(12,30),
                    office1
            );

            System.out.println("\nAlquileres creados:");
            System.out.println(rental1);
            System.out.println(rental2);

            // Probar métodos de enumeración encapsulados
            System.out.println("\nCoches asignados a la oficina 1:");
            printEnumeration(office1.getCars());

            System.out.println("\nAlquileres en la oficina 2:");
            printEnumeration(office2.getRentals());

            System.out.println("\nEnumeración de alquileres de cliente 1:");
            printEnumeration(customer1.getRentals());

            // Probar modificaciones
            System.out.println("\nPruebas de métodos:");
            office1.setAddress("Calle Estrella 20");
            System.out.println("Nueva dirección de la oficina 1: " + office1);

            model1.setPricePerDay(55);
            System.out.println("Nuevo precio por día del modelo 1: " + model1);


            rental2.setDeliveryTime(LocalTime.of(11,45));
            System.out.println("Nueva hora de entrega del alquiler 2: " + rental2.getDeliveryTime());

            // === Nuevas funcionalidades ===

            // Probar alquilarDesdeWeb
            System.out.println("\nCliente 1 alquila un coche desde la web:");
            WebRental nuevoAlquiler = customer1.alquilarDesdeWeb(
                    dateFormat.parse("2024-12-20"),
                    dateFormat.parse("2024-12-25"),
                    "1234ABC",
                    office2
            );
            System.out.println("Alquiler web creado: " + nuevoAlquiler);

            // Probar devolverCocheAlquiladoEnWeb
            System.out.println("\nCliente 1 devuelve el coche alquilado:");
            System.out.println(customer1.devolverCocheAlquiladoEnWeb(nuevoAlquiler));

            // Verificar la oficina asignada del coche tras la devolución
            System.out.println("Oficina asignada al coche tras devolución: " + car1.getAssignedOffice());

            // Vamos a crear dos coches una oficina y un modelo nuevo
            System.out.println("\nPruebas del ejercicio 2:");

            RentalOffice office3 = new RentalOffice("Calle Wallaby 42 Sidney", 20);

            Model model3 = new Model("BMW M3 e30", 70);

            Car car3 = new Car("7777VEG", office3, model3);
            Car car4 = new Car("6666DEM", office3, model3);

            System.out.println("\nCoches asignados a la oficina 3:");
            printEnumeration(office3.getCars());

            // Ponemos car3 fuera de servicio
            System.out.println("\nPonemos el primero fuera de servicio");
            car3.getContext().takeOutOfService(dateFormat.parse("2024-12-25"));
            System.out.println("\nCoches asignados a la oficina 3:");
            printEnumeration(office3.getCars());

            // Ponemos car4 fuera de servicio
            System.out.println("\nY ahora el otro");
            car4.getContext().takeOutOfService(dateFormat.parse("2024-12-28"));
            System.out.println("\nCoches asignados a la oficina 3:");
            printEnumeration(office3.getCars());



        } catch (Exception e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
