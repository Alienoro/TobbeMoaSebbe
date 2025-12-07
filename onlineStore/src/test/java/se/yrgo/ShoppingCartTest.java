package se.yrgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    void testAddProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(1, "Corn", 15.39);

        assertFalse(shoppingCart.addProduct(null), "Should return false if product is null.");
        assertTrue(shoppingCart.addProduct(product), "Should return true if product is added.");

        assertEquals(1, shoppingCart.getShoppingCart().size(), "List size should be one if product was added.");
        assertTrue(shoppingCart.getShoppingCart().contains(product), "shoppingCart should contain product.");
    }

    @Test
    void testCalculateTotalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product(1, "Corn", 20.0));
        shoppingCart.addProduct(new Product(2, "Egg", 20.0));

        assertEquals(40, shoppingCart.calculateTotalPrice(), "Total price should be 40.");
    }

    @Test
    void testCalculateTotalPriceEmptyCart() {
        ShoppingCart shoppingCart = new ShoppingCart();

        assertEquals(0, shoppingCart.calculateTotalPrice(), "Total price should be 0 if cart is empty.");
    }

}
