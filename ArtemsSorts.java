package com.company;

/**
 * @author Artem
 */
public class ArtemsSorts {

    public static class Bubble implements Sorts {
        @Override
        public int[] sort(int[] array) {
            int size = array.length;
            // Counts amount of swaps on every loop to check if [array] is already sorted
            boolean swapped = true;

            for (int i = 0; i < size && swapped; ++i) {
                swapped = false;
                // Goes through [array] and swaps every two nearby elements, if they're in wrong order
                for (int j = 0; j < size - 1 - i; ++j) {
                    if (array[j] > array[j + 1]) {
                        Utility.swap(array, j, j + 1);
                        swapped = true;
                    }
                }
            }
            return array;
        }

        @Override
        public String name(int[] list) { return "Artem.BubbleSort"; }
    }

    public static class Counting implements Sorts {
        @Override
        public int[] sort(int[] array) {
            int size = array.length;
            // Biggest number in the [array] used to create temporary
            int maximum = -Utility.INF;
            // Smallest number in [array] used as shift in ids' to save memory
            int shift = Utility.INF;

            for (int i = 0; i < size; ++i) {
                if (array[i] > maximum) {
                    maximum = array[i];
                }
                if (array[i] < shift) {
                    shift = array[i];
                }
            }
            // Size of [temporary] including [shift] and +1
            Integer temporarySize = maximum + 1 - shift;

            // Stores amount of each number in [array]
            Integer[] temporary = new Integer[temporarySize];
            // Fills [temporary] with 0
            for (int number = 0; number < temporarySize; ++number) {
                temporary[number] = 0;
            }
            // Fills [temporary] from [array]
            for (int i = 0; i < size; ++i) {
                temporary[array[i] - shift] += 1;
            }

            // Index of next not yet updated field in [array]
            int index = 0;
            // Refills [array] using [temporary]
            for (int number = 0; number < temporarySize; ++number) {
                if (temporary[number] > 0) {
                    for (int i = 0; i < temporary[number]; ++i, ++index) {
                        array[index] = number + shift;
                    }
                }
            }
            return array;
        }

        @Override
        public String name(int[] list) { return "Artem.CountingSort"; }
    }

    public static class Selection implements Sorts {
        @Override
        public int[] sort(int [] array) {
            int size = array.length;
            // Smallest number in the tail of [array], which will be swapped next
            int minimum;
            int minimumId;

            for (int i = 0; i < size - 1; ++i){
                minimum = Utility.INF;
                minimumId = -1;
                for (int j = i; j < size; ++j){
                    if (array[j] < minimum){
                        minimum = array[j];
                        minimumId = j;
                    }
                }
                Utility.swap(array, i, minimumId);
            }
            return array;
        }
        @Override
        public String name(int[] list) { return "Artem.SelectionSort"; }
    }

    public static class Comb implements Sorts {
        @Override
        public int[] sort(int[] array) {
            int size = array.length;
            // Counts amount of swaps on every loop to check if [array] is already sorted
            boolean swapped = true;

            for (int delta = size; (delta > 1 || swapped); ) {
                if (delta > 1)
                    delta = (int) (delta / 1.247);
                swapped = false;
                // Goes through [array] and swaps every two nearby elements, if they're in wrong order
                for (int j = 0; j + delta < size; ++j) {
                    if (array[j] > array[j + delta]) {
                        Utility.swap(array, j, j + delta);
                        swapped = true;
                    }
                }
            }
            return array;
        }
        @Override
        public String name(int[] list) { return "Artem.CombSort"; }
    }

    public static class Insertion implements Sorts {
        @Override
        public int[] sort(int [] array) {
            int size = array.length;
            int trash, j;

            for (int i = 1; i < size; ++i){
                trash = array[i];
                for (j = i; j > 0 && array[j - 1] > trash; --j){
                    array[j] = array[j - 1];
                }
                array[j] = trash;
            }
            return array;
        }
        @Override
        public String name(int[] list) { return "Artem.InsertionSort"; }
    }
}
