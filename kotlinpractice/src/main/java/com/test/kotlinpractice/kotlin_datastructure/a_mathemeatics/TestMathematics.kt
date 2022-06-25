package com.test.kotlinpractice.kotlin_datastructure.a_mathemeatics

class TestMathematics {

    // Time Complexity : Theta(no. of digit)
    fun countDigits(digit : Int) : Int{
        var x = digit
        var res = 0

        while (x>0){
            x /= 10
            res++
        }
        return res
    }

    // Time Complexity : Theta(no. of digit)
    fun checkPalindrome(digit : Int) : Boolean{
        var temp = digit
        var rev = 0

        // forming reverse of digits
        while (temp>0) {
            val i = temp % 10    // get last digit
            rev = rev * 10 + i   // add last digit to rev in next position
            temp = temp / 10     // remove last digit from temp
        }

        return rev == digit
    }

    // Time Complexity : Theta(no. of digit)
    // Factorial example : Calculate number of ways in a system objects can be arranged.
    fun checkFactorial(digit : Int) : Int{
        //var temp = digit
        var res = digit
        var prevNumb = res - 1
        // forming reverse of digits
        while (prevNumb != 0) {
            res = res * prevNumb
            prevNumb--
        }

        return res
    }

    fun checkFactorialRecursion(n : Int) : Int{
        if(n == 0) return 1
        return checkFactorialRecursion(n-1) * n
    }

    // Time Complexity : Theta(min[a,b])
    fun findGCD(a : Int, b : Int) : Int{
        var min = Math.min(a, b)
        while (min > 0) {
            if(a % min == 0 && b % min == 0){
                break
            }
            min--
        }
        return min
    }

    // Euclid Algorithm : Find GCD in better time complexity
    // Basic Idea : Let "b" be an smaller number than "a"
    //              than -> gcd(a, b) = gcd(a-b, b)
    //              Why ?
    //                  Let "g" be gcd of "a" and "b"
    //                  a = gx, b = gy and gcd(x,y) = 1
    //                  (a-b) = g(x-y)
    // GCD and LCM Relation : https://www.youtube.com/watch?v=utZcJ0leZ_g : (a * b)/gcd = lcm
    // Euclid Algorithm (Follow Long Division) : Divide a and b till remainder becomes zero. In every iteration divisor becomes divident and remainder becomes divisor.
    // divisor[b] ) devident[a] (
    //          some remainder[r1][a%b] ) b (                               // Recursive i/p : (b, a%b)
    //                              some remainder[r2] ) r1 ( 0             // if quotient = 0 then gcd = r2
    // Time Complexity : log(n)
    fun euclidGcd(a : Int, b : Int) : Int{                                  // a= divident , b = divisor
        if(b == 0) return a
        return euclidGcd(b, a%b)
    }

    // Time Complexity : O(n)
    fun isPrime(n : Int) : Boolean{
        if(n <= 0 || n == 1) return false
        for (i in 2 until n){                   // for(i=2; i<n; i++)
            if(n%i == 0) return false
        }
        return true
    }

    // More Efficient Method : iteration reduced by 3 times
    fun isPrimeMoreEfficient(n : Int) : Boolean{
        if(n <= 0 || n == 1) return false
        if(n == 2 || n == 3) return true
        if(n%2 == 0 || n%3 == 0) return false
        for (i in 5..n step 6){
            if(n%i == 0 && n%(i+2) == 0) return false
        }
        return true
    }

    // Prime factors : 2,3,5,7,11,13...
    fun printPrimeFactors(n : Int) : Boolean{
        if(n <= 0 || n == 1) return false
        if(n == 2 || n == 3) return true
        if(n%2 == 0 || n%3 == 0) return false
        for (i in 5..n step 6){
            if(n%i == 0 && n%(i+2) == 0) return false
        }
        return true
    }
}

fun main(){
    val math = TestMathematics()
    println(TestMathematics().countDigits(12034567))
    // Use mod % = Remainder = mod 10 : Used to get the last digit of any number
    // Use multiply * 10 , add last digit in any number
    // Use division /10 , remove last digit in any number
    println(" Palindrome    :  ${math.checkPalindrome(1212)}")
    println(" Factorial     :  ${math.checkFactorial(10)}")
    println(" Factorial Rec :  ${math.checkFactorialRecursion(10)}")
    println(" GCD           :  ${math.findGCD(7, 13)}")
    println(" Euclid GCD    :  ${math.euclidGcd(12, 18)}")
    println(" Euclid GCD    :  ${math.euclidGcd(18, 12)}")
    println(" Euclid LCM    :  ${ 18 * 12 / (math.euclidGcd(18, 12))}")
    println(" GCD 3 number  :  ${math.euclidGcd(math.euclidGcd(18, 12), 12)}")
    println(" Minimum fraction of a : ${18/ math.euclidGcd(18, 12)} and b  :  ${12/ math.euclidGcd(18, 12)}")
    println(" Check Prime   :  ${math.isPrime(3)}")
    println(" Check Prime   :  ${math.isPrimeMoreEfficient(13)}")

}


// Number System :
// Real and Imaginary
// Complex Number : Real + Imaginary = a+_b
// Real Numbers : Integers and Decimal
// Integers : Even and Odd
// Natural Numbers : Prime and Composite
// Prime Number : Exactly two factors i.e 1 and itself. Example : 2, 3, 5, 7, 11, 13
// Composite Numbers : Not Prime : At-least three factors. Example = 4, 10, 12, 14
// Perfect Numbers : Sum of factors of a number equals to that number. Example : 28 , Example : 6 -> 1, 2, 3 = 1+2+3 = 6
// Perfect Square Number : Rational Number (p/q = 0). Example : Sqrt(16), Sqrt(25), Sqrt(49)
// Imperfect Square Number : Irrational Number (p/q != 0). Example : Sqrt(2)














