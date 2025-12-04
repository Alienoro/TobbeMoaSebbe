package main.java.se.yrgo;

import org.junit.jupiter.api.Test;

import se.yrgo.Product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("123", "Sebastian Magnusson", "seb@mail.com");
        assertEquals("123", customer.getCustomerID());
        assertEquals("Sebastian Magnusson", customer.getName());
        assertEquals("seb@mail.com", customer.getEmail());
    }

    @Test
    public void testPlaceOrder() {
        Customer customer = new Customer("123", "Sebastian Magnusson", "seb@mail.com");

        Product p1 = new Product(1, "Sneaker Sko", 1099, 1);
        Product p2 = new Product(2, "Klack Sko", 12099, 2);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        customer.placeOrder(products);
        assertEquals(1, customer.orderHistory().size());
        Order order = customer.orderHistory().get(0);

        assertNotNull(order.getOrderID());
        assertEquals(2, order.getProducts().size());
    }

    @Test
    public void testEmptyOrderHistory() {
        Customer customer = new Customer("123", "Sebastian Magnusson", "seb@mail.com");

        assertTrue(customer.orderHistory().isEmpty());
    }
}
