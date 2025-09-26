public class Loops {
    public static void main(String[] args) {
        // int[] numbers = new int[5];
        int[] numbers = {1, 3, 5, 7, 9};

        for (int number : numbers) {
            System.out.println(number);
        }

        for (int number : numbers) {
            if (number % 3 == 0) {
                System.out.println(number);
            }
        }
    }
}
