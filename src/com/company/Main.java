//Ok, I'm starting to get the hang of it. Commit must be local changes, then I push it to the repository. Pull is getting the latest from the repository. Still unsure what publish and sync do.
package com.company;

import java.math.BigInteger;

public class Main {

    static int primeDiv = 1;
    static int largestPF = 1;
    final static long literal = 600851475143L;
    final static int[] primes = {827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public static void main(String[] args) {

        Main myMain = new Main();
        //System.out.println(myMain.isPrime(literal));
        //System.out.println(literal);
        //for (int e : primes) {
        long startTime = System.nanoTime();
        System.out.println(literal + " is prime: " + myMain.isPrime(literal) + " and the largest PF is: " + largestPF);
        //}
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }

    public boolean isPrime(long num) {
        String number = num + "";
        int lastDigit = Integer.parseInt(number.charAt(number.length() - 1) + "");  //Last digit
        boolean prime = false;
        System.out.println("num is: " + num + " and PF is: " + largestPF);

        if (num == 7 || num == 2 || num == 3 || num == 5)
            prime = true;
        else if (lastDigit % 2 == 0)   //if number ends in 0, 2, 4, 6, or 8 it is even and not prime
        {
            prime = false;
            isPrime(num / 2);
        } else if (lastDigit % 5 == 0)//if number is divisible by 5
        {
            prime = false;
            if (largestPF < 5)
                largestPF = 5;
            isPrime(num / 5);
        } else if (divThree(number))   //if the sum of the digits in a number is divisible by 3 it isn't prime
        {
            prime = false;
            isPrime(num / 3);
        } else if (Math.sqrt(num) % 1 == 0)   //If num is the square root of integers it isn't prime
            prime = false;
        else if (isPrimeDivisible(num))  //If num is divisible by a prime it isn't prime
            prime = false;
        else
            prime = true;
        if (prime) {
            if (num > largestPF)
                largestPF = (int)num;//largest factor shouldn't go beyond 2billion as that would be close to largest long
        }
        System.out.println("LPF: " + largestPF);

//if not prime, factor to find greatest prime factor
//factor function
        return prime;
    }

    public boolean isPrimeDivisible(long num) {
        int max = (int) Math.sqrt(num);
        for (int i = 7; i < max; i += 2) {
            if (isPrime(i)) {
                if (num % i == 0) {
                    if (i > largestPF)
                        largestPF = i;
                    //primeDiv = num/i;
                    isPrime(num/i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean divThree(String number) {
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {  //if the sum of the digits in a number is divisible by 3 it is divisible by 3 and isn't prime
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        return (sum % 3 == 0);
    }
}