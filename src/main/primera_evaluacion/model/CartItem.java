package main.primera_evaluacion.model;

public class CartItem {
    private Product product;
    private int quantity = 1; // Por defecto se inicializa con cantidad 1

    public CartItem(){}

    private CartItem(Builder builder){
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateSubtotal(){
        return this.quantity * this.product.getPrice();
    }

    public static class Builder{
        private Product product;
        private int quantity;

        public Builder product(Product product){
            this.product = product;
            return this;
        }

        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public CartItem build(){
            return new CartItem(this);
        }
    }
}
