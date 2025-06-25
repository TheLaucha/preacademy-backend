package main.cineverse.service;

import main.cineverse.model.Movie;
import main.cineverse.model.Platform;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlatformService {
    private final Platform platform;

    public PlatformService(Platform platform) {
        this.platform = platform;
    }

    // ¿Qué películas fueron vistas completamente al menos una vez?
    public List<Movie> getFullyWatchedMovies() {
        return platform.getViewings().stream()
                .filter(v -> v.getMinutesWatched() >= v.getMovie().getDurationInMinutes())
                .map(v -> v.getMovie())
                .distinct()
                .collect(Collectors.toList());
    }

    // ¿Qué generos son los mas populares?
    public Map<String, Long> getGenrePopularity() {
        return platform.getViewings().stream()
                .collect(Collectors.groupingBy(
                        v -> v.getMovie().getGenre(),
                        Collectors.counting()
                ));
    }

    // ¿Qué usuarios consumen más minutos de contenido?
    public Map<Integer, Long> getUserConsumption() {
        return platform.getViewings().stream()
                .collect(Collectors.groupingBy(
                        v -> v.getUser().getId(),
                        Collectors.summingLong(v -> v.getMinutesWatched())
                ));
    }

    // ¿Cuál es el promedio de minutos vistos por usuario?
    public double getAverageMinutesWatchedByUser() {
        int totalMinutesWatched = platform.getViewings()
                .stream().mapToInt(v -> v.getMinutesWatched()).sum();
        int cantUsers = platform.getUsers().size();
        if (cantUsers == 0) return 0;
        return (double) totalMinutesWatched / cantUsers;
    }

}
