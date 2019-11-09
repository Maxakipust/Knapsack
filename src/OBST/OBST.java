package OBST;
// A naive recursive implementation of optimal binary
// search tree problem
public class OBST
{
    // A recursive function to calculate cost of
    // optimal binary search tree
    static Double optCost(Double freq[], int i, int j)
    {
        // Base cases
        if (j < i)      // no elements in this subarray
            return 0.0;
        if (j == i)     // one element in this subarray
            return freq[i];

        // Get sum of freq[i], freq[i+1], ... freq[j]
        Double fsum = sum(freq, i, j);

        // Initialize minimum value
        Double min = Double.MAX_VALUE;

        // One by one consider all elements as root and
        // recursively find cost of the BST, compare the
        // cost with min and update min if needed
        for (int r = i; r <= j; ++r)
        {
            Double cost = optCost(freq, i, r-1) +
                    optCost(freq, r+1, j);
            if (cost < min)
                min = cost;
        }

        // Return minimum value
        return min + fsum;
    }

    // The main function that calculates minimum cost of
    // a Binary Search Tree. It mainly uses optCost() to
    // find the optimal cost.
    static Double optimalSearchTree(Double freq[], int n)
    {
        // Here array keys[] is assumed to be sorted in
        // increasing order. If keys[] is not sorted, then
        // add code to sort keys, and rearrange freq[]
        // accordingly.
        return optCost(freq, 0, n-1);
    }

    // A utility function to get sum of array elements
    // freq[i] to freq[j]
    static Double sum(Double freq[], int i, int j)
    {
        Double s = 0.0;
        for (int k = i; k <=j; k++)
            s += freq[k];
        return s;
    }

    // Driver code
    public static void main(String[] args) {
        Double freq[] = {0.1, 0.2, 0.3, 0.4};
        //int n = freq.length;
        //System.out.println("Cost of Optimal BST is " +optimalSearchTree( freq, n));

        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                System.out.print(optCost(freq, i, j));
                System.out.print(", ");
            }
            System.out.println();
        }
    }
    //r S=0.1; Q=0.2; P= 0.3;  R=0.4;
}