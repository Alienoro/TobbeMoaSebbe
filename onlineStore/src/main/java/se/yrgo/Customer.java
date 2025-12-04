package main.java.se.yrgo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
// 3.Customer:
// Properties: Customer ID, Name, Email
// Metoder:
// View order history
// Place an order

public class Customer {

    private String customerID;
    private String name;
    private String email;
    private List<Order> orders = new ArrayList<>();

    public Customer(String customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    public void placeOrder(List<Product> products) {
        String orderID = UUID.randomUUID().toString();
        Order order = new Order(orderID, products);
        this.orders.add(order);
    }

    public List<Order> orderHistory() {
        return this.orders;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", name=" + name + ", email=" + email + "]";
    }
}

// public class Order {

// private String orderID;
// private List<Product> productsOrdered;

// public Order(String orderID, List<Product> productsOrdered) {
// this.orderID = orderID;
// this.productsOrdered = productsOrdered;
// }

// public String getOrderID(){
// return orderID;
// }

// public List<Product> getProductsOrdered() {
// return productsOrdered;
// }

// }