package NumberOfShortestPaths;

public class NumberOfShort {

    int numberOfSortest( Node start, Node end){
        
    }

    public static void main(String[] args) {
        int graph [][] = new int[][] {
                {0,3,2},//0
                {3,0,5},//1
                {2,5,0} //2
               //0 1 2
        };
        System.out.println(numberOfSortest(graph, 1, 2)); //this should be 2
    }
}
