package Graph;

import java.util.*;

public class Path {

    private Graph graph;
    private boolean visited[];
    private int s;
    private int[] from;


    Path(Graph graph, int s) {
        assert s >= 0 && s < graph.V();
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        Arrays.fill(visited, false);
        this.from = new int[graph.V()];
        Arrays.fill(from, -1);
        this.s = s;

        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        graph.adj(v).forEach(item -> {
            if (!visited[item]) {
                from[item] = v;
                dfs(item);
            }
        });
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.V();
        return visited[w];
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
