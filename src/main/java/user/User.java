package user;
import product.Product;
import product.ProductFactory;
import shoppingcart.ShoppingCart;

public class User {
    private String name;
    private String emailAddress;
    private ShoppingCart shoppingCart;

    // Notice, we didn't use and of the getters here
    // Better calling these method in test case, so that we can have a proper usage of these
    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    // Cool here, but why user has to add to shopping cart something?
    // Usually, user will have extra information, and they tend to be a DTO or Model object
    // this means if possible, dont push other logical business logic to this object
    // Suggestion: has another object called CartManagement and extract these functions to that object
    public void addToShoppingCart(String productName, int amount) {
        // This is also create a tightly coupling situation
        // We should pass the whole product, to this method instead of creating it here
        Product newProduct = ProductFactory.createProduct(productName);
        shoppingCart.addProduct(newProduct, amount);
    }

    public void removeFromShoppingcart(String productName, int amount) {
        Product removedProduct = ProductFactory.createProduct(productName);
        shoppingCart.removeProduct(removedProduct, amount);
    }

    public double getTotalMoney() {
        return shoppingCart.getTotalPrice();
    }

    // The position of Constructor, for my preference, should be on top (below members)
    // one user should have only one shopping cart
   public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        // New in Constructor create a tightly coupling situation
        // Imagine the scenario when you need to do the Unit Testing on this
        // ShoppingCart cannot be Mock or Stub because you directly new the object in here
        // Fix Suggestion: using Shopping Cart as pass by parameter
        shoppingCart = new ShoppingCart(this);
   }

}
