package NumberOfShortestPaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfShort {

    /**
     * calculates the number of shortest paths from start to end
     * @param start the starting node
     * @param end the ending node
     * @return the number of paths
     */
    static int numberOfSortest( Node start, Node end){
        //start off the bfs from start
        List<Node> queue = new LinkedList<>();
        queue.add(start);
        start.val = 0;

        while(queue.size() != 0){
            Node n = queue.get(0);
            for(Edge e: n.edges){
                int newVal = n.val + e.weight;
                //if we have a path with the same value as it already has, then we just add it
                if(e.dest.val == newVal){
                    e.dest.lowNodes.add(n);
                }else if(e.dest.val > newVal){
                    // if we have a lower path we need to reset it
                    e.dest.lowNodes = new ArrayList<>();
                    e.dest.lowNodes.add(n);
                    e.dest.val = newVal;
                }
            }
            queue.addAll(n.getUnvistedChildren());
            n.visited = true;
            queue.remove(0);
        }
        //then we need to do a dfs from the end to the start counting the paths to start
        return end.countShortest(start);
    }

    public static void main(String[] args) {
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        n1.addEdge(n2, 3);
        n1.addEdge(n3, 2);
        n1.addEdge(n4, 5);
        n2.addEdge(n4, 2);
        n3.addEdge(n2, 1);
        n3.addEdge(n4, 3);
        System.out.println(numberOfSortest(n1, n4));
    }
}
