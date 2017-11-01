package com.company;

interface Sorts {
    int[] sort (int[] list);
    String name(int[] list);
}

class Tester implements Sorts {
    Sorts alg;
    double time;
    String name;

    public Tester(Sorts givenAlg, String name) {
        this.alg = givenAlg;
        this.name = name;
    }

    @Override
    public int[] sort(int[] list) {
        long start = System.nanoTime();
        list = alg.sort(list);
        long end = System.nanoTime();
        time = (end - start)/1000000000.0;
        /* InputPrint.printArray(list); */
        return list;
    }

    @Override
    public String name(int[] list) {
        list = alg.sort(list);
        return name;
    }
}

public class Testspeed {

    public static void main (String[] args) {
        Tester[] algs = new Tester[]{
                new Tester(new Sort.Bubble(), "Yulia.bubbleSort"),
                new Tester(new Sort.Comb(), "Yulia.combSort"),
                new Tester(new Sort.Gnome(), "Yulia.gnomeSort"),
                new Tester(new Sort.Selection(), "Yulia.selectionSort"),
                new Tester(new Sort.Stupid(), "Yulia.stupidSort")
        };

        System.out.println("Введите длину массива");
        Integer length = InputPrint.getInteger();
        Integer range = 10000;
        int[] list = InputPrint.getRandomArray(length, range);

        for (Tester alg : algs) {
            int[] toSort = list.clone();
            alg.sort(toSort);
            System.out.println(alg.name);
            System.out.println(alg.time);
        }
    }
}
