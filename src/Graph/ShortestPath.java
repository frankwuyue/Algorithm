package Graph;

import java.util.*;

public class ShortestPath {

    private Graph graph;
    private boolean visited[];
    private int s;
    private int[] from;
    private int[] ord;


    ShortestPath(Graph graph, int s) {
        assert s >= 0 && s < graph.V();
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        Arrays.fill(visited, false);
        this.from = new int[graph.V()];
        Arrays.fill(from, -1);
        this.ord = new int[graph.V()];
        Arrays.fill(ord, -1);
        this.s = s;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!queue.isEmpty()) {
            int p = queue.remove();
            this.graph.adj(p).forEach(item -> {
                if (!visited[item]) {
                    queue.add(item);
                    visited[item] = true;
                    from[item] = p;
                    ord[item] = ord[p] + 1;
                }
            });
        }

    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.V();
        return visited[w];
    }

    public int length(int w) {
        assert w >= 0 && w < graph.V();
        return ord[w];
    }

    public List<Integer> path(int w) {
        Stack<Integer> stack = new Stack<>();
        int cur = w;
        while (cur != -1) {
            stack.push(cur);
            cur = from[cur];
        }
        List<Integer> path = new ArrayList(stack);
        Collections.reverse(path);
        return path;
    }

    public void showPath(int w) {
        List<Integer> path = this.path(w);
        this.graph.show();
        path.forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println();
    }
}
