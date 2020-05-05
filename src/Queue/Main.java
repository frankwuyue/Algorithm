package Queue;

import Interface.Queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        LoopQueue<Integer> arrayQueue = new LoopQueue<Integer>();
//        for (int i = 0; i < 10; i++) {
//            arrayQueue.enqueue(i);
//            System.out.println(arrayQueue);
//            if (i % 3 == 2) {
//                arrayQueue.dequeue();
//                System.out.println(arrayQueue);
//            }
//        }
        int opCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + ".s");

        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + ".s");
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
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
