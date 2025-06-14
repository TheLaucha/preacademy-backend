package main.primera_evaluacion.model;

public class Coupon {
    private String code;
    private double discountPercentage;

    public Coupon(){}

    private Coupon(Builder builder){
        this.code = builder.code;
        this.discountPercentage = builder.discountPercentage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString(){
        return "Codigo: " + this.getCode()
                + " Porcentaje de descuento: " + this.discountPercentage;
    }

    public static class Builder{
        private String code;
        private double discountPercentage;

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public Builder discountPercentage(double discountPercentage){
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Coupon build(){
            return new Coupon(this);
        }
    }
}
