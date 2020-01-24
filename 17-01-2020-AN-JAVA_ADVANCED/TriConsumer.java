@FunctionalInterface
interface ITriConsumer<T, U, V> {
    public void accept(T a, U b, V c);
}

public class TriConsumer {
    public static void main(String[] args) {
        ITriConsumer<Integer, Float, Double> tri = (a, b, c) -> System.out.println(a + b + c);

        Integer a = 13;
        Float b = 42f;
        Double c = 13.37;

        tri.accept(a, b, c);
    }
}
