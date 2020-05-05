package ShortestPath;

import java.util.ArrayList;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n, m;
    private boolean directed;
    private ArrayList<ArrayList<Edge<Weight>>> g;

    SparseWeightedGraph(int n, boolean directed) {
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

    public void addEdge(Edge edge) {
        this.addEdge(edge.v(), edge.w(), (Weight) edge.wt());
    }

    private void addEdge(int v, int w, Weight weight) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);

        if (this.hasEdge(v, w)) {
            return;
        }
        g.get(v).add(new Edge<Weight>(v, w, weight));
        if (v != w && !directed) {
            g.get(w).add(new Edge<Weight>(w, v, weight));
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        this.checkOutOfRange(v);
        this.checkOutOfRange(w);
        for (int j = 0; j < g.get(v).size(); j++) {
            if (g.get(v).get(j).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Edge<Weight>> adj(int v) {
        this.checkOutOfRange(v);
        return g.get(v);
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g.get(i).size(); j++) {
                Edge edge = g.get(i).get(j);
                System.out.print("{ to: " + edge.other(i) + ", wt: " + edge.wt() + " }, ");
            }
            System.out.println();
        }
    }
}
