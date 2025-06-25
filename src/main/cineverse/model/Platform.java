package main.cineverse.model;

import java.util.ArrayList;
import java.util.List;

public class Platform {
    private String name;
    private List<Movie> movies;
    private List<User> users;
    private List<Viewing> viewings;

    public Platform(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
        this.viewings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Viewing> getViewings() {
        return viewings;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addViewing(Viewing viewing) {
        viewings.add(viewing);
        viewing.getUser().addViewing(viewing); // se actualiza también el usuario
    }

}
