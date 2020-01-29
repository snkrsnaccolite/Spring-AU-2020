import java.util.HashMap;
import java.util.Map;

public class FruitMarket {
    static final Integer NO_OF_FARMERS = 3;
    static final Integer NO_OF_CONSUMERS = 10;
    public static final Integer INVENTORY_LIMIT = 25;

    public static String[] fruits = { "Apple", "Orange", "Grape", "Watermelon" };

    public static HashMap<String, Integer> inventory = new HashMap<String, Integer>(Map.of(
        "Apple", 0,
        "Orange", 0,
        "Grape", 0,
        "Watermelon", 0
    ));

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NO_OF_FARMERS; i++) {
            Thread farmer = new Thread(new Farmer(), "Farmer " + i);
            farmer.start();
        }

        for (int i = 0; i < NO_OF_CONSUMERS; i++) {
            Thread consumer = new Thread(new Consumer(), "Consumer " + i);
            consumer.start();
        }
    }
}
