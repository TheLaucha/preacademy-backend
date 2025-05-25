package main.primera_evaluacion.service;

import main.primera_evaluacion.model.*;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    public static void main(String[] args){
        Product p1 = new Product.Builder()
                .id(1)
                .price(500)
                .name("Alfajor")
                .category("Almacen")
                .build();
        Product p2 = new Product.Builder()
                .id(2)
                .price(5000)
                .name("Yerba")
                .category("Almacen")
                .build();
        Product p3 = new Product.Builder()
                .id(3)
                .price(10000)
                .name("Auriculares")
                .category("Electro")
                .build();

        Client client = new Client(1,"testclient","testpsw", "Lautaro");
        List<CartItem> items = new ArrayList<>();
        Coupon coupon = new Coupon.Builder().code("#4853").discountPercentage(50).build();

        Cart cart = new Cart(items, null, client);
        cart.addProduct(p1,5);
        cart.addProduct(p2,3);
        cart.addProduct(p3,1);
        cart.setCoupon(coupon);

        // Calcular y mostrar
        System.out.println("Subtotal: " + cart.calculateSubtotal());
        System.out.println("Total con descuento: " + cart.calculateTotalWithDiscount());
        System.out.println("Items filtrados por categoria: " + cart.getItemsByCategory("Almacen"));
        System.out.println("Cantidad total de productos: " + cart.getTotalQuantityProducts());
        System.out.println("Promedio de precios: " + cart.getAverageProductPrice());

        // Resumen Final
        cart.showSummary();
    }
}
