package com.company;

import java.util.Random;
import java.util.Scanner;

public class InputPrint {

    /**
     * Get integer, and check if it is not
     * @return integer
     */
    public static Integer getInteger() {
        Scanner abc = new Scanner(System.in);
        if (abc.hasNextInt()) {
            return abc.nextInt();
        } else {
            System.out.println("Error: вы ввели не число");
            return getInteger();
        }
    }

    /**
     *
     * @param length length of array
     * @return int[] array
     */
    public static int[] getList(Integer length) {
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            list[i] = getInteger();
        }
        return list;
    }

    /**
     * Print array
     * @param list int[] array
     */
    public static void printArray(int[] list) {
        int i;
        for (i = 0; i < list.length - 1; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println(list[i]);
    }

    /**
     * Get rundom int [-range; +range]
     * @param range
     * @return rundom int
     */
    public static Integer getRandomInt(Integer range) {
        Random rand = new Random();
        return rand.nextInt(range);
    }

    /**
     * Get array of lenght lenght filled with numbers [-range; +range]
     * @param lenght lenght of array
     * @param range
     * @return
     */
    public static int[] getRandomArray(Integer lenght, Integer range) {
        int[] list = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            list[i] = getRandomInt(range);
        }
        return list;
    }
}
