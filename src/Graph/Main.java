package Graph;

public class Main {
    public static void main(String[] args) {
//        int n = 20;
//        int m = 100;
//        Random random = new Random();
//        SparseGraph sparseGraph = new SparseGraph(n, false);
//        for (int i = 0; i < m; i++) {
//            int a = random.nextInt(n);
//            int b = random.nextInt(n);
//            sparseGraph.addEdge(a, b);
//        }
//
//        // o(v)
//        for (int i = 0; i < n; i++) {
//            System.out.print(i + ": ");
//            sparseGraph.adj(i).forEach(item -> {
//                System.out.print(item + " ");
//            });
//            System.out.println();
//        }
//
//        DenseGraph denseGraph = new DenseGraph(n, false);
//        for (int i = 0; i < m; i++) {
//            int a = random.nextInt(n);
//            int b = random.nextInt(n);
//            denseGraph.addEdge(a, b);
//        }
//
//        // O(v^2)
//        for (int i = 0; i < n; i++) {
//            System.out.print(i + ": ");
//            denseGraph.adj(i).forEach(item -> {
//                System.out.print(item + " ");
//            });
//            System.out.println();
//        }
//        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/Graph/testG1.txt";
//        SparseGraph sparseGraph = new SparseGraph(13, false);
//        new ReadGraph(sparseGraph, filename);
//        Component component = new Component(sparseGraph);
//        System.out.println("textG1, Component count: " + component.count());

        String filename2 = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/Graph/testG2.txt";
        SparseGraph sparseGraph2 = new SparseGraph(6, false);
        new ReadGraph(sparseGraph2, filename2);
        Component component2 = new Component(sparseGraph2);
        System.out.println("textG2, Component count: " + component2.count());

        Path pathTextG2 = new Path(sparseGraph2, 0);
        System.out.println("DFS: ");
        pathTextG2.showPath(5);
        ShortestPath shortestPathTextG2 = new ShortestPath(sparseGraph2, 0);
        System.out.println("BFS: ");
        shortestPathTextG2.showPath(5);
//        DenseGraph denseGraph = new DenseGraph(13, false);
//        new ReadGraph(denseGraph, filename);
//        denseGraph.show();

    }
}
