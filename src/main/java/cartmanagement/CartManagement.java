package cartmanagement;

import product.Product;
import product.ProductFactory;
import shoppingcart.ShoppingCart;
import user.User;

import java.util.HashMap;

/**
 * CartManagement is used to manage all users and shopping carts of the system
 */

public class CartManagement {

    private HashMap<User, ShoppingCart> cartMap;
    private static CartManagement cartManagementInstance = null;

    private  CartManagement() {
        cartMap = new HashMap<User, ShoppingCart>();
    }

    public static CartManagement createCartManagement() {
        if(cartManagementInstance == null) {
            cartManagementInstance = new CartManagement();
        }

        return cartManagementInstance;
    }

    public void createCartForUser(User newUser) {
        ShoppingCart shoppingCart = new ShoppingCart();
        cartMap.put(newUser, shoppingCart);
    }

    public void addProductToShoppingCart(User currentUser, String productName, int amount) {
        if(!cartMap.containsKey(currentUser)) {
            System.out.println("USER NOT FOUND");
            return;
        }

        Product newProduct = ProductFactory.createProduct(productName);
        cartMap.get(currentUser).addProduct(newProduct, amount);
    }

    public void removeProductFromShoppingcart(User currentUser, String productName, int amount) {
        if(!cartMap.containsKey(currentUser)) {
            System.out.println("USER NOT FOUND");
            return;
        }

        Product newProduct = ProductFactory.createProduct(productName);
        cartMap.get(currentUser).removeProduct(newProduct, amount);
    }

    public double getTotalMoney(User currentUser) {
        if(!cartMap.containsKey(currentUser)) {
            System.out.println("USER NOT FOUND");
            return 0;
        }

        return cartMap.get(currentUser).getTotalPrice();
    }
}
