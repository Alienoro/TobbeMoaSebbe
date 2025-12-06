package se.yrgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void testTotalPrice() {
        Product product = new Product(1, "Corn", 15.39);
        double expectedTotal = 15.39 * 2;
        assertEquals(expectedTotal, product.totalPrice(2), "Total price should be equal to price * quantity.");
    }

    @Test
    void testConstructorValid(){
        Product product = new Product(1, "Corn", 15.39);
        assertEquals(1, product.getProductID(), "Should be 1.");
        assertEquals("Corn", product.getProductName(), "Should be Corn.");
        assertEquals(15.39, product.getProductPrice(), "Should be 15.39.");
    }
    @Test
    void testConstructorInValid(){
        Product product = new Product(1, "Corn", 15.39);
        assertThrows(IllegalArgumentException.class, () -> new Product(-1, "Corn", 15.39), "Throws IllegalArgumentException if product ID is negative.");
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "", 15.39), "Throws IllegalArgumentException if product name is empty.");
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "Corn", -15.39), "Throws IllegalArgumentException if product price is negative.");
    }
    @Test
    void testSettersValid(){
        Product product = new Product(1, "Corn", 15.39);
        product.setProductID(10);
        product.setProductName("Banana");
        product.setProductPrice(20.50);

        assertEquals(10, product.getProductID(), "Should be updated to 10.");
        assertEquals("Banana", product.getProductName(), "Should be updated to Banana.");
        assertEquals(20.50, product.getProductPrice(), "Should be updated to 20.50.");
    }
    @Test
    void testSettersInvalid(){
        Product product = new Product(1, "Corn", 15.39);
        assertThrows(IllegalArgumentException.class, () -> product.setProductID(-1), "Throws IllegalArgumentException if productID is negative.");
        assertThrows(IllegalArgumentException.class, () -> product.setProductName(""), "Throws IllegalArgumentException if productName is empty.");
        assertThrows(IllegalArgumentException.class, () -> product.setProductPrice(-20.50), "Throws IllegalArgumentException if productPrice is negative.");
    }
}
