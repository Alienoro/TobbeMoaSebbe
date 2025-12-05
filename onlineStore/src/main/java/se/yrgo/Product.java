package se.yrgo;

public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;

    /**
     * Creates a new product.
     * @param productID Unique productID, must be > 0
     * @param productName Name of product (cannot be null)
     * @param productPrice Price per unit (must be > 0)
     * @param productQuantity Quantity in stock (must be > 0)
     */
    public Product(int productID, String productName, double productPrice, int productQuantity) {
        setProductID(productID);
        setProductName(productName);
        setProductPrice(productPrice);
        setProductQuantity(productQuantity);
    }
    /**
     * Calculates total price based on quantity and unit price
     * @return Total price
     */
    public double totalPrice() {
        return productPrice * productQuantity;
    }

    /**
     * Gets the product ID
     * @return Unique product ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the product ID
     * @param productID Must be > 0
     * @throws IllegalArgumentException if productID <= 0
     */
    public void setProductID(int productID) {
        if (productID <= 0) {
            throw new IllegalArgumentException("Product ID must be positive.");
        }
        this.productID = productID;
    }
    /**
     * Gets the product name
     * @return The product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name
     * @param productName Cannot be null or empty
     * @throws IllegalArgumentException if productName is null or blank
     */
    public void setProductName(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.productName = productName;
    }
    /**
     * Gets the product price.
     * @return the price per unit
     */
    public double getProductPrice() {
        return productPrice;
    }
    /**
     * Sets the product price.
     * @param productPrice must be >= 0
     * @throws IllegalArgumentException if productPrice < 0
     */
    public void setProductPrice(double productPrice) {
        if (productPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.productPrice = productPrice;
    }
    /**
     * Gets the quantity in stock.
     * @return quantity available
     */
    public int getProductQuantity() {
        return productQuantity;
    }
    /**
     * Sets the quantity in stock.
     * @param productQuantity must be >= 0
     * @throws IllegalArgumentException if productQuantity < 0
     */
    public void setProductQuantity(int productQuantity) {
        if (productQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.productQuantity = productQuantity;
    }
    public void reduceStock(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (amount > productQuantity) {
            throw new IllegalArgumentException("Amount cannot be greater than the quantity.");
        }
        productQuantity -= amount;
    }
//    public double buy(int amount){
//        reduceStock(amount);
//        return productPrice * amount;
//    }
    /**
     * Returns a string representation of the product.
     * @return a string describing the product
     */
    @Override
    public String toString() {
        return "Product Details:\n" +
                "----------------\n" +
                "ID       : " + productID + "\n" +
                "Name     : " + productName + "\n" +
                "Price    : " + productPrice + " kr\n" +
                "Quantity : " + productQuantity + "\n" +
                "Total    : " + totalPrice() + " kr";
    }
}
