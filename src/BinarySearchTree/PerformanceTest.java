package BinarySearchTree;

import java.util.ArrayList;

public class PerformanceTest {
    private static double setTimeTest(Set<String> set, String filename) {
        long start = System.nanoTime();
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile(filename, list);
        System.out.println("Filename: " + filename);
        System.out.println("Total words: " + list.size());
        for (String word : list) {
            set.add(word);
        }
        System.out.println("Total different words: " + set.getSize());
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/BinarySearchTree/pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double timeBstSet = setTimeTest(bstSet, filename);
        System.out.println("BST costs: " + timeBstSet);
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double timeLinkedListSet = setTimeTest(linkedListSet, filename);
        System.out.println("LinkedList costs: " + timeLinkedListSet);
    }

}
