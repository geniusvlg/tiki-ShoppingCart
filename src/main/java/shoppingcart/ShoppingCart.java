package shoppingcart;

import product.Product;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> products;
    private double total;

    public ShoppingCart() {
        total = 0;
        products = new HashMap<Product, Integer>();
    }

    public void addProduct(Product newProduct, int amount) {
        if(products.containsKey(newProduct)) {
            Integer currentAmount = products.get(newProduct);
            products.put(newProduct, currentAmount + amount);

        } else {
            products.put(newProduct, amount);
        }

        total += newProduct.getPrice() * amount;
    }

    public double getTotalPrice() {
        return Math.round(total * 100.0) / 100.0;
    }

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

        Integer currentAmount = products.get(removedProduct);
        products.put(removedProduct, currentAmount - amount);
        total -= removedProduct.getPrice() * amount;

        return true;

    }

}
