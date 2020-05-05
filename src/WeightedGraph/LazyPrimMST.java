package WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> graph;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked;
    private ArrayList<Edge<Weight>> mst;
    private Number mstWeight;

    LazyPrimMST(WeightedGraph<Weight> graph) {
        this.graph = graph;
        this.pq = new MinHeap<Edge<Weight>>(graph.E());
        this.marked = new boolean[graph.V()];
        Arrays.fill(marked, false);
        this.mst = new ArrayList<Edge<Weight>>();

        // lazy prim
        visit(0);
        while (!pq.isEmpty()) {
            Edge<Weight> e = pq.extractMin();
            if (marked[e.w()] == marked[e.v()]) {
                continue;
            }
            mst.add(e);
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }
        mstWeight = mst.stream().mapToDouble(item -> item.wt().doubleValue()).sum();
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;
        this.graph.adj(v).forEach(item -> {
            if (!marked[item.other(v)]) {
                this.pq.insert(item);
            }
        });
    }

    public ArrayList<Edge<Weight>> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }
}
