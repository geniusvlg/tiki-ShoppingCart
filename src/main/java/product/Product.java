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
        Product product = (Product) o;
        return getName() == product.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
