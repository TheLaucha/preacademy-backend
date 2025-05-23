package main.primera_evaluacion.model;

public class Client extends User{
    private String fullName;

    public Client(Integer id, String username, String password, String fullName) {
        super(id, username, password);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
