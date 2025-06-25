package main.cineverse.model;

import java.time.LocalDate;

public class Viewing {
    private Movie movie;
    private User user;
    private LocalDate date;
    private int minutesWatched;

    public Viewing(Movie movie, User user, LocalDate date, int minutesWatched) {
        this.movie = movie;
        this.user = user;
        this.date = date;
        this.minutesWatched = minutesWatched;
    }

    public Movie getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMinutesWatched() {
        return minutesWatched;
    }

}
