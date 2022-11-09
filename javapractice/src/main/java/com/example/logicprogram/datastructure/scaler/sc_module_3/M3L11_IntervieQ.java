package com.example.logicprogram.datastructure.scaler.sc_module_3;

public class M3L11_IntervieQ {
    public static void main(String[] args) {

        /*
        * Max consecutive
        * */

        //Ques1: replace 0's with 1
        //Ques2: swap 0's with 1

        //Ques3: No. of triplets : i<j<k and a[i]<a[j]<a[k]
        // Optimise triplet

        //Ques4: Puzzle
        // Josephus Problem : Squid Game
        // Hint : 2, 2^2=4,  4^2=8, 8^2=16, 16^2=32, 64, 128....
        // Now play squid game for N = 2,4,8,16,32,64...
        // if n=2, then last index remain is 1.
        // if n=4, then last index remain is 1.
        // if n=8, then last index remain is 1.
        // if n=16, then last index remain is 1.
        // For n= 6, 9, 11, 15
        // when n=6, killing 2 element will remain 4 : : 1+2*2 = 5th Index Winner
        // when n=9, killing 1 element will remain 8 : 1+1*2 = 3rd Index Winner
        // when n=11, killing 3 element will remain 8 : 1+3*2 = 7th Index Winner
        // when n=15, killing 7 element will remain 8 : 1+7*2 = 15th Index Winner
        // when n=100, killing 36 element will remain 64 : 1+36*2 = 73rd Index Winner
        //
        // Formula : 1+ (Killings*2)

    }

    public static int countTriplets(int[] a){

        // get left count such that a[left] < a[i]
        // get right count such that a[right] > a[i]
        // something related to contribution technique

        int n = a.length;
        int ans = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < a.length; i++) {
            // Elements on left
            for (int left = 0; left < i; left++) {
                if(a[left]<a[i]){
                    l++;
                }
            }
            // Elements on right
            for (int right = i+1; right < i; right++) {
                if(a[right]>a[i]){
                    r++;
                }
            }
            ans = ans+(l*r);
        }
        return ans;
    }


}
