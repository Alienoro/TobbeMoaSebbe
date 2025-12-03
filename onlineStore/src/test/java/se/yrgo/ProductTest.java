package se.yrgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    void testTotalPrice() {
        Product product = new Product(1, "Corn", 15.39, 2);
        double expectedTotal = 15.39 * 2;
        assertEquals(expectedTotal, product.totalPrice());
    }
}
