package Graph;

import java.util.ArrayList;

public class SparseGraph implements Graph {
    private int n, m;
    private boolean directed;
    private ArrayList<ArrayList<Integer>> g;

    SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.g = new ArrayList<>();
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            g.add(i, new ArrayList<>());
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
        g.get(v).add(w);
        if (v != w && !directed) {
            g.get(w).add(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);
        return g.get(v).contains(w);
    }

    public Iterable<Integer> adj(int v) {
        this.checkOutOfRange(v);
        return g.get(v);
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g.get(i).size(); j++) {
                System.out.print(g.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
