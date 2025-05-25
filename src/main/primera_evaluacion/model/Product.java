package main.primera_evaluacion.model;

import java.util.Locale;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;
    private String category;

    public Product(){}

    private Product(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double precio) {
        this.price = precio;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(Product other){
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString(){
        return "Id: " + this.id
                + " Name: " + this.name
                + " Price: " + this.price
                + " Category: " + this.category;
    }

    public static class Builder{
        private int id;
        private String name;
        private double price;
        private String category;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder price (double price){
            this.price = price;
            return this;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
