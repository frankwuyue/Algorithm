package Graph;

import java.util.Arrays;

public class Component {

    private Graph graph;
    private boolean visited[];
    private int cCount;
    private int[] id;

    Component(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        Arrays.fill(visited, false);
        this.id = new int[graph.V()];
        Arrays.fill(id, -1);
        this.cCount = 0;

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                cCount++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = this.cCount;
        graph.adj(v).forEach(item -> {
            if (!visited[item]) {
                dfs(item);
            }
        });
    }

    public int count() {
        return this.cCount;
    }

    public boolean isConnected(int v, int w) {
        assert (v >= 0 && v < graph.V());
        assert (w >= 0 && w < graph.V());
        return id[v] == id[w];
    }

}
