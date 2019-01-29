package recursion;

/**
 * Created by zafar.imam on 20-09-2017.
 */

public class RecursionDemo {

    public static void main(String... arg) {
        // Factorial factorial = new Factorial();
        //  System.out.println("Factorial of 3 is : "+factorial.fact(3));

        callbhai1();
       /* int var1 = 42;
        int var2 = ~var1;
        System.out.print(var1 + " " + var2);  */
        /*System.out.print("Enter any number : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        findSumUsingRecursion(n);
        findSum(n);*/
    }

    private static void callbhai1() {
/*        boolean a = true;
        boolean b = false;
        boolean c = a ^ b;
        System.out.println(!c);*/
       /* double var1 = 1 + 5;
        double var2 = var1 / 4;
        int var3 = 1 + 5;
        int var4 = var3 / 4;
        System.out.print(var2 + " " + var4);*/
        double a = 295.04;
        int  b = 300;
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + " "  + d);

    }

    private static void callbhai() {
        int x = 2;
        int y = 0;
        for ( ; y < 10; ++y) {
            if (y % x == 0)
                continue;
            else if (y == 8)
                break;
            else
                System.out.print(y + " ");
        }
    }

    private static int findSumUsingRecursion(int n) {
        int sum = n == 0 ? 0 : n % 10 + findSumUsingRecursion(n / 10);

        return sum;
    }

    private static void findSum(int n) {
        if (n == 0)
            return;

       /* int i, sum;
        i = sum = 0;
        while (i < n) {
            sum = sum + (n - i);
            i++;
        }*/
       int sum =0;
        for (int i = 0; i < n; i++) {
            sum = sum+(n-i);
        }

        System.out.println("Sum of " + n + " is : " + sum);
    }
}
