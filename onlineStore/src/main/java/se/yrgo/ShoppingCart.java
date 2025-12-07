package se.yrgo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    public List<Product> getShoppingCart() {
        return new ArrayList<>(shoppingCart);
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            System.out.println("Kunde inte hitta produkten");
            return false;
        }
        shoppingCart.add(product);
        return true;
    }


    public double calculateTotalPrice() {
        double sum = 0;

        for (Product product : shoppingCart) {
            sum += product.getProductPrice();
        }

        return sum;
    }
}