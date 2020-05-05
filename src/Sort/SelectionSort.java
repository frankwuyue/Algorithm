package Sort;

import java.util.function.Consumer;

public class SelectionSort {

    public static <T extends Comparable> void selectionSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
//        Integer[] array = new Integer[]{3, 4, 1, 4, 9, 0};
//        int n = array.length;
//        selectionSort(array);
//        for (int i = 0; i < n; i++) {
//            System.out.print(array[i] + ", ");
//        }
//
//        System.out.println();
//
//        Double[] arrayDouble = new Double[]{3.2, 4.1, 1.9, 4.5, 9.0, 0.0};
//        int k = arrayDouble.length;
//        selectionSort(arrayDouble);
//        for (int i = 0; i < k; i++) {
//            System.out.print(arrayDouble[i] + ", ");
//        }
//
//        System.out.println();
//
//        String[] arrayString = new String[]{"D", "A", "B", "F", "E"};
//        int j = arrayString.length;
//        selectionSort(arrayString);
//        for (int i = 0; i < j; i++) {
//            System.out.print(arrayString[i] + ", ");
//        }
//
//        System.out.println();
//
//        Student student1 = new Student("E", 78);
//        Student student2 = new Student("A", 67);
//        Student student3 = new Student("B", 79);
//        Student student4 = new Student("F", 90);
//        Student[] students = new Student[]{student1, student2, student3, student4};
//        selectionSort(students);
//        for (int i = 0; i < students.length; i++) {
//            System.out.print(students[i] + ", ");
//        }
//
//        System.out.println();
        Consumer<Integer[]> consumer = (a) -> {
            selectionSort(a);
        };

        SortTestHelper testHelper = new SortTestHelper();
        int n = 100000;
        Integer[] rand = testHelper.generateRandomArray(n, 0, n);

        SortTestHelper.testSort("SelectionSort", consumer, rand);
        System.out.println("isSorted: " + testHelper.isSorted(rand));
        testHelper.printArray(rand);
    }
}
