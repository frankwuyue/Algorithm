package Sort;

import java.util.Random;
import java.util.function.Consumer;

public class QuickSortThreeWays {

    private static Random random = new Random();

    public static <T extends Comparable> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }


    // 3 ways to sort array[l...r]
    // partition array[l...r] to <v, ==v, >v
    // recursion to sort <v >v
    public static <T extends Comparable> void quickSort(T[] array, int l, int r) {
        if (r - l < 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }
        // partition
        swap(array, l, random.nextInt(r - l + 1) + l);
        T v = array[l];
        int lt = l; // array[l+1...lt]<v
        int gt = r + 1; // array[gt...r] >v
        int i = l + 1; // array[lt+1...i) == v
        while (i < gt) {
            if (array[i].compareTo(v) < 0) {
                swap(array, i, lt + 1);
                lt++;
                i++;
            } else if (array[i].compareTo(v) > 0) {
                swap(array, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(array, l, lt);
        quickSort(array, l, lt - 1);
        quickSort(array, gt, r);
    }

    // partition for array[l...r]
    // return p that array[l...p-1] < array[p] and array[p] < array[p+1...r]
    private static <T extends Comparable> int partition(T[] array, int l, int r) {
        swap(array, l, random.nextInt(r - l + 1) + l);
        T v = array[l];
        // array[l+1...i) <= v, array(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && array[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && array[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, l, j);
        return j;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerQuickThreeWays = QuickSortThreeWays::quickSort;
        Consumer<Integer[]> consumerQuickTwoPointer = QuickSortTwoPointer::quickSort;
        Consumer<Integer[]> consumerMerge = MergeSort::mergeSort;


        SortTestHelper testHelper = new SortTestHelper();
        int n = 1000000;
        Integer[] rand = testHelper.generateRandomArray(n, 0, 1000);
        Integer[] rand1 = rand.clone();
        Integer[] rand2 = rand.clone();
        SortTestHelper.testSort("QuickSortThreeWays", consumerQuickThreeWays, rand);
        SortTestHelper.testSort("QuickSortTwoPointer", consumerQuickTwoPointer, rand1);
        SortTestHelper.testSort("MergeSort", consumerMerge, rand2);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
        System.out.println("isSorted: " + testHelper.isSorted(rand2));
//        testHelper.printArray(rand);
    }
}
