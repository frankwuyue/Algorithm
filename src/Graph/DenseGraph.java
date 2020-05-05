package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DenseGraph implements Graph {
    private int n, m;
    private boolean directed;
    private boolean[][] g;

    DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], false);
        }
    }

    private void checkOutOfRange(int v) {
        if (v > n || v < 0) {
            throw new IllegalArgumentException("v is out of range");
        }
    }

    public int V() {
        return this.n;
    }

    public int E() {
        return this.m;
    }

    public void addEdge(int v, int w) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);

        if (this.hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);
        return g[v][w];
    }

    public Iterable<Integer> adj(int v) {
        this.checkOutOfRange(v);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < n; j++) {
                if (g[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
