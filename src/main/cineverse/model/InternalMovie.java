package main.cineverse.model;

public class InternalMovie extends Movie {
    private String directorName;
    private String productionYear;

    public InternalMovie(int id, String title, int durationInMinutes, String genre, int rating,
                         String directorName, String productionYear) {
        super(id, title, durationInMinutes, genre, rating);
        this.directorName = directorName;
        this.productionYear = productionYear;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getProductionYear() {
        return productionYear;
    }

    @Override
    public String getOrigin() {
        return "Propia";
    }

}
