package se.yrgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = createProducts();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\nVälkommen till Java25 Livs!\n");
            System.out.println("Vänligen skriv in din kundinfo: ");

            String name = Customer.readInput(sc, "Namn");
            String email = Customer.readInput(sc, "Email");
            int id = (int) (Math.random() * 10) + 1;

            Customer customer = new Customer(id, name, email);
            ShoppingCart shoppingCart = new ShoppingCart();

            printProducts(products);

            chooseProduct(sc, products, shoppingCart);

            System.out.println("\nKundvagn: ");

            printShoppingCart(shoppingCart);
            double totalPrice = shoppingCart.calculateTotalPrice();
            System.out.println("\nTotal: " + totalPrice + "kr\n");

            while (true) {
                System.out.print("Vill du betala? (ja/nej): ");
                String answer = sc.nextLine();
                if (yesOrNo(answer)) {
                    break;
                }
            }

            customer.placeOrder(shoppingCart.getShoppingCart());

            while (true) {
                System.out.print("Vill du se din totala orderhistorik? (ja/nej): ");
                String answer = sc.nextLine();
                if (yesOrNo(answer)) {
                    break;
                }
            }

            customer.viewOrderHistory();

            System.out.println("Välkommen tillbaka nästa gång!");
        }
    }

    public static boolean yesOrNo(String answer) {
        if (answer.equalsIgnoreCase("ja")) {
            return true;
        } else if (answer.equalsIgnoreCase("nej")) {
            System.out.println("\nVälkommen tillbaka nästa gång!");
            System.exit(0);
        } else {
            System.out.println("Felaktig inmatning");
        }
        return false;
    }

    public static void printProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println("\nProdukt: " + p.getProductName());
            System.out.println("Pris: " + p.getProductPrice() + "kr");
            System.out.println("ID: " + p.getProductID());
            System.out.println();
        }
    }
    public static void printShoppingCart(ShoppingCart shoppingCart) {
        for (Product p : shoppingCart.getShoppingCart()) {
            System.out.println("Produkt: " + p.getProductName() + " (" + p.getProductPrice() + "kr)");
        }
    }
    public static void chooseProduct(Scanner sc, List<Product> products, ShoppingCart shoppingCart) {
        System.out.println("\nVälj din vara genom att skriva produkt ID! Skriv 0 för att gå vidare till kassan.");
        while (true) {
            System.out.print("Produkt ID: ");

            String input = sc.nextLine();
            int item;
            try {
                item = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning, ange en siffra");
                continue;
            }
            if (item == 0) {
                break;
            }
            Product found = null;
            for (Product p : products) {
                if (p.getProductID() == item) {
                    found = p;
                    break;
                }
            }
            if (found == null) {
                System.out.println("Kunde inte hitta den produkten");
                continue;
            }if (shoppingCart.addProduct(found)) {
                System.out.println("Du lade till " + found.getProductName());
            } else {
                System.out.println("Produkten lades ej till");
            }
        }
    }

    public static List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Äpple", 9.90));
        products.add(new Product(2, "Banan", 9.90));
        products.add(new Product(3, "Mjölk", 14.90));
        products.add(new Product(4, "Bröd", 21.90));
        products.add(new Product(5, "Ägg", 29.90));
        products.add(new Product(6, "Kaffe", 84.90));
        products.add(new Product(7, "Smör", 44.90));
        products.add(new Product(8, "Ost", 54.90));
        products.add(new Product(9, "Juice", 24.90));
        products.add(new Product(10, "Tomat", 2.90));
        return products;
    }
}