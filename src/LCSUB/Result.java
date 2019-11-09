package LCSUB;

public class Result {
    int val;
    String obj;
    public Result(int val, String obj){
        this.val = val;
        this.obj = obj;
    }

    public Result clone(){
        return new Result(this.val, this.obj);
    }
}
