package Sort;

import java.util.function.Consumer;

public class SelectionSortOptimize {

    public static <T extends Comparable> void selectionSort(T[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            if (array[minIndex].compareTo(array[maxIndex]) > 0) {
                swap(array, minIndex, maxIndex);
            }
            for (int i = left + 1; i < right; i++) {
                if (array[i].compareTo(array[minIndex]) < 0) {
                    minIndex = i;
                } else if (array[i].compareTo(array[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
            swap(array, left, minIndex);
            swap(array, right, maxIndex);
            left++;
            right--;
        }


    }

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerOptimize = (a) -> {
            selectionSort(a);
        };

        Consumer<Integer[]> consumer = (a) -> {
            SelectionSort.selectionSort(a);
        };

        SortTestHelper testHelper = new SortTestHelper();
        int n = 10000;
        Integer[] rand = testHelper.generateRandomArray(n, 0, n);
        Integer[] rand1 = rand.clone();

        SortTestHelper.testSort("SelectionSortOptimize", consumerOptimize, rand);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        SortTestHelper.testSort("SelectionSort", consumer, rand1);
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
    }
}
