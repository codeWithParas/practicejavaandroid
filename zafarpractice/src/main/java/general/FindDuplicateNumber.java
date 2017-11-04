package general;

import java.util.ArrayList;

/**
 * Created by zafar.imam on 03-10-2017.
 */

public class FindDuplicateNumber {

    public static void main(String arg[]){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        numbers.add(9);
        numbers.add(3);

        printDuplicateNumbers(numbers);

    }

    private static void printDuplicateNumbers(ArrayList<Integer> numbers) {
        System.out.println("List items are : "+numbers.toString());

        for (int i = 0; i < numbers.size(); i++) {

            int j = numbers.get(i);

            for (int k = j+1; k < numbers.size(); k++) {
                if (j == numbers.get(k)){
                    System.out.println("Duplicate is : "+numbers.get(k));
                }
            }

        }
    }
}
