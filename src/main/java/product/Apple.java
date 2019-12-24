package product;

public class Apple extends Product{
    protected Apple() {

    }

    @Override
    public String getName() {
        return "Apple";
    }

    @Override
    public double getPrice() {
        return 4.95;
    }
}
