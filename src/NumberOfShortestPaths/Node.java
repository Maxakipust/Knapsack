package NumberOfShortestPaths;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Edge> edges = new ArrayList<>();
    String name;
    boolean visited = false;
    int val = Integer.MAX_VALUE;
    List<Node> lowNodes = new ArrayList<>();

    /**
     * gets a list of unvisited children
     * @return a list of nodes
     */
    public List<Node> getUnvistedChildren(){
        List<Node> res = new ArrayList<>();
        for(Edge e: edges){
            if(!e.dest.visited){
                res.add(e.dest);
            }
        }
        return res;
    }

    public Node(String name){
        this.name = name;
    }

    /**
     * dfs to get the sum of paths to the start
     * @param start the start node
     * @return the number of paths from start to this node
     */
    public int countShortest(Node start){
        if(this == start){
            return 1;
        }
        int sum = 0;
        for(Node n: lowNodes){
            sum += n.countShortest(start);
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append("\n");
        sb.append("Visited: ").append(this.visited).append("\n");
        sb.append("Val: ").append(this.val).append("\n");
        sb.append("lowNodes: {");
        for(Node n: lowNodes){
            sb.append(n.name).append(",");
        }
        sb.append("}");

        return sb.toString();
    }

    /**
     * add an edge to this node
     * @param to the node to connect it to
     * @param weight the weight of the edge
     */
    public void addEdge(Node to, int weight){
        Edge e = new Edge(this, to , weight);
        edges.add(e);
    }
}
