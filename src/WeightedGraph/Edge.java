package WeightedGraph;

public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {
    private int a, b;
    private Weight weight;

    Edge(int v, int w, Weight weight) {
        this.a = v;
        this.b = w;
        this.weight = weight;
    }

    public int v() {
        return a;
    }

    public int w() {
        return b;
    }

    public Weight wt() {
        return weight;
    }

    public int other(int x) {
        assert (x == a) || (x == b);
        return x == a ? b : a;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight.compareTo(that.weight) < 0) {
            return -1;
        } else if (this.weight.compareTo(that.weight) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
