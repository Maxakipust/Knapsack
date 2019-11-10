package NumberOfShortestPaths;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Edge> edges = new ArrayList<>();

    public Node(){
    }

    public void addEdge(Node to, int weight){
        Edge e = new Edge(this, to , weight);
        edges.add(e);
    }
}
