package shopping.list;

import static shopping.list.Constants.APPLE;
import static shopping.list.Constants.APPLE_PRICE;
import static shopping.list.Constants.BANANA;
import static shopping.list.Constants.BANANA_PRICE;
import static shopping.list.Constants.ORANGE;
import static shopping.list.Constants.ORANGE_PRICE;
import static shopping.list.Constants.PAPAYA;
import static shopping.list.Constants.PAPAYA_PRICE;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Fruit extends Item {
    public static final Function<Fruit, Double> calculatePapyaDiscount = 
        item -> ((2 * item.price * (item.qty/3)) + (item.price * (item.qty % 3)));
    
    public static Function<Fruit, Double> calculateRegularPrice = fruit -> fruit.qty * fruit.price;

    public static final Map<String, Function<Fruit, Double>> itemDiscounts = new HashMap<>(){{
        put(PAPAYA, Fruit.calculatePapyaDiscount);
    }};

    public static final Map<String, Double> fruitPrices = new HashMap<>(){{
        put(APPLE, APPLE_PRICE);
        put(ORANGE, ORANGE_PRICE);
        put(BANANA, BANANA_PRICE);
        put(PAPAYA, PAPAYA_PRICE);
    }};
    
    public Function<String, Function<Fruit, Double>> retriveCalculationFunction = 
        fruitName -> {
            return itemDiscounts.getOrDefault(fruitName, calculateRegularPrice);
        };
    
    public Consumer<Fruit> printSubtotal = fruit -> System.out.println(
        String.format("%s ($%s/each): $%s", fruit.name, LambdaUtils.formatDouble.apply(fruit.price), LambdaUtils.formatDouble.apply(fruit.subTotal)));
    
    public static BiFunction<String, Long, Fruit> convertToFruitList = 
    (name, qty) -> {
         return new Fruit(name, qty.intValue());
    };

    public static Fruit ConvertMapEntryToFruit(Entry<String, Long> entry) {
        return new Fruit(entry.getKey(), entry.getValue().intValue());
    }

    public static Function<String, Double> getItemPrice = fruitName -> {
        Double itemPrice = 0.0;
        if (Fruit.fruitPrices.containsKey(fruitName)) {
            itemPrice = Fruit.fruitPrices.get(fruitName);
        } else {
            System.out.println("Invalid item!");
        }
        return itemPrice;
    };

    public static Predicate<Entry<String, Fruit>> isItemValid = e -> fruitPrices.containsKey(e.getKey());

    public Fruit(String fruitName, int qty) {
        this.name = fruitName;
        this.qty = qty;
    }
}