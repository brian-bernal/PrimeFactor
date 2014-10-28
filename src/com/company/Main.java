/* Running time is .34 Milliseconds
*  Faster than pure brute force! (Especially at larger numbers)
*/

package com.company;

public class Main {
    static long largestPF = 1L;
    final static long literal = 600851475143L;

    public static void main(String[] args) {
        long startTime = System.nanoTime();  //To find runtime

        Main myMain = new Main();
        System.out.println(literal + " is prime? " + myMain.isPrime(literal) + "\nand the largest PF is: " + largestPF);

        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");  //Printing runtime
    }

    public boolean isPrime(long num) {
        boolean prime = false;
        String number = num + "";
        int lastDigit = Integer.parseInt(number.charAt(number.length() - 1) + "");  //Last digit (faster way to do this?)

        if (num == 2 || num == 3 || num == 5)  //Since 2 is a prime number I have to do this comparison somewhere, same for 3 (3 is divisible by 3, but it could be the largest prime factor) and 5.
            prime = true;
        else if ((lastDigit & 1) == 0) { //If number ends in 0, 2, 4, 6, or 8 it is even and not prime
            prime = false;
            isPrime(num / 2);
        } else if (lastDigit - 5 == 0) { //If number is divisible by 5
            prime = false;
            isPrime(num / 5);
        } else if (divThree(number)) {   //If the number is divisible by 3 it isn't prime
            prime = false;
            isPrime(num / 3);
        } else if (Math.sqrt(num) % 1 == 0)  //If num is the square root of integers it isn't prime
            prime = false;
        else if (isPrimeDivisible(num))  //If num is divisible by a prime it isn't prime
            prime = false;
        else
            prime = true;

        if (prime) {
            if (num > largestPF)
                largestPF = num;
        }
        return prime;
    }

    public boolean isPrimeDivisible(long num) {  //If the number ends in a 1, 3, or 7 it could be prime or divisible by a prime
        int max = (int) Math.sqrt(num);  //Unfortunately must take the square root again
        for (int i = 7; i < max; i += 2) {  //Starts at 7 because it is the first prime number we haven't accounted for. Increment by 2, because we handled all even numbers already
            if (num % i == 0) {
                if (i > largestPF)
                    largestPF = i;
                isPrime(num / i);
                return true;
            }
        }
        return false;
    }

    public boolean divThree(String number) {  //If the sum of the digits in a number is divisible by 3, then the number is divisible by 3 and isn't prime
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {  //Would it be faster to convert to character array?
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        return (sum % 3 == 0);
    }
}