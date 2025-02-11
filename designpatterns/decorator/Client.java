package designpatterns.decorator;

public class Client {
    public static void main(String[] args) {
        Base baseOne = new BaseOne();
        System.out.println(baseOne.getDescription() + " : " + baseOne.getPrice());

        Base addOnOne = new AddOnOne(baseOne);
        System.out.println(addOnOne.getDescription() + " : " + addOnOne.getPrice());

        Base addOnTwo = new AddOnTwo(baseOne);
        System.out.println(addOnTwo.getDescription() + " : " + addOnTwo.getPrice());
    }
}
