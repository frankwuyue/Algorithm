package UnionFind;

public class UnionFind2 {
    private int[] parent;
    private int count;

    UnionFind2(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int n) {
        if (n >= count) {
            throw new IllegalArgumentException("Over Capacity!");
        }
        while (parent[n] != n) {
            n = parent[n];
        }
        return n;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        parent[pId] = qId;
    }

}
