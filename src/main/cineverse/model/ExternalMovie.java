package main.cineverse.model;

import java.time.LocalDate;

public class ExternalMovie extends Movie {
    private String studioName;
    private LocalDate licenseExpirationDate;

    public ExternalMovie(int id, String title, int durationInMinutes, String genre, int rating,
                         String studioName, LocalDate licenseExpirationDate) {
        super(id, title, durationInMinutes, genre, rating);
        this.studioName = studioName;
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public String getStudioName() {
        return studioName;
    }

    public LocalDate getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    @Override
    public String getOrigin() {
        return "Licenciada";
    }

}
