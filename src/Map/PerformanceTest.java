package Map;

import BinarySearchTree.FileOperation;

import java.util.ArrayList;

public class PerformanceTest {
    private static double setTimeTest(Map<String, Integer> map, String filename) {
        long start = System.nanoTime();
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile(filename, list);
        System.out.println("Filename: " + filename);
        System.out.println("Total words: " + list.size());
        for (String word : list) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride: " + map.get("pride"));
        System.out.println("Frequency of prejudice: " + map.get("prejudice"));
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/BinarySearchTree/pride-and-prejudice.txt";
        BSTMap<String, Integer> bstMap = new BSTMap<String, Integer>();
        double timeBstMap = setTimeTest(bstMap, filename);
        System.out.println("BST costs: " + timeBstMap);
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<String, Integer>();
        double timeLinkedListMap = setTimeTest(linkedListMap, filename);
        System.out.println("LinkedList costs: " + timeLinkedListMap);
    }

}
