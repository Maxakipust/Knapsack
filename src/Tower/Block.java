package Tower;

import java.util.ArrayList;
import java.util.List;

public class Block {
    int width; //base
    int height;
    int depth; //base
    public Block(int width, int depth, int height){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    /**
     * gets a list of possible rotations including not rotating it at all
     * @return
     */
    public List<Block> getRotations(){
        List<Block> ret = new ArrayList<>();
        ret.add(new Block(this.width, this.depth, this.height));
        ret.add(new Block(this.width, this.height, this.depth));
        ret.add(new Block(this.height, this.width, this.depth));
        ret.add(new Block(this.height, this.depth, this.width));
        ret.add(new Block(this.depth, this.height, this.width));
        ret.add(new Block(this.depth, this.width, this.height));
        return ret;
    }
    /**
     * checks to see if this block can fit on block b
     * @param b the block to use as a base
     * @return if it can fit
     */
    public Boolean canFitOn(Block b){
        return (this.width < b.width) && (this.depth < b.depth);
    }

    public String toString(){
        return ("("+this.width+", "+this.depth+"), "+ this.height);
    }
}