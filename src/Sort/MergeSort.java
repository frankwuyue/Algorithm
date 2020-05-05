package Sort;

import java.util.function.Consumer;

public class MergeSort {

    public static <T extends Comparable> void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable> void mergeSort(T[] array, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }
//        if (l >= r) {
//            return;
//        }
        int mid = (l + r) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        if (array[mid].compareTo(array[mid + 1]) > 0) {
            merge(array, l, mid, r);
        }
    }

    private static <T extends Comparable> void merge(T[] array, int l, int mid, int r) {
        T[] aux = (T[]) new Comparable[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = array[i];
        }
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                array[k] = aux[j - l];
                j++;
            } else if (j > r) {
                array[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                array[k] = aux[i - l];
                i++;
            } else {
                array[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerMerge = (a) -> {
            mergeSort(a);
        };
        Consumer<Integer[]> consumerInsertion = (a) -> {
            InsertionSort.insertionSort(a);
        };


        SortTestHelper testHelper = new SortTestHelper();
        int n = 10000;
        Integer[] rand = testHelper.generateNearlyOrderedArray(n, 100);
        Integer[] rand1 = rand.clone();
        SortTestHelper.testSort("MergeSort", consumerMerge, rand);
        SortTestHelper.testSort("InsertionSort", consumerInsertion, rand1);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
        testHelper.printArray(rand);
    }
}
