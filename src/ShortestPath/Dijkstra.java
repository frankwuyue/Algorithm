package ShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Dijkstra<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> graph;
    private int s;
    private boolean[] marked;
    private Weight[] distTo;
    private Edge<Weight>[] from;

    Dijkstra(WeightedGraph<Weight> graph, int s) {
        this.graph = graph;
        this.s = s;
        this.distTo = (Weight[]) new Number[graph.V()];
        this.marked = new boolean[graph.V()];
        this.from = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = (Weight) (Number) 0.0;
            marked[i] = false;
            from[i] = null;
        }
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(graph.V());
        // Dijkstra
        distTo[s] = (Weight) (Number) 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight) (Number) (0.0));
        marked[s] = true;
        ipq.insert(s, distTo[s]);
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;
            // relaxation
            graph.adj(v).forEach(item -> {
                int w = item.other(v);
                if (!marked[w]) {
                    if (from[w] == null || distTo[v].doubleValue() + item.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = (Weight) (Number) (distTo[v].doubleValue() + item.wt().doubleValue());
                        from[w] = item;
                        if (ipq.contain(w)) {
                            ipq.change(w, distTo[w]);
                        } else {
                            ipq.insert(w, distTo[w]);
                        }
                    }
                }
            });
        }
    }

    public Weight shortestDistTo(int w) {
        assert w >= 0 && w < graph.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert w >= 0 && w < graph.V();
        return marked[w];
    }

    // find the shortest path from s to w
    public List shortestPath(int w) {
        assert w >= 0 && w < graph.V();
        assert hasPathTo(w);
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
        assert hasPathTo(w);
        List<Edge<Weight>> list = this.shortestPath(w);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).v() + "->");
            if (i == list.size() - 1) {
                System.out.println(list.get(list.size() - 1).w());
            }
        }
    }
}
