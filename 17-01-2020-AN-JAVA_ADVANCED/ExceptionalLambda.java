@FunctionalInterface
interface ILambda<T> {
    public T accept(T a, T b);
}

public class ExceptionalLambda {
    public static ILambda<Integer> wrapLambda(ILambda<Integer> lambda) {
        return (a, b) -> {
            try {
                return lambda.accept(a, b);
            } catch (Exception e) {
                System.out.println("Handled Exceptional Exception: " + e);
                return null;
            }
        };
    }

    public static void main(String[] args) {
        ILambda<Integer> lambda = wrapLambda((a, b) -> a / b);

        Integer a = 13, b = 0;
        lambda.accept(a, b);
    }
}
