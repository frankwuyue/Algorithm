package WeightedGraph;

import java.util.ArrayList;

public class KruskalMST<Weight extends Number & Comparable> {
    private ArrayList<Edge<Weight>> mst;
    private Number mstWeight;

    KruskalMST(WeightedGraph<Weight> graph) {
        this.mst = new ArrayList<Edge<Weight>>();
        this.mstWeight = 0;
        MinHeap<Edge<Weight>> pg = new MinHeap<Edge<Weight>>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            graph.adj(i).forEach(item -> {
                if (item.v() < item.w()) {
                    pg.insert(item);
                }
            });
        }

        UnionFind uf = new UnionFind(graph.V());
        while (!pg.isEmpty() && mst.size() < graph.V() - 1) {
            Edge<Weight> e = pg.extractMin();
            if (uf.isConnected(e.v(), e.w())) {
                continue;
            }
            mst.add(e);
            uf.union(e.v(), e.w());
        }
        mstWeight = mst.stream().mapToDouble(item -> item.wt().doubleValue()).sum();
    }

    public ArrayList<Edge<Weight>> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }
}
