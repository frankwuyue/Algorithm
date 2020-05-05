package WeightedGraph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filename = "/Users/wuyue/IdeaProjects/play-with-data-structure/src/WeightedGraph/testG1.txt";
        SparseWeightedGraph<Double> sparseGraph = new SparseWeightedGraph(8, false);
        new ReadGraph(sparseGraph, filename);
        sparseGraph.show();

        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(sparseGraph);
        ArrayList<Edge<Double>> edges = lazyPrimMST.getMst();
        edges.forEach(System.out::println);
        System.out.println("the lazePrimMST weight is " + lazyPrimMST.getMstWeight());

        PrimMST<Double> primMST = new PrimMST<Double>(sparseGraph);
        ArrayList<Edge<Double>> edgesPrim = primMST.getMst();
        edgesPrim.forEach(System.out::println);
        System.out.println("the PrimMST weight is " + primMST.getMstWeight());

        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(sparseGraph);
        ArrayList<Edge<Double>> edgesKruskal = kruskalMST.getMst();
        edgesPrim.forEach(System.out::println);
        System.out.println("the kruskalMST weight is " + kruskalMST.getMstWeight());
    }
}
