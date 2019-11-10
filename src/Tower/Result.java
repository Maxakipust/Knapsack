package Tower;

import java.util.Stack;

public class Result {
    //the height of the tower
    int value;
    //the tower itsself
    Stack<Block> tower;

    //create a new result from a value and tower
    public Result(int value, Stack<Block> tower){
        this.value = value;
        this.tower = tower;
    }
    //create an empty result
    public Result(){
        this.value = 0;
        this.tower = new Stack<>();
    }
    //add a block to the stack and add the height to the value
    public void addBlock(Block block){
        this.value += block.height;
        this.tower.push(block);
    }

    //clones the result
    public Result clone(){
        return new Result(this.value, (Stack<Block>)this.tower.clone());
    }
}
