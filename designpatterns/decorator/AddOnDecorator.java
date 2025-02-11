package designpatterns.decorator;

/**
 * First, we need to be interchangeable with a Base, 
 * so we extend the Base class
 */
public abstract class AddOnDecorator extends Base {
    Base base;

    public AddOnDecorator(Base base) {
        this.base = base;
    }

    /**
     * We’re also going to require that the AddOn decorators 
     * all reimplement the getDescription() method. 
     * Again, we’ll see why in a sec...
     */
    public abstract String getDescription();
}
