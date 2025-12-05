package se.yrgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private int customerID;
    private String name;
    private String email;
    private List<List<Product>> orderHistory = new ArrayList<>();

    public Customer(int customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    public void placeOrder(List<Product> order) {
        orderHistory.add(order);
    }

    public void viewOrderHistory() {
        for (List<Product> order : orderHistory) {
            System.out.println(order);
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

