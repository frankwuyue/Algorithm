package Sort;

import java.util.function.Consumer;

public class InsertionSort {

    public static <T extends Comparable> void insertionSort(T[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T e = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1].compareTo(e) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;

        }
    }

    public static <T extends Comparable> void insertionSort(T[] array, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            T e = array[i];
            int j = i;
            for (; j > l && array[j - 1].compareTo(e) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;
        }
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerInsertion = (a) -> {
            insertionSort(a);
        };
        Consumer<Integer[]> consumerSelection = (a) -> {
            SelectionSort.selectionSort(a);
        };


        SortTestHelper testHelper = new SortTestHelper();
        int n = 10000;
        Integer[] rand = testHelper.generateNearlyOrderedArray(n, 100);
        Integer[] rand1 = rand.clone();
        SortTestHelper.testSort("InsertionSort", consumerInsertion, rand);
        SortTestHelper.testSort("SelectionSort", consumerSelection, rand1);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
//        testHelper.printArray(rand);
    }
}
