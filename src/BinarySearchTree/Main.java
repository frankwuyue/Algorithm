package BinarySearchTree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//        int n = 1000;
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            bst.add(random.nextInt(10000));
//        }
//
//        ArrayList<Integer> numbers = new ArrayList<>();
//        while (!bst.isEmpty()) {
//            numbers.add(bst.removeMin());
//        }
//        System.out.println(numbers);
//        for (int i = 1; i < numbers.size(); i++) {
//            if (numbers.get(i - 1) > numbers.get(i)) {
//                throw new IllegalArgumentException("Error");
//            }
//        }
//        System.out.println("Remove min test completed");
        System.out.println("Pride and prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("/Users/wuyue/IdeaProjects/play-with-data-structure/src/BinarySearchTree/pride-and-prejudice.txt", word1);
        System.out.println("Total words: " + word1.size());

        BSTSet<String> bstSet = new BSTSet<>();
        for (String word : word1) {
            bstSet.add(word);
        }
        System.out.println("Total different words: " + bstSet.getSize());

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        for (String word : word1) {
            linkedListSet.add(word);
        }
        System.out.println("Total different words: " + linkedListSet.getSize());
    }
}
