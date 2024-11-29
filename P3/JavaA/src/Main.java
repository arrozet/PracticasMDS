import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Formateador para imprimir fechas
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            // Crear un refugio
            Refugio refugio = new Refugio();

            // Crear socios: varios voluntarios, adoptantes y donantes
            Voluntario voluntario1 = new Voluntario(new Date(), refugio);
            Voluntario voluntario2 = new Voluntario(new Date(), refugio);
            Adoptante adoptante1 = new Adoptante(new Date(), refugio);
            Adoptante adoptante2 = new Adoptante(new Date(), refugio);
            Donante donante1 = new Donante(new Date(), refugio);
            Donante donante2 = new Donante(new Date(), refugio);

            // Registrar múltiples animales
            Animal perro = new Animal("Coco", new Date(120, Calendar.JANUARY, 1)); // Fecha: 1 enero 2020
            Animal gato = new Animal("Michimini", new Date(121, Calendar.JUNE, 10)); // Fecha: 10 junio 2021
            Animal conejo = new Animal("Traviesito", new Date(119, Calendar.MARCH, 15)); // Fecha: 15 marzo 2019
            Animal loro = new Animal("Gor je", new Date(122, Calendar.AUGUST, 5)); // Fecha: 5 agosto 2022

            System.out.println("Registrando animales...");
            voluntario1.registrar(perro);
            voluntario1.registrar(gato);
            voluntario2.registrar(conejo);
            voluntario2.registrar(loro);
            System.out.println("Animales registrados con éxito.\n");

            // Mostrar animales registrados en el refugio
            System.out.println("Animales registrados en el refugio:");
            for (Animal animal : refugio.getAnimalesRegistrados()) {
                System.out.println(animal);
            }
            System.out.println();

            // Adoptar varios animales
            System.out.println("Adoptando animales...");
            adoptante1.adoptar(perro, voluntario1);
            adoptante2.adoptar(gato, voluntario1);
            System.out.println("Adopciones tramitadas con éxito.\n");

            // Mostrar animales refugiados tras las adopciones
            System.out.println("Animales refugiados después de las adopciones:");
            for (Animal animal : refugio.getAnimalesRefugiados()) {
                System.out.println(animal);
            }
            System.out.println();

            // Realizar donaciones al refugio
            System.out.println("Realizando donaciones...");
            donante1.donar(100.0);
            donante2.donar(200.0);
            System.out.println("Donaciones realizadas con éxito.\n");

            // Mostrar liquidez del refugio tras las donaciones
            System.out.println("Liquidez del refugio: " + refugio.getLiquidez() + " euros.\n");

            // Mostrar trámites realizados por los voluntarios
            System.out.println("Trámites realizados por los voluntarios:");
            System.out.println("Voluntario 1:");
            for (Adopcion adopcion : voluntario1.getTramites()) {
                System.out.println(adopcion);
            }
            System.out.println("\nVoluntario 2:");
            for (Adopcion adopcion : voluntario2.getTramites()) {
                System.out.println(adopcion);
            }
            System.out.println();

            // Volver a poner un animal en tratamiento y registrar de nuevo
            System.out.println("Ponemos al conejo en tratamiento...");
            conejo.ponerEnTratamiento();
            System.out.println("Estado actual de Traviesito: " + conejo.getEstadoAnimal());

            System.out.println("\nVolvemos a registrar al conejo...");
            voluntario2.registrar(conejo);
            System.out.println("Animales registrados después de volver a registrar Traviesito:");
            for (Animal animal : refugio.getAnimalesRegistrados()) {
                System.out.println(animal);
            }
            System.out.println();

            // Agregar más socios al refugio y mostrar el total
            System.out.println("Añadiendo nuevos socios...");
            refugio.agregarSocio(new Voluntario(new Date(), refugio));
            refugio.agregarSocio(new Adoptante(new Date(), refugio));
            System.out.println("Número total de socios en el refugio: " + refugio.getSocios().size());
            System.out.println();

            // Mostrar estado general del refugio
            System.out.println("Estado general del refugio:");
            System.out.println(refugio);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
