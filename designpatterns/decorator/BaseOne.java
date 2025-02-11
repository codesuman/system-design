package designpatterns.decorator;

public class BaseOne extends Base {
    public BaseOne() {
        this.setDescription("Base One");
    }

    @Override
    public double getPrice() {
        return 100.0;
    }
}
