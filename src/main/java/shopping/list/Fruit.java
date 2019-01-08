package shopping.list;

import static shopping.list.Constants.*;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import static shopping.list.App.formatDouble;

public class Fruit extends Item {
    private int qty;

    Fruit(String fruitName) {
        this.name = fruitName;
        this.subTotal = 0;
        this.qty = 1;
    }

    
    public Function<String, Double> getItemPrice = fruitName -> {
        Double itemPrice = 0.0;
        if (Constants.fruitPrices.containsKey(fruitName)) {
            itemPrice = Constants.fruitPrices.get(fruitName);
        } else {
            System.out.println("Invalid item!");
        }

        return itemPrice;
    };

    public void calculatePrice(Function<String, Double> function) { 
        double subTotal = 0;
        this.price = function.apply(this.name);
        if(this.isDiscounted){
            int freeItemQty = this.qty / 3;
            int qtyToChargeFor = this.qty - freeItemQty;
            subTotal = price * qtyToChargeFor;
        }else {
            subTotal = this.qty * price;
        }
        this.subTotal = subTotal;
    }
    
    public void printData() { System.out.println(String.format("%s ($%s/each): $%s", this.name, formatDouble(this.price), formatDouble(this.subTotal))); }
    
    public int getQty() { return this.qty; }

    public void incrementQty() { this.qty++; }
}