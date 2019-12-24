package shoppingcart;

import product.Product;
import user.User;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<Product, Integer> products;
    private double total;

    // Static? why? this here means All shopping cart belongs to one user
    // Try to create 2 Shopping Cart and there will have the same owner
    private static User owner;

    public ShoppingCart(User owner) {
        total = 0;
        products = new HashMap<Product, Integer>();
        this.owner = owner;

    }

    public void addProduct(Product newProduct, int amount) {
        if(products.containsKey(newProduct)) {
            // Chain call doesn't look really nice
            // Mostly, it's obstruct the sense of code
            // If we can clear this out by using a new variable here, it's better
            // int oldAmount = products.get(newProduct);
            products.put(newProduct, products.get(newProduct) + amount);
        } else {
            products.put(newProduct, amount);
        }
    }

    // Also, this one literally loop through all products and calculate the number of product
    // Shopping Cart is usually created at run time
    // Means in most case, we don't really need to store the Shopping Cart
    // While dealing with back end, if 1 million users call to this function, every time it needs to loop through all products
    // This would lead to a very bad performance situation
    // It would be a good strategy to maintain a totalPrice as an attribute of the Shopping Cart
    // Every time products are added, we increase the totalPrice by that amount
    public double getTotalPrice() {
        for(Map.Entry<Product, Integer> item: products.entrySet()) {
            // same here, chain call is better replaced with variable
            total += item.getKey().getPrice() * item.getValue();
        }

        return total;
    }


    // This approach is ok, but we can move further by using try catch to handle error
    // Consider using try catch with specific error to deal with abnormal cases
    public boolean removeProduct(Product removedProduct, int amount) {
        if(products.size() == 0) {
            System.out.println("No product to remove");
            return false;
        }

        if(!products.containsKey(removedProduct)) {
            System.out.println("Product not found");
            return false;
        }

        if(products.get(removedProduct) < amount) {
            System.out.println("You remove more products than you have in the cart");
            return false;
        }

        // same here, chain call is better replaced with variable
        products.put(removedProduct, products.get(removedProduct) - amount);
        return true;

    }

    public User getOwner() {
        return owner;
    }
}
