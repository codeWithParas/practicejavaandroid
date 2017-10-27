package general;

import java.util.Scanner;

/**
 * Created by zafar.imam on 25-10-2017.
 */

public class SeatArrangementDemo {

    /**seating arrangement is like

    6   7     18  19    30  31      42  43      54  55
    5   8     17  20    29  32      41  44      53  56
    4   9     16  21    28  33      40  45      52  57

    3   10    15  22    27  34      39  46      51  58
    2   11    14  23    26  35      38  47      50  59
    1   12    13  24    25  36      37  48      49  60
     */

    /**
   You will be given a seat number, find out the seat number facing you and the seat type, i.e. WS, MS or AS.
   Window Seat : WS
   Middle Seat : MS
   Aisle Seat : AS
    */
    public static void main(String arg[]){
        System.out.println("Enter your seat number : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printFacingSeat(n);
    }



    private static void findSeat(int n) {
        //1 find the seat WS,MS,AS (WS -(n+6) divisible by 6)
        //2 find Seat number facing you

        //Window Seat n/6, n-1/6
        if ((n%6 == 0) || ((n-1)%6 == 0)){
            System.out.println(n+" is A Window Seat ");
            if ((n%6 == 0 ) && (n%12 != 0)){
                System.out.println(n+1+ " is Front Facing Seat ");
            }
            else if (((n-1)%6 == 0))
            {

            }
            facingSeat();
        }
        else if ((n%3 == 0) || ((n-1)%3 == 0)){
            System.out.println(n+" is A Aisle Seat ");
        }
        else {
            System.out.println(n+" is A Middle Seat ");
        }
    }

    private static void facingSeat() {

    }

    private static void printFacingSeat(int n) {
        if (!(n < 1 || n > 60)){
            findSeat(n);
        }
        else {
            System.out.println("Invalid Seat Number ");
        }
    }
}
