package ShortestPath;

public class Main {
    public static void main(String[] args) {
//        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/ShortestPath/testG1.txt";
//        SparseWeightedGraph<Double> sparseGraph = new SparseWeightedGraph(5, false);
//        new ReadGraph(sparseGraph, filename);
//        sparseGraph.show();
//
//        Dijkstra<Double> doubleDijkstra = new Dijkstra<>(sparseGraph, 0);
//        for (int i = 1; i < sparseGraph.V(); i++) {
//            System.out.println("Shortest path to " + i + ": " + doubleDijkstra.shortestDistTo(i));
//            doubleDijkstra.showPath(i);
//            System.out.println("-------------");
//        }

//        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/ShortestPath/testG2.txt";
        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/ShortestPath/testG_negative_circle.txt";
        SparseWeightedGraph<Double> sparseGraph = new SparseWeightedGraph(5, true);
        new ReadGraph(sparseGraph, filename);
        sparseGraph.show();

        BellmanFord<Double> bellmanFord = new BellmanFord<>(sparseGraph, 0);
        if (bellmanFord.hasNegativeCycle()) {
            System.out.println("The graph contains negative cycle.");
        } else {
            for (int i = 1; i < sparseGraph.V(); i++) {
                System.out.println("Shortest path to " + i + ": " + bellmanFord.shortestDistTo(i));
                bellmanFord.showPath(i);
                System.out.println("-------------");
            }
        }

    }
}
