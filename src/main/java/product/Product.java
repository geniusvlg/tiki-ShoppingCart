package product;

import java.util.Objects;

public abstract class Product {
    public abstract String getName();
    public abstract double getPrice();

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) {
            return false;
        }
        // This one logic can be really tricky here, I haven't tested with the built-in equals
        // But in the logic here, when you have 2 products with same name, it is the same
        // Do we want 2 product with the same name really equal to each other?
        // If the answer is yes then it's ok :)
        Product product = (Product) o;

        // Just one thing here, using equals to compare string instead of ==
        return getName() == product.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
