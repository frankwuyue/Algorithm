package HashTable;

import BinarySearchTree.FileOperation;

import java.util.ArrayList;

public class PerformanceTest {
    private static double setTimeTest(HashTable<String, Integer> set, String filename) {
        long start = System.nanoTime();
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile(filename, list);
        System.out.println("Filename: " + filename);
        System.out.println("Total words: " + list.size());
        for (String word : list) {
            if (set.contains(word)) {
                set.set(word, set.get(word) + 1);
            } else {
                set.add(word, 1);
            }
        }

        for (String word : list) {
            set.contains(word);
        }
        System.out.println("Total different words: " + set.getSize());
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/HashTable/pride-and-prejudice.txt";
        HashTable<String, Integer> hashTable = new HashTable(134111);
        double timeBstSet = setTimeTest(hashTable, filename);
        System.out.println("HashTable costs: " + timeBstSet + "s");
    }

}
