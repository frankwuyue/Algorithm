package ShortestPath;

public class UnionFind {
    private int[] parent;
    private int count;
    private int[] rank; // rank[i] stands for rank/depth of union rooted by i

    UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int n) {
        if (n >= count) {
            throw new IllegalArgumentException("Over Capacity!");
        }
//        while (parent[n] != n) {
//            parent[n] = parent[parent[n]];
//            n = parent[n];
//        }
//        return n;
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
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
        if (rank[pId] < rank[qId]) {
            parent[pId] = qId;
        } else if (rank[qId] < rank[pId]) {
            parent[qId] = pId;
        } else {
            parent[pId] = qId;
            rank[qId] += 1;
        }
    }

}
