package shopping.list;

import static shopping.list.Constants.*;

public class Fruit extends Item {
    private int qty;

    Fruit(String fruitName) {
        double price;
        boolean isDiscounted = false;
        switch (fruitName) {
            case APPLE:
                price = APPLE_PRICE;
                break;
            case ORANGE:
                price = ORANGE_PRICE;
                break;
            case BANANA:
                price = BANANA_PRICE;
                break;
            case PAPAYA:
                price = PAPAYA_PRICE;
                isDiscounted = true;
                break;
            default:
                System.out.println("Invalid Item");
                return;
        }
        this.name = fruitName;
        this.price = price;
        this.isDiscounted = isDiscounted;
        this.subTotal = 0;
        this.qty = 1;
    }

    public void calculatePrice() { 
        double subTotal = 0;
        if(this.isDiscounted){
            int freeItemQty = this.qty / 3;
            int qtyToChargeFor = this.qty - freeItemQty;
            subTotal = this.price * qtyToChargeFor;
        }else {
            subTotal = this.qty * this.price;
        }
        this.subTotal = subTotal;
    }

    public void printData() { System.out.println(String.format("%s ($%s/each): $%s", this.name, String.format("%.2f", this.price), String.format("%.2f", this.subTotal))); }
    
    public int getQty() { return this.qty; }

    public void incrementQty() { this.qty++; }
}