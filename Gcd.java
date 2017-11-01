package com.company;

/**
 * @author Yulia
 * Find gdc of two numbers
 */
public class Gcd {

    /**
     * find gtc of two numbers
     * @param a integer
     * @param b integer
     * @return GDC(a; b) - integer
     */
    public static Integer gcd(Integer a, Integer b) {
        if (b == 0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) {
        Integer a = InputPrint.getInteger();
        Integer b = InputPrint.getInteger();
        System.out.println(gcd(a, b));
    }
}



/*
        String fastestSort = getFastestSort(algs);
        System.out.println("Самая быстрая сортировка:");
        System.out.println(fastestSort);
    }

    /**
     * Get name of fastest sort
     * @param algs Tester[] array
     * @return name of fastest sort

public static String getFastestSort(Tester[] algs) {

    double minTime = algs[0].time;
    System.out.println(minTime);
    String fastestSort = algs[0].name;
    for (int i = 1; i < algs.length; i++) {
        if (algs[i].time < minTime) {
            fastestSort = algs[i].name;
            minTime = algs[i].time;
        }
    }
    return fastestSort;
} */