package se.yrgo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>(shoppingCart);
    }

    public List<Product> getShoppingCart() {
        return new ArrayList<>(shoppingCart);
    }

    public void addProduct(Product product) {
        if (product != null) {
            shoppingCart.add(product);
        }
    }

    public void removeProduct(Product product) {
        shoppingCart.remove(product);
    }

    public double calculateTotalPrice() {
        double sum = 0;

        for (Product product : shoppingCart) {
            sum += product.getProductPrice() * product.getProductQuantity();
        }

        return sum;
    }

    public void listProducts() {
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }

}
