package UnionFind;

public class UnionFind {
    private int[] id;
    private int count;

    UnionFind(int n) {
        this.count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int n) {
        if (n >= count) {
            throw new IllegalArgumentException("Over Capacity!");
        }
        return id[n];
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
        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

}
