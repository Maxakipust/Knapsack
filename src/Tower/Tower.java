package Tower;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tower {

    /**
     * does some preprocessing for the recursive function
     * and calls the top level of it
     * @param blockList the list of blocks that we have to work with
     * @return the size of the largest stack that we can build with
     * the list of blocks
     */
    static int getTower(List<Block> blockList){
        //create a list of all of the possible rotations for each block
        List<Block> blocks = new ArrayList<Block>();
        for(Block b: blockList){
            blocks.addAll(b.getRotations());
        }
        //sort the blocks by height
        blocks.sort(new BlockComparitor());

        //start the DP recursive funtion
        Result result =  c(blocks.size()-1, blocks.size()-1, blocks);

        //print the result
        for(Block b: result.tower){
            System.out.println(b);
        }
        return result.value;
    }

    /**
     * the recursive dynamic programming solution
     * @param i the block that we are trying to add to the stack
     * @param j the number of blocks that we can add
     * @param blocks the list of total blocks (i should prbably just make this a class var)
     * @return a result object with the height of the stack and the stack itself.
     */
    static Result c(int i, int j, List<Block> blocks){
        //base case: if we dont have any blocks to work with we cant have a tower
        if(i == 0 || j == 0){
            return new Result();
        }

        //the previus result; the result of not including the block we are looking at
        Result cim1 = c(i-1,j, blocks).clone();

        //if(there is a previous result and we cant fit the block on the tower, then
        //we dont add the block to the tower
        if(cim1.tower.size()!=0 && !blocks.get(i).canFitOn(cim1.tower.peek())){
            return cim1;
        }else{
            //if we can fit the block on the tower then we check to see if adding the block would be higher
            Result prev = cim1;

            Result withBlock = c(i-1, j-1, blocks).clone();
            withBlock.value += blocks.get(i).height;
            withBlock.tower.push(blocks.get(i));

            if(prev.value > withBlock.value){
                return prev;
            }else{
                return withBlock;
            }
        }

    }

    /**
     * main entry point for the program. It should solve this:
     * A child wants to construct the tallest tower possible out
     * of building blocks. She has n types of blocks, and an
     * unlimited supply of blocks of each type. Each type-i block
     * is a rectangular solid with linear dimensions . A Block can
     * be oriented so that any two of its three dimensions determine
     * the dimensions of base and the other dimension is the height.
     * In building a tower one block may be placed on top of another
     * block as long as the two dimensions of the base of the upper
     * block are each strictly smaller than the corresponding base
     * dimensions of the lower block. (Blocks oriented to have
     * equal-sized bases cannot be stacked). Design an efficient
     * algorithm to determine the tallest tower the child can build.
     * @param args
     */
    public static void main(String[] args) {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(1,2,3));
        blocks.add(new Block(3,4,5));
        blocks.add(new Block(99,99,100));
        System.out.println(getTower(blocks));
    }
}
