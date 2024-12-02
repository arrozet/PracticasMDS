import GestionAdopciones.Adoptante;
import RecepcionDonaciones.Donante;
import todos.Animal;
import todos.Refugio;
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

            // Crear socios: varios voluntarios, adoptantes y donantes
            Voluntario voluntario1 = new Voluntario(new Date(), refugio);
            Voluntario voluntario2 = new Voluntario(new Date(), refugio);
            Adoptante adoptante1 = new Adoptante(new Date(), refugio);
            Adoptante adoptante2 = new Adoptante(new Date(), refugio);
            Donante donante1 = new Donante(new Date(), refugio, 5);
            Donante donante2 = new Donante(new Date(), refugio, 5000);

            imprimirRefugio(refugio);

            // Registrar múltiples animales
            Animal perro = new Animal("Coco", new Date(120, Calendar.JANUARY, 1), refugio); // Fecha: 1 enero 2020
            Animal gato = new Animal("Michimini", new Date(121, Calendar.JUNE, 10), refugio); // Fecha: 10 junio 2021
            Animal conejo = new Animal("Traviesito", new Date(119, Calendar.MARCH, 15), refugio); // Fecha: 15 marzo 2019
            Animal loro = new Animal("Gor je", new Date(122, Calendar.AUGUST, 5), refugio); // Fecha: 5 agosto 2022

            System.out.println("Registrando animales...");
            voluntario1.registrar(perro);
            voluntario1.registrar(gato);
            voluntario2.registrar(conejo);
            voluntario2.registrar(loro);
            System.out.println("Animales registrados con éxito.");

            imprimirRefugio(refugio);

            // Mostrar animales registrados en el refugio
            System.out.println("Animales registrados en el refugio:");
            imprimirEnumeration(refugio.getAnimalesRegistrados());
            System.out.println();

            // Adoptar varios animales
            System.out.println("Adoptando a Coco y a Michimini...");
            adoptante1.adoptar(perro, voluntario1);
            adoptante2.adoptar(gato, voluntario1);
            System.out.println("Adopciones tramitadas con éxito.");

            imprimirRefugio(refugio);

            // Mostrar animales refugiados tras las adopciones
            System.out.println("Animales refugiados después de las adopciones:");
            imprimirEnumeration(refugio.getAnimalesRefugiados());
            System.out.println();

            // Realizar donaciones al refugio
            System.out.println("Realizando donaciones...");
            donante1.donar(100.0);
            donante2.donar(200.0);
            System.out.println("Donaciones realizadas con éxito.");

            imprimirRefugio(refugio);

            // Mostrar trámites realizados por los voluntarios
            System.out.println("Trámites realizados por los voluntarios:");
            System.out.println("todos.Voluntario 1:");
            imprimirEnumeration(voluntario1.getTramites());
            System.out.println("\ntodos.Voluntario 2:");
            imprimirEnumeration(voluntario2.getTramites());
            System.out.println();

            // Volver a poner un animal en tratamiento y registrar de nuevo
            System.out.println("Ponemos al conejo en tratamiento...");
            voluntario1.ponerEnTratamiento(conejo);
            System.out.println("Estado actual de Traviesito: " + conejo.getEstadoAnimal());

            // Agregar más socios al refugio y mostrar el total
            System.out.println("Añadiendo 2 nuevos socios...");

            // Para comprobar que se meten al refugio correctamente
            Voluntario v2 = new Voluntario(new Date(), refugio);
            Adoptante a2 = new Adoptante(new Date(), refugio);

            imprimirEnumeration(refugio.getSocios());

            imprimirRefugio(refugio);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
