package general;

import java.util.Scanner;

/**
 * Created by zafar.imam on 25-10-2017.
 */

public class CountDivisorDemo {
    /*
    You have been given 3 integers - l, r and k. Find how many numbers between l and r (both inclusive)
    are divisible by k. You do not need to print these numbers, you just have to find their count.
     */

    public static void main(String arg[]){

        System.out.println("Enter First Integer : ");
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();

        System.out.println("Enter Second Integer : ");
        int r = scanner.nextInt();

        System.out.println("Enter Third Integer : ");
        int k = scanner.nextInt();

        System.out.println("Entered Numbers are : " +l+" "+r+" "+k);
        findDivisorCount(l,r,k);
    }

    private static void findDivisorCount(int l, int r, int k) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (i%k == 0){
                count++;
            }
        }

        System.out.println("Divisor Count is : "+count);
    }
}
