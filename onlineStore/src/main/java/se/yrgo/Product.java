package se.yrgo;
/**
 * Represents a product in a store.
 * Each product has a unique ID, a name, and a price per unit.
 * Provides methods to access and modify product details,
 * and to calculate total price for a given quantity.
 * Input values are validated and exceptions are thrown for invalid parameters.
 */
public class Product {
    private int productID;
    private String productName;
    private double productPrice;

    /**
     * Creates a new product with the specified ID, name, and price.
     * @param productID Unique productID, must be greater than 0.
     * @param productName Name of product, cannot be null or blank.
     * @param productPrice Price per unit, must be greater than or equal to 0.
     * @throws IllegalArgumentException if any of the parameters are invalid
     */
    public Product(int productID, String productName, double productPrice) {
        setProductID(productID);
        setProductName(productName);
        setProductPrice(productPrice);
    }

    /**
     * Calculates the total price based on quantity and unit price.
     * @param quantity Number of units, must be greater than or equal to 0.
     * @return Total price for the given quantity.
     * @throws IllegalArgumentException if quantity is negative.
     */
    public double totalPrice(int quantity) {
        if (quantity < 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        return productPrice * quantity;
    }
    /**
     * Return the unique product ID.
     * @return Product ID.
     */
    public int getProductID() {
        return productID;
    }
    /**
     * Sets the product ID
     * @param productID Must be greater than 0.
     * @throws IllegalArgumentException if productID is less than or equal to 0.
     */
    public void setProductID(int productID) {
        if (productID <= 0) {
            throw new IllegalArgumentException("Product ID must be positive.");
        }
        this.productID = productID;
    }
    /**
     * Returns the product name.
     * @return The product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name.
     * @param productName Name of product, cannot be null or blank.
     * @throws IllegalArgumentException if productName is null or blank.
     */
    public void setProductName(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.productName = productName;
    }
    /**
     * Returns the price per unit of the product.
     * @return the price per unit.
     */
    public double getProductPrice() {
        return productPrice;
    }
    /**
     * Sets the price per unit of the product.
     * @param productPrice Must be greater than or equal to 0.
     * @throws IllegalArgumentException if productPrice negative, because a product cannot have a negative pricing.
     */
    public void setProductPrice(double productPrice) {
        if (productPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.productPrice = productPrice;
    }
    /**
     * Returns a string representation of the product.
     * @return a string describing the product.
     */
    @Override
    public String toString() {
        return "\nProdukt:\n" +
                "----------------\n" +
                "ID       : " + productID + "\n" +
                "Name     : " + productName + "\n" +
                "Price    : " + productPrice + " kr\n";
    }
}
