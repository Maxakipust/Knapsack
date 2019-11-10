package Tower;

import java.util.*;

public class Tower {

    /**
     * gets the highest tower that can be created from blocklist
     * @param blockList the list of blocks we have to work with
     * @return the height of the tallest tower
     */
    static int getTower(List<Block> blockList){
        //create a list of all of the possible rotations for each block
        List<Block> blocks = new ArrayList<Block>();
        for(Block b: blockList){
            blocks.addAll(b.getRotations());
        }
        //sort the blocks by base area
        blocks.sort(new BlockComparitor());

        //get each longest stackable sequence within blocks, increasing i
        //then finds the highest one from them
        Result max = new Result();
        for(int i = 0; i<blocks.size(); i++){
            //recursion!!!
            Result r = l(i, blocks);
            if(r.value > max.value){
                max = r;
            }
        }
        //list out the blocks
        System.out.println();
        for(Block b: max.tower){
            System.out.println(b);
        }
        //return the max height
        return max.value;
    }

    /**
     * recursive function for modified Longest Increasing Sequence.
     * It finds the highest stackable sequence within blocks.
     * @param i the last block in the sequence
     * @param blocks list of all the blocks we have to work with
     * @return a result with the current largest stackable sequence
     */
    static Result l(int i, List<Block> blocks){
        //base case, we will just have the base block
        if(i==0){
            Result r = new Result();
            r.addBlock(blocks.get(i));
            return r;
        }
        //finds the max(l(j)) where 0<j<i and block(i) can fit on block(j)
        Result max = new Result();
        for(int j = 0; j<i; j++){
            if(blocks.get(i).canFitOn(blocks.get(j))){
                Result r = l(j, blocks).clone();
                if(r.value > max.value){
                    max = r;
                }
            }
        }
        //adds the current block to the stack
        max.addBlock(blocks.get(i));
        return max;
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
        blocks.add(new Block(3,2,1));
        blocks.add(new Block(3,4,5));
        blocks.add(new Block(3,2,100));
        blocks.add(new Block(100,100,1));
        blocks.add(new Block(100,1,100));
        blocks.add(new Block(100,100,1));
        blocks.add(new Block(1,100,100));
        blocks.add(new Block(99,99,99));
        System.out.println(getTower(blocks));
    }
}


