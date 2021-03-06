package Sort;

import java.util.Random;
import java.util.function.Consumer;

public class QuickSort {

    private static Random random = new Random();

    public static <T extends Comparable> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable> void quickSort(T[] array, int l, int r) {
        if (r - l < 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }
        int p = partition(array, l, r);
        quickSort(array, l, p - 1);
        quickSort(array, p + 1, r);
    }

    // partition for array[l...r]
    // return p that array[l...p-1] < array[p] and array[p] < array[p+1...r]
    private static <T extends Comparable> int partition(T[] array, int l, int r) {
        swap(array, l, random.nextInt(r - l + 1) + l);
        T v = array[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i].compareTo(v) < 0) {
                swap(array, j + 1, i);
                j++;
            }
        }
        swap(array, j, l);
        return j;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerQuick = QuickSort::quickSort;
        Consumer<Integer[]> consumerMerge = MergeSort::mergeSort;


        SortTestHelper testHelper = new SortTestHelper();
        int n = 10000;
        Integer[] rand = testHelper.generateRandomArray(n, 0, 10);
        Integer[] rand1 = rand.clone();
        SortTestHelper.testSort("QuickSort", consumerQuick, rand);
        SortTestHelper.testSort("MergeSort", consumerMerge, rand1);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
//        testHelper.printArray(rand);
    }
}
