import java.util.stream.IntStream;

public class Integers {
    public int[] numbers = {3, 1, 5, 6, 7, 9, 15, 3, 4, 7, 10};

    public int findMinimum() {
        return IntStream.of(numbers)
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    public int findMaximum() {
        return IntStream.of(numbers)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        Integers integers = new Integers();

        int minimum = integers.findMinimum();
        int maximum = integers.findMaximum();

        System.out.println("Minimum value: " + minimum);
        System.out.println("Maximum value: " + maximum);
    }
}