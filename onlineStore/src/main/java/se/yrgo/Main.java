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
                if (yesOrNo(answer, true)) {
                    break;
                }
            }

            customer.placeOrder(shoppingCart.getShoppingCart());

            System.out.print("Vill du se din totala orderhistorik? (ja/nej): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("ja")) {
                customer.viewOrderHistory();
                System.out.println("Välkommen tillbaka nästa gång!\n");
            } else if (answer.equalsIgnoreCase("nej")) {
                System.out.println("\nVälkommen tillbaka nästa gång!\n");
            } else {
                System.out.println("Felaktig inmatning");
            }
        }
    }

    public static boolean yesOrNo(String answer, boolean isPayment) {
        if (answer.equalsIgnoreCase("ja")) {
            return true;
        } else if (answer.equalsIgnoreCase("nej")) {
            if (isPayment) {
                System.out.println("\nOm du inte vill betala eskorterar vakten dig ut ur butiken.\n");
                System.exit(0);
            }
            return false;
        } else {
            System.out.println("Felaktig inmatning");
        }
        return false;
    }

    public static void printProducts(List<Product> products) {
        int boxesPerRow = 3;
        int count = 0;
        StringBuilder top = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder price = new StringBuilder();
        StringBuilder id = new StringBuilder();
        StringBuilder bottom = new StringBuilder();
        for (Product p : products) {
            top.append("┌──────────────────────┐     ");
            name.append(String.format("│ Produkt: %-12s │     ", p.getProductName()));
            price.append(String.format("│ Pris:    %-12s │     ", p.getProductPrice() + " kr"));
            id.append(String.format("│ ID:      %-12s │     ", p.getProductID()));
            bottom.append("└──────────────────────┘     ");
            count++;
            if (count % boxesPerRow == 0) {
                System.out.println(top);
                System.out.println(name);
                System.out.println(price);
                System.out.println(id);
                System.out.println(bottom);
                System.out.println();
                top.setLength(0);
                name.setLength(0);
                price.setLength(0);
                id.setLength(0);
                bottom.setLength(0);
            }
        } if (!top.isEmpty()) {
            System.out.println(top);
            System.out.println(name);
            System.out.println(price);
            System.out.println(id);
            System.out.println(bottom);
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
                System.out.println("Tyvärr har vi inte den produkten!");
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
        products.add(new Product(11, "Physalis", 29.90));
        products.add(new Product(12, "Socker", 12.90));
        return products;
    }
}