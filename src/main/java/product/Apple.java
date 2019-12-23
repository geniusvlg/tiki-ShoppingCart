package product;

public class Apple implements Product{

    @Override
    public String getName() {
        return "Apple";
    }

    @Override
    public double getPrice() {
        return 4.95;
    }
}
