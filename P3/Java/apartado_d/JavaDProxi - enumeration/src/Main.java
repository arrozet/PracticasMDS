import GestionAdopciones.Adoptante;
import RecepcionDonaciones.Donante;
import todos.Animal;
import todos.Refugio;
import todos.Socio;
import todos.Voluntario;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

public class Main {
    private static void imprimirRefugio(Refugio r) {
        String separador = "----------------------------------";
        System.out.println();
        System.out.println(separador);
        System.out.println(r);
        System.out.println(separador);
        System.out.println();
    }

    private static <T> void imprimirEnumeration(Enumeration<T> enumeracion) {
        while (enumeracion.hasMoreElements()) {
            T elemento = enumeracion.nextElement();
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        try {
            // Crear un refugio
            Refugio refugio = new Refugio();
            Refugio refugio2 = new Refugio();

            // Crear socios: varios voluntarios, adoptantes y donantes

            Socio voluntarioDonante = new Socio(new Date(),new Voluntario(refugio));
            Socio voluntarioAdoptante = new Socio(new Date(),new Voluntario(refugio));

            voluntarioDonante.agregarRol(new Donante(5, refugio));
            voluntarioAdoptante.agregarRol(new Adoptante(refugio));

            imprimirRefugio(refugio);

            // Registrar múltiples animales
            Animal perro = new Animal("Coco", new Date(120, Calendar.JANUARY, 1), refugio); // Fecha: 1 enero 2020
            Animal gato = new Animal("Michimini", new Date(121, Calendar.JUNE, 10), refugio); // Fecha: 10 junio 2021
            Animal conejo = new Animal("Traviesito", new Date(119, Calendar.MARCH, 15), refugio); // Fecha: 15 marzo 2019
            Animal loro = new Animal("Gor je", new Date(122, Calendar.AUGUST, 5), refugio); // Fecha: 5 agosto 2022

            System.out.println("Registrando animales...");
            voluntarioDonante.registrar(perro);
            voluntarioDonante.registrar(gato);
            voluntarioAdoptante.registrar(conejo);
            voluntarioAdoptante.registrar(loro);
            System.out.println("Animales registrados con éxito.");

            imprimirRefugio(refugio);

            // Mostrar animales registrados en el refugio
            System.out.println("Animales registrados en el refugio:");
            imprimirEnumeration(refugio.getAnimalesRegistrados());
            System.out.println();

            // Adoptar varios animales
            System.out.println("Adoptando a Coco y a Michimini...");
            voluntarioAdoptante.adoptar(perro, voluntarioDonante);
            voluntarioAdoptante.adoptar(gato, voluntarioDonante);
            System.out.println("Adopciones tramitadas con éxito.");

            imprimirRefugio(refugio);

            // Mostrar animales refugiados tras las adopciones
            System.out.println("Animales refugiados después de las adopciones:");
            imprimirEnumeration(refugio.getAnimalesRefugiados());
            System.out.println();

            // Realizar donaciones al refugio
            System.out.println("Realizando donaciones...");
            voluntarioDonante.donar(100.0);
            voluntarioDonante.donar(200.0);
            System.out.println("Donaciones realizadas con éxito.");

            imprimirRefugio(refugio);

            // Mostrar trámites realizados por los voluntarios
            System.out.println("Trámites realizados por los voluntarios:");
            System.out.println("todos.Voluntario 1:");
            imprimirEnumeration(voluntarioDonante.getTramites());
            System.out.println("\ntodos.Voluntario 2:");
            imprimirEnumeration(voluntarioDonante.getTramites());
            System.out.println();

            // Volver a poner un animal en tratamiento y registrar de nuevo
            System.out.println("Ponemos al conejo en tratamiento...");
            conejo.ponerEnTratamiento();
            System.out.println("Estado actual de Traviesito: " + conejo.getEstadoAnimal());

            // Agregar más socios al refugio y mostrar el total
            System.out.println("Añadiendo 2 nuevos socios...");


            Socio v2s = new Socio(new Date(), new Voluntario(refugio));
            Socio a2s = new Socio(new Date(), new Adoptante(refugio));


            imprimirEnumeration(refugio.getSocios());

            imprimirRefugio(refugio);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
