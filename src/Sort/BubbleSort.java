package Sort;

import java.util.function.Consumer;

public class BubbleSort {

    public static <T extends Comparable> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
        }
    }

    public static <T extends Comparable> void bubbleSortOptimize(T[] array) {
        int n = array.length;
        int newn = n;
        while (newn > 0) {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    swap(array, i - 1, i);
                    newn = i;
                }
            }
            n = newn;
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerBubbleSort = (a) -> {
            bubbleSortOptimize(a);
        };

        Consumer<Integer[]> consumer = (a) -> {
            bubbleSort(a);
        };

        SortTestHelper testHelper = new SortTestHelper();
        int n = 100000;
        Integer[] rand = testHelper.generateRandomArray(n, 0, n);
        Integer[] rand1 = rand.clone();

        SortTestHelper.testSort("BubbleSortOptimize", consumerBubbleSort, rand);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        SortTestHelper.testSort("BubbleSort", consumer, rand1);
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
    }
}
