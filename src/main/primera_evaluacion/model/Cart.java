package main.primera_evaluacion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private Coupon coupon;
    private Client client;

    public Cart(){}

    public Cart(Builder builder){
        this.items = builder.items;
        this.coupon = builder.coupon;
        this.client = builder.client;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /* Funcionalidades */

    private CartItem findProductById(int idProd){
        return this.items.stream()
                .filter(cartItem -> cartItem.getProduct().getId() == idProd)
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product, int quantity){
        CartItem foundItem = findProductById(product.getId());

        if(foundItem != null){
            foundItem.setQuantity(foundItem.getQuantity() + quantity);
        }else{
            CartItem item = new CartItem
                    .Builder()
                    .product(product)
                    .quantity(quantity)
                    .build();
            this.items.add(item);
        }
    }

    private void removeProduct(CartItem itemToRemove){
        this.items.remove(itemToRemove);
    }

    public void removeProductById(int idProduct) throws Exception {
        CartItem foundItem = findProductById(idProduct);

        if(foundItem != null){
            if(foundItem.getQuantity() > 1){
                foundItem.setQuantity(foundItem.getQuantity() - 1);
            }else{
                removeProduct(foundItem);
            }
        }else{
            throw new IllegalArgumentException("No existe ningun ITEM con el ID: " + idProduct);
        }
    }

    public double calculateSubtotal(){
        return this.items
                .stream()
                .mapToDouble(item -> item.calculateSubtotal())
                .sum();
    }

    // Falta completar
    public double calculateTotalWithDiscount(){
        double subtotal = this.calculateSubtotal();
        return subtotal - getFinalDiscountAmount(subtotal);
    }

    private double getFinalDiscountAmount(double total){
        double percentage = getFinalDiscountPercentage(total);
        return total * (percentage / 100);
    }

    private double getFinalDiscountPercentage(double total){
        if(this.coupon != null){
            return this.coupon.getDiscountPercentage();
        }else{
            if (total > 10000){
                return 10.0;
            }else if (total > 5000){
                return 5.0;
            }else{
                return 0.0;
            }
        }
    }

    public void applyCupon(Coupon coupon){
        this.coupon = coupon;
    }

    public List<CartItem> getItemsByCategory(String category){
        return this.items
                .stream()
                .filter(item -> item.getProduct().getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public int getTotalQuantityProducts(){
        return this.items.stream()
                .mapToInt(item -> item.getQuantity())
                .sum();
    }

    // El promedio deberia ser con o sin el descuento ??
    public double getAverageProductPrice(){
        int totalQuantity = getTotalQuantityProducts();

        return totalQuantity == 0
                ? 0.0
                : calculateSubtotal() / getTotalQuantityProducts();
    }

    public void showSummary(){
        double subtotal = calculateSubtotal();
        double discountPercentage = getFinalDiscountPercentage(subtotal);
        double discountAmount = getFinalDiscountAmount(subtotal);
        double total = calculateTotalWithDiscount();

        System.out.println(" ==== RESUMEN ==== ");
        this.items.stream().forEach(item -> {
            System.out.println(item.getProduct().toString() + " | Cant: " + item.getQuantity());
        });
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento aplicado:" + " %" + discountPercentage + " = $" + discountAmount);
        System.out.println("Total final: $" + total);
    }

    /* ==== BUILDER ==== */

    public static class Builder{
        private List<CartItem> items = new ArrayList<>();
        private Coupon coupon;
        private Client client;

        public Builder items(List<CartItem> items){
            this.items = items;
            return this;
        }

        public Builder coupon(Coupon coupon){
            this.coupon = coupon;
            return this;
        }

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Cart build(){
            return new Cart(this);
        }
    }
}
