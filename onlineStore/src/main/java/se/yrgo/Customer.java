package se.yrgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Customer {

    private int customerID;
    private String name;
    private String email;
    private List<Orders> orders = new ArrayList<>();

    public Customer(int customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;

    }


    public void placeOrder(List<Product> products) {
        String orderID = UUID.randomUUID().toString();
        Orders order = new Orders(orderID, products);
        this.orders.add(order);
    }

    public List<Orders> orderHistory() {
        return this.orders;
    }

    public static class Orders {
        private String orderID;
        private List<Product> productsOrdered;

        public Orders(String orderID, List<Product> productsOrdered) {
            this.orderID = orderID;
            this.productsOrdered = productsOrdered; // new ArrayList<>(products);
        }

        public List<Product> getproductsOrdered() {
            return productsOrdered;
        }

        public String getOrderID() {
            return orderID;
        }
    }

    public void viewOrderHistory() {
        List<Orders> orders = this.orderHistory();
        for (Orders order : orders) {
            System.out.println("Detta är ditt Order-ID: " + order.getOrderID());
            for (Product orderProducts : order.getproductsOrdered()) {
                System.out.println(orderProducts);

            }

        }
    }

    public static String readInput(Scanner sc, String type) {
        String input;
        while (true) {
            System.out.print(type + ": ");
            input = sc.nextLine();

            if (type.equalsIgnoreCase("Namn") && input.matches("[a-zA-ZÅÄÖåäö\\- ]+")) {
                return input;
            } else if (type.equalsIgnoreCase("Email") && input.contains("@")) {
                return input;
            } else {
                if (type.equalsIgnoreCase("Namn")) {
                    System.out.println("Ett namn får bara innehålla bokstäver");
                } else if (type.equalsIgnoreCase("Email")) {
                    System.out.println("Måste vara en giltig email adress.");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", name=" + name + ", email=" + email + "]";
    }
}