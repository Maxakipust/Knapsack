package Tower;


import java.util.Comparator;

/**
 * sorts the blocks by base area in decreasing order
 */
public class BlockComparitor implements Comparator<Block> {
    @Override
    public int compare(Block block1, Block block2) {
        int area1 = block1.depth * block1.width;
        int area2 = block2.depth * block2.width;
        return area2 - area1;
    }
}
