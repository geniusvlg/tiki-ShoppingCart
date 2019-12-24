package product;

public class Orange extends Product{
    protected Orange() {

    }

    @Override
    public String getName() {
        return "Orange";
    }

    @Override
    public double getPrice() {
        return 3.99;
    }
}
