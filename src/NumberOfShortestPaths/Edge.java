package NumberOfShortestPaths;

public class Edge {
    Node orig;
    Node dest;
    int weight;
    Edge(Node orig, Node dest, int weight){
        this.orig = orig;
        this.dest = dest;
        this.weight = weight;
    }
}
