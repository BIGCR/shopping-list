package shopping.list;

public interface Item {

    default double calculatePrice(double price, int quantity, boolean discount) {
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