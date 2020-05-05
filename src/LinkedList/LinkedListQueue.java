package LinkedList;

import Interface.Queue;
import Queue.ArrayQueue;
import Queue.LoopQueue;

import java.util.Random;

public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        Node rev = head;
        head = head.next;
        rev.next = null;

        if (head == null) {
            tail = null;
        }
        size--;
        return rev.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = head;
        stringBuilder.append("Queue front: ");
        while (cur != null) {
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        LinkedListQueue<Integer> LinkedStack = new LinkedListQueue<Integer>();
//        for (int i = 0; i < 5; i++) {
//            LinkedStack.enqueue(i);
//            System.out.println(LinkedStack);
//        }
//        LinkedStack.dequeue();
//        System.out.println(LinkedStack);
        int opCount = 100000;

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        double time1 = testStack(linkedListQueue, opCount);
        System.out.println("LinkedListQueue: " + time1 + " s");

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        double time2 = testStack(arrayQueue, opCount);
        System.out.println("ArrayQueue: " + time2 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time3 = testStack(loopQueue, opCount);
        System.out.println("LoopQueue: " + time3 + " s");
    }

    private static double testStack(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
