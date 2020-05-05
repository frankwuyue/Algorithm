package Sort;

import java.util.function.Consumer;

public class HeapSort {
    public static <T extends Comparable> void heapSort1(T array[]) {
        int n = array.length;
        IndexMaxHeap<T> indexMaxHeap = new IndexMaxHeap<>(n);
        for (int i = 0; i < n; i++) {
//            indexMaxHeap.insert(array[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            array[i] = indexMaxHeap.extractItem();
        }

    }

    public static <T extends Comparable> void heapSort2(T array[]) {
        int n = array.length;
        IndexMaxHeap<T> indexMaxHeap = new IndexMaxHeap<>(array);
        for (int i = n - 1; i >= 0; i--) {
            array[i] = indexMaxHeap.extractItem();
        }

    }

    public static <T extends Comparable> void heapSort3(T array[]) {
        int n = array.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            __shiftDown(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(array, i, 0);
            __shiftDown(array, i, 0);
        }

    }

    private static <T extends Comparable> void __shiftDown(T array[], int count, int k) {
        while (2 * k + 1 < count) {
            int j = 2 * k + 1; // swap j and k
            if (j + 1 < count && array[j + 1].compareTo(array[j]) > 0) {
                j += 1;
            }

            if (array[k].compareTo(array[j]) >= 0) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }

    private static <T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        SortTestHelper testHelper = new SortTestHelper();
        int n = 1000000;
        Integer[] rand = testHelper.generateRandomArray(n, 0, n);
        Integer[] rand1 = rand.clone();
        Integer[] rand2 = rand.clone();
        Integer[] rand3 = rand.clone();
        Integer[] rand4 = rand.clone();
        Integer[] rand5 = rand.clone();
        Consumer<Integer[]> heapSort1 = HeapSort::heapSort1;
        Consumer<Integer[]> quickSort = QuickSort::quickSort;
        Consumer<Integer[]> quickSortThreeWays = QuickSortThreeWays::quickSort;
        Consumer<Integer[]> mergeSort = MergeSort::mergeSort;
        Consumer<Integer[]> heapSort2 = HeapSort::heapSort2;
        Consumer<Integer[]> heapSort3 = HeapSort::heapSort3;
        SortTestHelper.testSort("heapSort", heapSort1, rand);
        SortTestHelper.testSort("quickSort", quickSort, rand1);
        SortTestHelper.testSort("quickSortThreeWays", quickSortThreeWays, rand2);
        SortTestHelper.testSort("mergeSort", mergeSort, rand3);
        SortTestHelper.testSort("heapSort2", heapSort2, rand4);
        SortTestHelper.testSort("heapSort3", heapSort3, rand5);
        System.out.println(testHelper.isSorted(rand));
        System.out.println(testHelper.isSorted(rand1));
        System.out.println(testHelper.isSorted(rand2));
        System.out.println(testHelper.isSorted(rand3));
        System.out.println(testHelper.isSorted(rand4));
        System.out.println(testHelper.isSorted(rand5));

        System.out.println();

        rand = testHelper.generateNearlyOrderedArray(n, 100);
        rand1 = rand.clone();
        rand2 = rand.clone();
        rand3 = rand.clone();
        rand4 = rand.clone();
        rand5 = rand.clone();
        SortTestHelper.testSort("heapSort", heapSort1, rand);
        SortTestHelper.testSort("quickSort", quickSort, rand1);
        SortTestHelper.testSort("quickSortThreeWays", quickSortThreeWays, rand2);
        SortTestHelper.testSort("mergeSort", mergeSort, rand3);
        SortTestHelper.testSort("heapSort2", heapSort2, rand4);
        SortTestHelper.testSort("heapSort3", heapSort3, rand5);
        System.out.println(testHelper.isSorted(rand));
        System.out.println(testHelper.isSorted(rand1));
        System.out.println(testHelper.isSorted(rand2));
        System.out.println(testHelper.isSorted(rand3));
        System.out.println(testHelper.isSorted(rand4));
        System.out.println(testHelper.isSorted(rand5));

    }
}
