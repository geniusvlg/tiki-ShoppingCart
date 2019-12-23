package product;

public class Orange implements Product{

    @Override
    public String getName() {
        return "Orange";
    }

    @Override
    public double getPrice() {
        return 3.99;
    }
}
