package main.models;

public class Electrodomestico {
    private String nombre;
    private double precioBase = 100;
    private String color = "gris plata";
    private int consumoEnergetico = 10;
    private double peso = 2;

    public Electrodomestico(String nombre){
        this.nombre = nombre;
    }

    public Electrodomestico(String nombre, double precioBase, String color, int consumoEnergetico, double peso) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(int consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean esDeBajoConsumo(){
        return this.consumoEnergetico < 45;
    }

    public double balance(){
        return this.precioBase / this.peso;
    }

    public boolean esDeAltaGama(){
        return this.balance() > 3;
    }


}
