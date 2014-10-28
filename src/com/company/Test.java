package com.company;
/**
 * Brute force technique is slower!
 */

public class Test {
    public static void main(String[] args) {
        long literal = 600851475143L;
        int divisor = 2;
        long startTime = System.nanoTime();

        while(literal > 1){
            if(0 == (literal % divisor)){
                literal /= divisor;
                divisor--;
            }
            divisor++;
        }
        System.out.println(divisor);

        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }
}
