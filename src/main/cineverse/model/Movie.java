package main.cineverse.model;

public abstract class Movie {
    private int id;
    private String title;
    private int durationInMinutes;
    private String genre;
    private int rating;

    public Movie(int id, String title, int duration, String genre, int rating) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = duration;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public int getScore() {
        return rating;
    }

    public abstract String getOrigin();

}
