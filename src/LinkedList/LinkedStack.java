package LinkedList;

import Interface.Stack;
import Stack.ArrayStack;

import java.util.Random;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedStack() {
        list = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return list.size;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Interface.Stack: top ");
        stringBuilder.append(list);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        LinkedStack<Integer> LinkedStack = new LinkedStack<Integer>();
//        for (int i = 0; i < 5; i++) {
//            LinkedStack.push(i);
//            System.out.println(LinkedStack);
//        }
//        LinkedStack.pop();
//        System.out.println(LinkedStack);
        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack: " + time1 + " s");

        LinkedStack<Integer> linkedStack = new LinkedStack<Integer>();
        double time2 = testStack(linkedStack, opCount);
        System.out.println("LinkedStack: " + time2 + " s");
    }

    private static double testStack(Stack<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
