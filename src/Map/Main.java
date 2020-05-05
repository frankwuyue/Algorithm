package Map;

import BinarySearchTree.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Pride and prejudice");
//        ArrayList<String> word1 = new ArrayList<>();
//        FileOperation.readFile("/Users/wuyue/IdeaProjects/play-with-data-structure/src/BinarySearchTree/pride-and-prejudice.txt", word1);
//        System.out.println("Total words: " + word1.size());
//
//        LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();
//        for (String word : word1) {
//            if (map.contains(word)) {
//                map.set(word, map.get(word) + 1);
//            } else {
//                map.add(word, 1);
//            }
//        }
//        System.out.println("Total different words: " + map.getSize());
//        System.out.println("Frequency of pride: " + map.get("pride"));
//        System.out.println("Frequency of prejudice: " + map.get("prejudice"));

        System.out.println("Pride and prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("/Users/wuyue/IdeaProjects/play-with-data-structure/src/BinarySearchTree/pride-and-prejudice.txt", word1);
        System.out.println("Total words: " + word1.size());

        BSTMap<String, Integer> map = new BSTMap<String, Integer>();
        for (String word : word1) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride: " + map.get("pride"));
        System.out.println("Frequency of prejudice: " + map.get("prejudice"));
    }
}
