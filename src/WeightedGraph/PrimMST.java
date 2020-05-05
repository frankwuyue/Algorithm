package WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> graph;
    private IndexMinHeap<Weight> pq;
    private Edge<Weight>[] edgeTo;
    private boolean[] marked;
    private ArrayList<Edge<Weight>> mst;
    private Number mstWeight;

    public PrimMST(WeightedGraph<Weight> graph) {
        this.graph = graph;
        this.pq = new IndexMinHeap<Weight>(graph.V());
        this.marked = new boolean[graph.V()];
        Arrays.fill(marked, false);
        this.mst = new ArrayList<Edge<Weight>>();
        this.edgeTo = new Edge[graph.V()];
        Arrays.fill(edgeTo, null);
        // prim
        visit(0);
        while (!pq.isEmpty()) {
            int v = pq.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }
        mstWeight = mst.stream().mapToDouble(item -> item.wt().doubleValue()).sum();
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;
        this.graph.adj(v).forEach(item -> {
            int w = item.other(v);
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    edgeTo[w] = item;
                    pq.insert(w, item.wt());
                } else if (item.wt().compareTo(edgeTo[w].wt()) < 0) {
                    edgeTo[w] = item;
                    pq.change(w, item.wt());
                }
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
