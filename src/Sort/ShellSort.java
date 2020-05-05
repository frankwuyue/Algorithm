package Sort;

import java.util.function.Consumer;

public class ShellSort {

    public static <T extends Comparable> void shellSort(T[] array) {
        int n = array.length;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                T e = array[i];
                int j = i;
                for (; j >= h && e.compareTo(array[j - h]) < 0; j -= h)
                    array[j] = array[j - h];
                array[j] = e;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Consumer<Integer[]> consumerShell = (a) -> {
            shellSort(a);
        };
        Consumer<Integer[]> consumerInsertion = (a) -> {
            InsertionSort.insertionSort(a);
        };


        SortTestHelper testHelper = new SortTestHelper();
        int n = 10000;
        Integer[] rand = testHelper.generateNearlyOrderedArray(n, 100);
        Integer[] rand1 = rand.clone();
        SortTestHelper.testSort("ShellSort", consumerShell, rand);
        SortTestHelper.testSort("InsertionSort", consumerInsertion, rand1);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        System.out.println("isSorted: " + testHelper.isSorted(rand1));
//        testHelper.printArray(rand);
    }
}
