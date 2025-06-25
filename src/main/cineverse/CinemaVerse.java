package main.cineverse;

import main.cineverse.model.*;
import main.cineverse.service.PlatformService;

import java.time.LocalDate;

public class CinemaVerse {
    public static void main(String[] args) {
        // Crear plataforma
        Platform cineverse = new Platform("CineVerse");

        // Agregar películas
        Movie m1 = new InternalMovie(1, "Origen", 120, "Ciencia Ficción", 90, "Nolan", "2010");
        Movie m2 = new ExternalMovie(2, "Titanic", 195, "Drama", 95, "Paramount", LocalDate.of(2030, 1, 1));
        cineverse.addMovie(m1);
        cineverse.addMovie(m2);

        // Agregar usuarios
        User u1 = new User(1, "Lautaro", SubscriptionPlan.PREMIUM, "Argentina");
        User u2 = new User(2, "Lucía", SubscriptionPlan.FREE, "Uruguay");
        cineverse.addUser(u1);
        cineverse.addUser(u2);

        // Agregar visualizaciones
        Viewing v1 = new Viewing(m1, u1, LocalDate.of(2025, 6, 1), 120);
        Viewing v2 = new Viewing(m2, u1, LocalDate.of(2025, 6, 2), 100);
        Viewing v3 = new Viewing(m1, u2, LocalDate.of(2025, 6, 3), 60);
        cineverse.addViewing(v1);
        cineverse.addViewing(v2);
        cineverse.addViewing(v3);

        // Instanciar servicio y probar consultas
        PlatformService service = new PlatformService(cineverse);

        System.out.println("Películas vistas completamente:");
        service.getFullyWatchedMovies().forEach(m -> System.out.println(" - " + m.getTitle()));

        System.out.println("\nGéneros más populares:");
        service.getGenrePopularity().forEach((g, c) -> System.out.println(g + ": " + c));

        System.out.println("\nPromedio de minutos por usuario: " + service.getAverageMinutesWatchedByUser());
    }

}
