package com.company;

import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;

/**
 * @author Artem
 */
public class Utility {
    /**
     * Very big number
     */
    public static final Integer INF = 1000000000;

    /**
     * takes miliseconds as a param and returns seconds
     * @param milSeconds miliseconds
     * @return seconds
     */
    public static double convertToSeconds(Long milSeconds){
        return milSeconds / 1000000000.0;
    }

    /**
     * @param number
     * @param degree
     * @return number^degree
     */
    public static int pow(int number, int degree){
        int result = 1;
        for (int i = 1; i <= degree; ++i){
            result *= number;
        }
        return result;
    }

    /**
     * @param range
     * @return random int (-range; range)
     */
    public static int random_int(int range) {
        range = Math.abs(range);
        int randomNum = ThreadLocalRandom.current().nextInt(-range, range + 1);
        return randomNum;
    }

    /**
     * fills list with random numbers
     * @param list list needed to be filled with random numbers
     * @param range range of random numbers
     */
    public static void random_fill(int[] list, int range) {
        for (int i = 0; i < list.length; i++) {
            list[i] = random_int(range);
        }
    }

    /**
     * Swaps two elements in [array]
     * @param a first element id
     * @param b second element id
     */
    public static void swap(int [] array, int a, int b){
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }

    /**
     * @param a
     * @return double with 5 numbers after the comma
     */
    public static String cutDouble(double a){
        String formattedDouble = new DecimalFormat("#0.00000").format(a);
        return formattedDouble;
    }

    /**
     * checks if array is sorted (true) or not (false)
     * @param array
     * @return
     */
    public static boolean sorted(int [] array){
        for (int j = 1; j < array.length; ++j){
            if (array[j] < array[j - 1]) {
                return false;
            }
        }
        return true;
    }
}