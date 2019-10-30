import java.util.Random;

public class Knapsack {
    Integer[] weights;
    Integer[] values;

    Integer count = 0;
    public Knapsack(Integer[] weights, Integer[] values){
        this.values = values;
        this.weights = weights;
    }

    public Integer c(Integer i, Integer j){
        count += 1;
        if(i==0 || j==0){
            return 0;
        }
        if(weights[i-1] > j){
            return c(i-1, j);
        }
        Integer pt1 = values[i-1]+c(i-1, j-weights[i-1]);
        Integer pt2 = c(i-1,j);
        return Math.max(pt1, pt2);
    }

    public void reset(){
        this.count = 0;
    }

    public Integer getCount(){
        return this.count;
    }

    public static void main(String[] args) {
        Integer[] weights = new Integer[]{2,1,3,2};
        Integer[] values = new Integer[]{12,10,20,15};

        Knapsack k = new Knapsack(weights, values);
        OriginalKnapsack ok = new OriginalKnapsack(weights, values, 4, 5);

        k.reset();
        ok.reset();

        System.out.println("My version:");
        System.out.println("Result: "+k.c(4,5));
        System.out.println("Count: "+k.getCount());
        System.out.println();
        System.out.println("Original:");
        System.out.println("Result: "+ok.calc(4,5));
        System.out.println("Count: "+ok.getCount());
        k.reset();
        ok.reset();

        for(int i = 0; i<=4; i++){
            for(int j = 0; j<=5; j++){
                System.out.print(k.c(i,j)+", ");
            }
            System.out.println();
        }

        //random test
        /*Random r = new Random();
        Integer originalWin = 0;
        Integer myWin = 0;

        Integer meWinBy = 0;

        for(int epoc = 0; epoc<=5000; epoc++) {
            Integer size = Math.abs(r.nextInt(100))+1;
            Integer[] weights = new Integer[size];
            Integer[] values = new Integer[size];
            Integer i = r.nextInt(size);
            Integer j = Math.abs(r.nextInt(100));

            for (int x = 0; x < size; x++) {
                weights[x] = Math.abs(r.nextInt(100));
                values[x] = Math.abs(r.nextInt(100));
            }
            Knapsack k = new Knapsack(weights, values);
            OriginalKnapsack ok = new OriginalKnapsack(weights, values, i, j);

            Integer myResult = k.c(i, j);
            Integer originalResult = ok.calc(i, j);
            Integer myCount = k.count;
            Integer originalCount = ok.count;

            if (myResult.equals(originalResult)) {
                if (originalCount < myCount) {
                    System.out.println("ORIGINAL");
                    originalWin++;
                } else if (myCount < originalCount) {
                    System.out.println("ME");
                    myWin++;
                }
                meWinBy += myCount-originalCount;
            } else {
                System.out.println("ERROR");
                return;
            }
        }

        System.out.println("Original Wins: "+originalWin);
        System.out.println("My Wins: "+myWin);
        System.out.println("I win by "+ meWinBy); */
    }
}
