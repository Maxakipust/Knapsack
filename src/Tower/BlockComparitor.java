package Tower;

import java.util.Comparator;

/**
 * sorts the blocks by height in decreasing order
 */
public class BlockComparitor implements Comparator<Block> {
    @Override
    public int compare(Block block1, Block block2) {
        return block2.height - block1.height;
    }
}
