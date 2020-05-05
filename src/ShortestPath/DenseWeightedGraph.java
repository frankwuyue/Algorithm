package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n, m;
    private boolean directed;
    private Edge<Weight>[][] g;

    DenseWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], null);
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

    @Override
    public void addEdge(Edge weightEdge) {
        this.addEdge(weightEdge.v(), weightEdge.w(), (Weight) weightEdge.wt());
    }

    private void addEdge(int v, int w, Weight weight) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);

        if (this.hasEdge(v, w)) {
            g[v][w] = null;
            if (!directed) {
                g[w][v] = null;
            }
            m--;
        }
        g[v][w] = new Edge(v, w, weight);
        if (!directed) {
            g[w][v] = new Edge(w, v, weight);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);
        return g[v][w] != null;
    }

    public Iterable<Edge<Weight>> adj(int v) {
        this.checkOutOfRange(v);
        List<Edge<Weight>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                list.add(g[v][i]);
            }
        }
        return list;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].wt() + " ");
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }
}
