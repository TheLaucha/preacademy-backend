import main.primera_evaluacion.model.CartItem;
import main.primera_evaluacion.model.Product;

public static void main (String[] args) {
    /* TEST PRODUCT */
    Product p = new Product.Builder().id(1).price(100).build();
    System.out.println(p.toString());

    /* TEST CARTITEM */
    CartItem cartItem = new CartItem.Builder().product(p).quantity(5).build();
    System.out.println(cartItem.calculateSubtotal());

}
