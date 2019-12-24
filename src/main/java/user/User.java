package user;
import product.Product;
import product.ProductFactory;
import shoppingcart.ShoppingCart;

public class User {
    private String name;
    private String emailAddress;
    private ShoppingCart shoppingCart = null;

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void addToShoppingCart(String productName, int amount) {
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

    private void createShoppingCart() {
        if(shoppingCart == null)
            shoppingCart = new ShoppingCart(name, emailAddress);
    }

    // one user should have only one shopping cart
   public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
   }

}
