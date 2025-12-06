package se.yrgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void testTotalPrice() {
        Product product = new Product(1, "Corn", 15.39, 2);
        double expectedTotal = 15.39 * 2;
        assertEquals(expectedTotal, product.totalPrice(), "Total price should be equal to price * quantity.");
    }
    @Test
    void testConstructorValid(){
        Product product = new Product(1, "Corn", 15.39, 2);
        assertEquals(1, product.getProductID(), "Should be 1.");
        assertEquals("Corn", product.getProductName(), "Should be Corn.");
        assertEquals(15.39, product.getProductPrice(), "Should be 15.39.");
        assertEquals(2, product.getProductQuantity(), "Should be 2.");
    }
    @Test
    void testConstructorInValid(){
        Product product = new Product(1, "Corn", 15.39, 2);
        assertThrows(IllegalArgumentException.class, () -> new Product(-1, "Corn", 15.39, 2), "Throws IllegalArgumentException if product ID is negative.");
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "", 15.39, 2), "Throws IllegalArgumentException if product name is empty.");
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "Corn", -15.39, 2), "Throws IllegalArgumentException if product price is negative.");
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "Corn", 15.39, -2), "Throws IllegalArgumentException if product quantity is negative.");
    }
    @Test
    void testSettersValid(){
        Product product = new Product(1, "Corn", 15.39, 2);
        product.setProductID(10);
        product.setProductName("Banana");
        product.setProductPrice(20.50);
        product.setProductQuantity(5);

        assertEquals(10, product.getProductID(), "Should be updated to 10.");
        assertEquals("Banana", product.getProductName(), "Should be updated to Banana.");
        assertEquals(20.50, product.getProductPrice(), "Should be updated to 20.50.");
        assertEquals(5, product.getProductQuantity(),"Should be updated to 5.");
    }
    @Test
    void testSettersInvalid(){
        Product product = new Product(1, "Corn", 15.39, 2);
        assertThrows(IllegalArgumentException.class, () -> product.setProductID(-1), "Throws IllegalArgumentException if productID is negative.");
        assertThrows(IllegalArgumentException.class, () -> product.setProductName(""), "Throws IllegalArgumentException if productName is empty.");
        assertThrows(IllegalArgumentException.class, () -> product.setProductPrice(-20.50), "Throws IllegalArgumentException if productPrice is negative.");
        assertThrows(IllegalArgumentException.class, () -> product.setProductQuantity(-5), "Throws IllegalArgumentException if productQuantity is negative.");
    }
}
