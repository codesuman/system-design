package designpatterns.decorator;

/**
 * "Decorators" are blend of Inheritance & Composition
 */
public class AddOnTwo extends AddOnDecorator{
    public AddOnTwo(Base base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return this.base.getDescription() + ", AddOn Two";
    }

    @Override
    public double getPrice() {
        return this.base.getPrice() + 20.0;
    }
    
}
