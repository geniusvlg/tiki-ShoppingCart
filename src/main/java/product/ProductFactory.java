package product;

public class ProductFactory {

    public static Product createProduct(String type) {
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
