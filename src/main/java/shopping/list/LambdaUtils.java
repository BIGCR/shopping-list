package shopping.list;


import java.util.function.Function;
import java.util.function.Consumer;

import shopping.list.Fruit;

public class LambdaUtils {
    public static Function<Double, String> formatDouble = value -> String.format("%.2f", value);
    public static Consumer<Fruit> printBaseItemInfo = fruit -> System.out.println(
            String.format("Name: %s \t Qty: %s \t Price: %s", fruit.name, String.valueOf(fruit.qty), formatDouble.apply(fruit.price)));
}