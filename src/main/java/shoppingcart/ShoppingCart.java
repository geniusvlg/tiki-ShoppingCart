package shoppingcart;

import product.Product;
import user.User;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<Product, Integer> products;
    private double total;
    //private static User owner;
    private static ShoppingCart shoppingCartInstance;

    private ShoppingCart(String name, String emailAddress) {
        total = 0;
        products = new HashMap<Product, Integer>();

    }

    public static ShoppingCart createShoppingCart(String name, String emailAddress) {
        if(shoppingCartInstance == null) {
            shoppingCartInstance = new ShoppingCart(name, emailAddress);
        }

        return shoppingCartInstance;
    }

    public void addProduct(Product newProduct, int amount) {
        if(products.containsKey(newProduct)) {
            products.put(newProduct, products.get(newProduct) + amount);
        } else {
            products.put(newProduct, amount);
        }
    }

    public double getTotalPrice() {
        for(Map.Entry<Product, Integer> item: products.entrySet()) {
            total += item.getKey().getPrice() * item.getValue();
        }

        return total;
    }



    public boolean removeProduct(Product removedProduct, int amount) {
        if(!products.containsKey(removedProduct))
            return false;

        if(products.get(removedProduct) < amount) {
            System.out.println("You remove more products than you have in the cart");
            return false;
        }

        products.put(removedProduct, products.get(removedProduct) - amount);
        return true;

    }
}
