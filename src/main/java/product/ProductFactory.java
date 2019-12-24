package product;


public class ProductFactory {

    public static Product createProduct(String type) {
        // Using direct string in Switch case is not a good approach
        // Better replacing it using enum
        switch (type) {
            case "apple":
                return new Apple();
            case "orange":
                return new Orange();
            default:
                return null;
        }
    }
}
