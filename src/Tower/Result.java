package Tower;

import java.util.Stack;

public class Result {
    int value;
    Stack<Block> tower;

    public Result(int value, Stack<Block> tower){
        this.value = value;
        this.tower = tower;
    }

    public Result(){
        this.value = 0;
        this.tower = new Stack<>();
    }

    public Result clone(){
        return new Result(this.value, (Stack<Block>)this.tower.clone());
    }
}
