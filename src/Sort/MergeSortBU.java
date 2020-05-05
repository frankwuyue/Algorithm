package Sort;

import java.util.function.Consumer;

public class MergeSortBU {

    public static <T extends Comparable> void mergeSort(T[] array) {
        int n = array.length;
        for (int i = 1; i <= n; i += i) {
            for (int j = 0; j + i < n; j += i + i) {
                // merge array[j...j+i-1] and array[j+i...j+2*i-1]
                merge(array, j, j + i - 1, Math.min(j + 2 * i - 1, n - 1));
            }
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
//        testHelper.printArray(rand);
    }
}
