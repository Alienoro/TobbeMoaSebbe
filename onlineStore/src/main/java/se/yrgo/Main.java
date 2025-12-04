package se.yrgo;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        addProduct(products);

        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void addProduct(ArrayList<Product> products) {
        products.add(new Product(1, "Banana", 9.90, 100));
        products.add(new Product(2, "Apple", 8.80, 200));
        products.add(new Product(3, "Orange", 8.80, 120));
        products.add(new Product(4, "Pineapple", 12.50, 100));
        products.add(new Product(5, "Pear", 7.20, 90));
    }
}