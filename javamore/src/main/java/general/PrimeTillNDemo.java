package general;

import java.util.Scanner;

/**
 * Created by zafar.imam on 24-10-2017.
 */

public class PrimeTillNDemo {
    /*
    You are given an integer N. You need to print the series of all prime numbers till N.
     */
    public static void main(String arg[]){
        System.out.print("Enter Number : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PrimeTillNDemo prime = new PrimeTillNDemo();
        prime.printAllPrimes(n);
    }

    private void printAllPrimes(int n) {


        if (n <=1 ){
            System.out.println(n);
        }else {

            String  primeNumbers = "";

            for (int i = 1; i <= n; i++) {
                int flag =0;
                for (int j = i; j >= 1; j--) {

                    if (i %j == 0){

                        flag = flag+1;
                    }
                }

                if (flag == 2){
                    System.out.print(i+" ");
                    //Appended the Prime number to the String
                    primeNumbers = primeNumbers + i + " ";
                }
            }
            System.out.println();
            System.out.println("Prime numbers from 1 to n are : "+ primeNumbers);
        }
    }

    /*private void printPrime() {
        int i = 0,num = 0;
        String primeNumbers = " ";

        for (i = 1; i <= n; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                //Appended the Prime number to the String
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to n are :");
        System.out.println(primeNumbers);
    }*/
}
