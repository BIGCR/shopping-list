package shopping.list;

public class Item {
    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";
    public static final String BANANA = "Banana";
    public static final String PAPAYA = "Papaya";

    private int appleQty; 
    private int orangeQty;
    private int bananaQty;
    private int papayaQty;

    private static final double PRICE = .25;
    
    Item() {
        this.appleQty = 0;
        this.bananaQty = 0;
        this.orangeQty = 0;
        this.papayaQty = 0;
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

    public void displayTotals() {
        //Display apple subtotal
        double appleSubTotal = calculatePrice(.25, this.appleQty, false);
        System.out.println(APPLE + ": " + String.format("%.2f", appleSubTotal));

        double orangeSubTotal = calculatePrice(.30, this.orangeQty, false);
        System.out.println(ORANGE + ": " + String.format("%.2f",orangeSubTotal));

        double bananaSubTotal = calculatePrice(.15, this.bananaQty, false);
        System.out.println(BANANA + ": " + String.format("%.2f", bananaSubTotal));

        double papayaSubTotal = calculatePrice(.50, this.papayaQty, true);
        System.out.println(PAPAYA + ": " + String.format("%.2f", papayaSubTotal));

        double totalPrice = appleSubTotal + orangeSubTotal + bananaSubTotal + papayaSubTotal;
        System.out.println("Total: " + String.format("%.2f", totalPrice));
    }

    public double calculatePrice(double price, int quantity, boolean discount) {
        double totalPrice = 0;

        if (discount) {
            // Multiply by 2 because we charge for 2 items when buying multples of 3
            int qtyToCharge = quantity / 3 ;
            int qtyToChargeAfterDiscount = quantity - qtyToCharge;
            System.out.println("qtyToCharge: " + qtyToCharge + "\nqtyToChargeAfterDiscount: " + qtyToChargeAfterDiscount);
            totalPrice = price * qtyToChargeAfterDiscount;
        } else {
            totalPrice = quantity * price;
        }
        return totalPrice;
    }
}