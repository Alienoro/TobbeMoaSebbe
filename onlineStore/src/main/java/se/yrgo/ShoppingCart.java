package se.yrgo;

import java.util.ArrayList;
import java.util.List;
/**
 * The class represents a shopping cart that contains a list of products.
 * It provides methods to add products, retrieve the cart's content, and calculate the total price of all products.
 */
public class ShoppingCart {
    private List<Product> shoppingCart;

    /**
     * Constructs an empty shopping cart.
     * Initializes the shopping cart as an empty list.
     */
    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    /**
     * Retrieves the list of products in the shopping cart.
     *
     * @return a new list containing the products currently in the cart.
     */
    public List<Product> getShoppingCart() {
        return new ArrayList<>(shoppingCart);
    }

    /**
     * Adds a product to the shopping cart.
     * If the provided product is null, an error message will be printed.
     *
     * @param product the product to be added to the cart.
     * @return true if the product was successfully added, false if the product is null.
     */
    public boolean addProduct(Product product) {
        if (product == null) {
            System.out.println("Kunde inte hitta produkten");
            return false;
        }
        shoppingCart.add(product);
        return true;
    }


    /**
     * Calculates the total price of all products in the shopping cart.
     *
     * @return the total price of all products in the cart.
     */
    public double calculateTotalPrice() {
        double sum = 0;

        for (Product product : shoppingCart) {
            sum += product.getProductPrice();
        }

        return sum;
    }
}