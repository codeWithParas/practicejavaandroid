package general;

/**
 * Created by zafar.imam on 15-09-2017.
 */

public class PrintPattern {
    public static void main(String arg[]) {
        printAirtelPattern(4);
    }

    private static void printAirtelPattern(int size) {

        for (int i = 1; i <= size; i++) {

            for (int j = size; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*" + " ");
            }

            System.out.println();
            if (i == size) {
                reversePattern(size);
            }
        }
    }

    private static void reversePattern(int size) {
        for (int i = 1; i < size; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = size - 1; j > i; j--) {
                System.out.print("*" + " ");
            }

            System.out.println();
        }
    }
}
