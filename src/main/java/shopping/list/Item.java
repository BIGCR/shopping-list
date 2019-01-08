package shopping.list;

import com.google.common.base.Function;

public abstract class Item {
    protected String name;
    protected double price;
    protected double subTotal;
    protected boolean isDiscounted;

    public abstract void calculatePrice(Function<String, Double> function);

    public abstract void printData();
}