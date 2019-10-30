public class OriginalKnapsack {
    Integer[] weights;
    Integer[] values;

    Integer[][] c;

    Integer count = 0;

    public OriginalKnapsack(Integer[] weights, Integer[] values, Integer maxI, Integer maxJ){
        this.values = values;
        this.weights = weights;

        c = new Integer[maxI+1][maxJ+1];
        for(int i = 0; i<maxI+1;i++){
            c[i][0] = 0;
        }
        for(int j = 0; j<maxJ+1;j++){
            c[0][j] = 0;
        }
    }

    public Integer calc(Integer i, Integer j){
        for(int currentI = 0; currentI<=i; currentI++){
            for(int currentJ = 0; currentJ<=j; currentJ++){
                c(currentI, currentJ);
            }
        }
        return c[i][j];
    }

    public Integer c(Integer i, Integer j){
        if(i==0 || j==0){
            c[i][j] = 0;
        } else if(weights[i-1] > j){
            c[i][j] = c[i-1][ j];
        } else {
            Integer pt1 = values[i - 1] + c[i - 1][j - weights[i - 1]];
            Integer pt2 = c[i - 1][j];
            c[i][j] = Math.max(pt1, pt2);
        }
        count++;
        return c[i][j];
    }

    public void reset(){
        count = 0;
        Integer maxI = c.length -1;
        Integer maxJ = c[0].length -1;

        c = new Integer[maxI+1][maxJ+1];
        for(int i = 0; i<maxI+1;i++){
            c[i][0] = 0;
        }
        for(int j = 0; j<maxJ+1;j++){
            c[0][j] = 0;
        }
    }

    public Integer getCount(){
        return count;
    }
}
