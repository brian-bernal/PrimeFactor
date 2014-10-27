//Ok, I'm starting to get the hang of it. Commit must be local changes, then I push it to the repository. Pull is getting the latest from the repository. Still unsure what publish and sync do.
package com.company;

public class Main {

    final static int literal = 990;
    final static int[] primes = {827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public static void main(String[] args) {

        Main myMain = new Main();
        //System.out.println(myMain.isPrime(literal));
        //System.out.println(literal);
        for (int e : primes) {
            System.out.println(e + " is prime: " + myMain.isPrime(e));
        }
    }

    public boolean isPrime(int num) {
        String number = num + "";
        int lastDigit = Integer.parseInt(number.charAt(number.length() - 1) + "");  //Last digit

        if (num == 7 || num == 2 || num == 3 || num == 5)
            return true;
        else if (lastDigit % 5 == 0 || lastDigit % 2 == 0)  //if number is divisible by 5 or ends in 0, 2, 4, 6, or 8 it is not prime
            return false;
        else if (divThree(number)) {  //if the sum of the digits in a number is divisible by 3 it isn't prime
            return false;
        } else if (Math.sqrt(num) % 1 == 0) {  //If num is the square root of integers it isn't prime
            return false;
        } else if (isPrimeDivisible(num))  //If num is divisible by a prime it isn't prime
            return false;
        else
            return true;
    }

    public boolean isPrimeDivisible(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 7; i < max; i += 2) {
            if (isPrime(i)) {
                if (num % i == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean divThree(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {  //if the sum of the digits in a number is divisible by 3 it isn't prime
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        return (sum % 3 == 0);
    }
}