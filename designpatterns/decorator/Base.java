package designpatterns.decorator;

/**
 * Base is an abstract class with the two methods
 * getDescription() and 
 * getPrice()
 */
public abstract class Base {
    private String description = "Unknown";

    /**
     * getDescription is implemented for us, 
     * but we need to implement cost() in the subclasses.
     */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double getPrice();
}