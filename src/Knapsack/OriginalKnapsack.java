package Knapsack;

public class OriginalKnapsack {
    Integer[] weights;
    Integer[] values;

    Result[][] c;

    Integer count = 0;

    public OriginalKnapsack(Integer[] weights, Integer[] values, Integer maxI, Integer maxJ){
        this.values = values;
        this.weights = weights;

        c = new Result[maxI+1][maxJ+1];
        for(int i = 0; i<maxI+1;i++){
            c[i][0] = new Result();
        }
        for(int j = 0; j<maxJ+1;j++){
            c[0][j] = new Result();
        }
    }

    public Result calc(Integer i, Integer j){
        for(int currentI = 0; currentI<=i; currentI++){
            for(int currentJ = 0; currentJ<=j; currentJ++){
                c(currentI, currentJ);
            }
        }
        return c[i][j];
    }

    private Result c(Integer i, Integer j){
        if(i==0 || j==0){
            c[i][j] = new Result();
        } else if(weights[i-1] > j){
            c[i][j] = c[i-1][ j].clone();
        } else {
            Result result1 = c[i-1][j-weights[i-1]].clone();
            result1.value += values[i-1];
            result1.addItem(i);
            Result result2 = c[i-1][j].clone();
            if(result1.value>result2.value){
                c[i][j] = result1;
            }else{
                c[i][j] = result2;
            }
        }
        count++;
        return c[i][j];
    }

    public void reset(){
        count = 0;
        Integer maxI = c.length -1;
        Integer maxJ = c[0].length -1;

        c = new Result[maxI+1][maxJ+1];
        for(int i = 0; i<maxI+1;i++){
            c[i][0] = new Result();
        }
        for(int j = 0; j<maxJ+1;j++){
            c[0][j] = new Result();
        }
    }

    public Integer getCount(){
        return count;
    }
}
