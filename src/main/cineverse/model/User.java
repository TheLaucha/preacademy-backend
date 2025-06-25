package main.cineverse.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private SubscriptionPlan plan;
    private String country;
    private List<Viewing> viewings;

    public User(int id, String username, SubscriptionPlan plan, String country) {
        this.id = id;
        this.username = username;
        this.plan = plan;
        this.country = country;
        this.viewings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public SubscriptionPlan getPlan() {
        return plan;
    }

    public String getCountry() {
        return country;
    }

    public List<Viewing> getViewings() {
        return viewings;
    }

    public void addViewing(Viewing viewing) {
        viewings.add(viewing);
    }
}
