package designpatterns.decorator;

/**
 * "Decorators" are blend of Inheritance & Composition
 */
public class AddOnOne extends AddOnDecorator {
    public AddOnOne(Base base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return this.base.getDescription() + ", AddOn One";
    }

    @Override
    public double getPrice() {
        return this.base.getPrice() + 10.0;
    }
}
