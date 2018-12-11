package shopping.list;

import static shopping.list.Constants.*;

public class Items {
    private int appleQty; 
    private int orangeQty;
    private int bananaQty;
    private int papayaQty;

    private double totalPrice;
    
    Items() {
        this.appleQty = 0;
        this.bananaQty = 0;
        this.orangeQty = 0;
        this.papayaQty = 0;
        this.totalPrice = 0;
    }

    public void incrementQty(String fruitName) {
        switch (fruitName) {
            case APPLE:
                this.appleQty++;
                break;
            case ORANGE:
                this.orangeQty++;
                break;
            case BANANA:
                this.bananaQty++;
                break;
            case PAPAYA:
                this.papayaQty++;
                break;
        }
    }

    public void printData(String name, double itemPrice, double subtotal) {
        this.totalPrice = this.totalPrice + subtotal;
        System.out.println(String.format("%s ($%s/each): $%s", name, String.format("%.2f", itemPrice), String.format("%.2f", subtotal)));
    }

    public void displayTotals() {
        //Display apple subtotal
        printData(APPLE, APPLE_PRICE, calculatePrice(APPLE_PRICE, this.appleQty, false));
        
        //Display orange subtotal
        printData(ORANGE, ORANGE_PRICE, calculatePrice(ORANGE_PRICE, this.orangeQty, false));

        //Display banana subtotal
        printData(BANANA, BANANA_PRICE, calculatePrice(BANANA_PRICE, this.bananaQty, false));

        //Display papaya subtotal
        printData(PAPAYA, PAPAYA_PRICE, calculatePrice(PAPAYA_PRICE, this.papayaQty, true));

        String formattedTotal = String.format("%.2f", this.totalPrice);
        System.out.println(String.format("%s: $%s", "Total", formattedTotal));
    }


    public double calculatePrice(double price, int quantity, boolean discount) {
        double totalPrice = 0;

        if (discount) {
            int freeItemQty = quantity / 3 ;
            int qtyToChargeFor = quantity - freeItemQty;
            totalPrice = price * qtyToChargeFor;
        } else {
            totalPrice = quantity * price;
        }
        return totalPrice;
    }
}