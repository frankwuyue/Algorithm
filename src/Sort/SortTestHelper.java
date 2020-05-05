package Sort;

import java.util.Random;
import java.util.function.Consumer;

public class SortTestHelper {
    public Integer[] generateRandomArray(int n, int rangeFrom, int rangeTo) {
        if (rangeTo < rangeFrom) {
            throw new IllegalArgumentException("rangeFrom must be no greater than rangeTo");
        }
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(rangeTo - rangeFrom + 1) + rangeFrom;
        }
        return array;
    }

    public Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int x = random.nextInt(n + 1);
            int y = random.nextInt(n + 1);
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
        return array;
    }

    public <T extends Comparable> boolean isSorted(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                System.out.println(i + "," + arr[i] + ", " + arr[i + 1]);
                return false;
            }
        }
        return true;
    }

    public <T> void printArray(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable> void testSort(String sortName, Consumer<T[]> consumer, T[] array) {
        long startTime = System.nanoTime();
        consumer.accept(array);
        long endTime = System.nanoTime();
        System.out.println(sortName + ": " + (endTime - startTime) / 1000000000.0);
    }


}
