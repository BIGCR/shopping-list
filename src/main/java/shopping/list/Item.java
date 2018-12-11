package shopping.list;

public abstract class Item {
    protected String name;
    protected double price;
    protected double subTotal;
    protected boolean isDiscounted;

    public abstract void calculatePrice();

    public abstract void printData();
}