package com.company;

/**
 * Created by bbern793 on 10/27/2014.
 */

//Testing a brute force method to see how long it would take
    //Wow it's 340 times faster

public class Alt {

    public static void main(String[] args) {
        long literal = 600851475143L;
        long divisor = 2;
        long startTime = System.nanoTime();
//I'm going to check if the last digit ends in an even number. if so, i will do a bitwise operation. perhaps this is faster than modulus a high number?
        while(literal > 1){
            if(0 == (literal % divisor)){
                literal /= divisor;
                divisor--;
            }
            divisor++;
        }
        System.out.println("Largest Prime Factor is: " + divisor);
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }
}
