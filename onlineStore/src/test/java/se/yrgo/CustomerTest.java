package se.yrgo;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CustomerTest {


    @Test
    public void testPlaceOrder() {
        Customer customer = new Customer(123, "Sebastian Magnusson", "seb@mail.com");

        Product p1 = new Product(1, "Sneaker Sko", 1099);
        Product p2 = new Product(2, "Klack Sko", 12099);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        customer.placeOrder(products);
        assertEquals(1, customer.orderHistory().size());
        Customer.Orders order = customer.orderHistory().getFirst();

        assertNotNull(order.getOrderID());
        assertEquals(2, order.getproductsOrdered().size());
    }

    @Test
    public void testEmptyOrderHistory() {
        Customer customer = new Customer(123, "Sebastian Magnusson", "seb@mail.com");

        assertTrue(customer.orderHistory().isEmpty());
    }
}