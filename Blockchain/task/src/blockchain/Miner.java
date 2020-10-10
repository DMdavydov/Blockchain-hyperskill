package blockchain;

import java.util.List;
import java.util.function.Supplier;
public class Miner {
    private final int id;
    private final Supplier<Block> blockSupplier;
    private Block block;

    public Miner(int id, Block previousBlock, int zeros, List<String> messages) {
        this.id = id;
        this.blockSupplier = () -> new Block(previousBlock, zeros, messages);
    }

    public Miner mine() {
        block = blockSupplier.get();
        return this;
    }

    public Block getBlock() {
        return block;
    }

    public int getId() {
        return id;
    }
}
