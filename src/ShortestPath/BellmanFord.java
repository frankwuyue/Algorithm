package ShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BellmanFord<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> graph;
    private int s;
    private boolean hasNegativeCycle;
    private Weight[] distTo;
    private Edge<Weight>[] from;

    BellmanFord(WeightedGraph<Weight> graph, int s) {
        this.graph = graph;
        this.s = s;
        this.distTo = (Weight[]) new Number[graph.V()];
        this.from = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = (Weight) (Number) 0.0;
            from[i] = null;
        }
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(graph.V());
        // Bellman-ford
        distTo[s] = (Weight) (Number) 0.0;

        // Relaxation every edge from v-1 times
        for (int i = 1; i < graph.V(); i++) {

            // Relaxation
            for (int j = 0; j < graph.V(); j++) {
                this.graph.adj(j).forEach(item -> {
                    if (from[item.w()] == null || distTo[item.v()].doubleValue() + item.wt().doubleValue() < distTo[item.w()].doubleValue()) {
                        distTo[item.w()] = (Weight) (Number) (distTo[item.v()].doubleValue() + item.wt().doubleValue());
                        from[item.w()] = item;
                    }
                });
            }

        }

        hasNegativeCycle = detectNegativeCycle();

    }

    private boolean detectNegativeCycle() {
        for (int j = 0; j < graph.V(); j++) {
            for (Edge<Weight> item : this.graph.adj(j)) {
                if (from[item.w()] == null || distTo[item.v()].doubleValue() + item.wt().doubleValue() < distTo[item.w()].doubleValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Weight shortestDistTo(int w) {
        assert w >= 0 && w < graph.V();
        assert !hasNegativeCycle;
        return distTo[w];
    }

    public boolean hasNegativeCycle() {
        return this.hasNegativeCycle;
    }

    public boolean hasPathTo(int w) {
        assert w >= 0 && w < graph.V();
        return from[w] != null;
    }

    // find the shortest path from s to w
    public List shortestPath(int w) {
        assert w >= 0 && w < graph.V();
        assert !hasNegativeCycle;
        Stack<Edge<Weight>> stack = new Stack<Edge<Weight>>();
        Edge<Weight> edge = from[w];
        while (edge.v() != this.s) {
            stack.push(edge);
            edge = from[edge.v()];
        }
        stack.push(edge);
        List<Edge<Weight>> list = new ArrayList(stack);
        Collections.reverse(list);
        return list;
    }

    public void showPath(int w) {
        assert w >= 0 && w < graph.V();
        assert !hasNegativeCycle;
        List<Edge<Weight>> list = this.shortestPath(w);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).v() + "->");
            if (i == list.size() - 1) {
                System.out.println(list.get(list.size() - 1).w());
            }
        }
    }
}
