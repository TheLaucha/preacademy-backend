package main.PersonExercise;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Persona {
    private String nombre = "N";
    private int edad;
    private LocalDate fechaNacimiento = LocalDate.parse("01-01-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    private String dni;
    private char sexo = 'F';
    private double peso = 1;
    private double altura = 1;

    public Persona(String dni){
        this.dni = dni;
        this.edad = Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public Persona(String dni, String nombre, String apellido){
        this(dni);
        this.nombre = nombre + apellido;
    }

    public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento){
        this(dni, nombre, apellido);
        this.fechaNacimiento = fechaNacimiento;
        // Esto podria ser un metodo
        this.edad = Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double indiceMasaCorporal(){
        return this.peso / (this.altura * this.altura);
    }

    public boolean estaEnForma(){
        return this.indiceMasaCorporal() >= 18.5 && this.indiceMasaCorporal() <= 25;
    }

    public boolean esElDiaDeCumpleanios(){
        LocalDate today = LocalDate.now();
        return this.fechaNacimiento.getDayOfMonth() == today.getDayOfMonth() &&
                this.fechaNacimiento.getMonth() == today.getMonth();
    }

    public boolean esMayorDeEdad(){
        LocalDate today = LocalDate.now();
        Period edad = Period.between(this.fechaNacimiento, today);
        return edad.getYears() >= 18;
    }

    public boolean puedeVotar(){
        LocalDate today = LocalDate.now();
        Period edad = Period.between(this.fechaNacimiento, today);
        return edad.getYears() >= 16;
    }

    public boolean laEdadEsCoherente(){
        int edadCalculada = Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
        return this.edad == edadCalculada;
    }

    public String toString(){
        return "Persona: " +
                "nombre='" + nombre +
                ", edad=" + edad +
                ", fechaNacimiento=" + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                ", dni='" + dni +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura
                ;
    }
}
