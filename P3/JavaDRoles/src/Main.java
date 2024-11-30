import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static void imprimirRefugio(Refugio r){
        String separador = "----------------------------------";

        System.out.println();
        System.out.println(separador);
        System.out.println(r);
        System.out.println(separador);
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            // Crear un refugio
            Refugio refugio = new Refugio();

            //Creamos los roles
            Adoptante adoptante = new Adoptante();
            Voluntario voluntario = new Voluntario();
            Donante donante = new Donante();

            //Creamos la lista de roles
            List<Rol> roles1 = new ArrayList<>();
            List<Rol> roles2 = new ArrayList<>();
            List<Rol> roles3 = new ArrayList<>();

            roles1.add(voluntario);
            roles2.add(voluntario);

            roles1.add(adoptante);
            roles2.add(adoptante);

            roles2.add(donante);
            roles3.add(donante);

            // Crear socios: varios voluntarios, adoptantes y donantes
            Socio socio1 = new Socio(new Date(), refugio,roles1);
            Socio socio2 = new Socio(new Date(), refugio,roles1);
            Socio socio3 = new Socio(new Date(), refugio,roles2);
            Socio socio4 = new Socio(new Date(), refugio,roles2);
            Socio socio5 = new Socio(new Date(), refugio,roles3);
            Socio socio6 = new Socio(new Date(), refugio,roles3);

            imprimirRefugio(refugio);

            // Registrar múltiples animales
            Animal perro = new Animal("Coco", new Date(120, Calendar.JANUARY, 1)); // Fecha: 1 enero 2020
            Animal gato = new Animal("Michimini", new Date(121, Calendar.JUNE, 10)); // Fecha: 10 junio 2021
            Animal conejo = new Animal("Traviesito", new Date(119, Calendar.MARCH, 15)); // Fecha: 15 marzo 2019
            Animal loro = new Animal("Gor je", new Date(122, Calendar.AUGUST, 5)); // Fecha: 5 agosto 2022

            System.out.println("Registrando animales...");

            // No hace falta obtener el voluntario asociado a voluntario1,ya que el voluntarioe s el mismo para todos
            /*
            Optional<Rol> voluntarioSocio1 = socio1.getRoles().stream() // buscamos
                    .filter(r -> r instanceof Voluntario) // Filtrar solo los objetos Voluntario
                    .findFirst(); // Obtener el primero si existe
            */

            voluntario.registrar(perro,socio1);
            voluntario.registrar(gato,socio1);
            voluntario.registrar(conejo,socio3);
            voluntario.registrar(loro,socio3);
            System.out.println("Animales registrados con éxito.");

            imprimirRefugio(refugio);

            // Mostrar animales registrados en el refugio
            System.out.println("Animales registrados en el refugio:");
            for (Animal animal : refugio.getAnimalesRegistrados()) {
                System.out.println(animal);
            }
            System.out.println();

            // Adoptar varios animales
            System.out.println("Adoptando a Coco y a Michimini...");
            adoptante.adoptar(perro, voluntario,socio2);
            adoptante.adoptar(gato, voluntario,socio4);
            System.out.println("Adopciones tramitadas con éxito.");

            imprimirRefugio(refugio);

            // Mostrar animales refugiados tras las adopciones
            System.out.println("Animales refugiados después de las adopciones:");
            for (Animal animal : refugio.getAnimalesRefugiados()) {
                System.out.println(animal);
            }
            System.out.println();

            // Realizar donaciones al refugio
            System.out.println("Realizando donaciones...");
            donante.donar(100.0,socio4);
            donante.donar(200.0,socio6);
            System.out.println("Donaciones realizadas con éxito.");

            imprimirRefugio(refugio);

            // Mostrar trámites realizados por los voluntarios
            System.out.println("Trámites realizados por los voluntarios:");
            for (Map.Entry<Socio, Adopcion> entry : voluntario.getTramites().entrySet()) {

                System.out.println(entry.getKey().toString());
                System.out.println(entry.getValue().toString());
                System.out.println();
            }
            System.out.println();

            // Volver a poner un animal en tratamiento y registrar de nuevo
            System.out.println("Ponemos al conejo en tratamiento...");
            conejo.ponerEnTratamiento();
            System.out.println("Estado actual de Traviesito: " + conejo.getEstadoAnimal());

            /*
            System.out.println("\nVolvemos a registrar al conejo...");
            voluntario2.registrar(conejo);
//            System.out.println("Animales registrados después de volver a registrar Traviesito:");
//            for (Animal animal : refugio.getAnimalesRegistrados()) {
//                System.out.println(animal);
//            }
            */

            System.out.println();


            // Agregar más socios al refugio y mostrar el total
            System.out.println("Añadiendo 2 nuevos socios...");
            refugio.agregarSocio(new Socio(new Date(), refugio,roles1));
            refugio.agregarSocio(new Socio(new Date(), refugio,roles2));

            imprimirRefugio(refugio);

            System.out.println("Socio 1: ");
            System.out.println(socio1);
            System.out.println("Socio 3: ");
            System.out.println(socio3);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
