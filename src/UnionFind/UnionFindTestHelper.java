package UnionFind;

import java.util.Random;

public class UnionFindTestHelper {
    public static void testUnionFind1(int n) {
        Random random = new Random();
        UnionFind uf = new UnionFind(n);
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.union(a, b);
        }
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();

        System.out.println("UF1, " + 2 * n + " ops, " + (endTime - startTime) / 1000000000.0);
    }

    public static void testUnionFind2(int n) {
        Random random = new Random();
        UnionFind2 uf = new UnionFind2(n);
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.union(a, b);
        }
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();

        System.out.println("UF2, " + 2 * n + " ops, " + (endTime - startTime) / 1000000000.0);
    }

    public static void testUnionFind3(int n) {
        Random random = new Random();
        UnionFind3 uf = new UnionFind3(n);
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.union(a, b);
        }
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();

        System.out.println("UF3, " + 2 * n + " ops, " + (endTime - startTime) / 1000000000.0);
    }

    public static void testUnionFind4(int n) {
        Random random = new Random();
        UnionFind4 uf = new UnionFind4(n);
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.union(a, b);
        }
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();

        System.out.println("UF4, " + 2 * n + " ops, " + (endTime - startTime) / 1000000000.0);
    }
}
