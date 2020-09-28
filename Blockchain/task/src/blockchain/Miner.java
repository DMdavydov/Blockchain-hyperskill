package blockchain;

public class Miner implements Runnable {
    private Blockchain chain;
    private String miner;

    public Miner(Blockchain chain) {
        this.chain = chain;
    }

    private Block generateBlock() {
        int proof = chain.getZeroNumbers();
        Block newBlock;
        Block prevBlock = chain.peek();
        newBlock = Block.getInstance(prevBlock, proof);
        chain.put(newBlock, miner);
        return newBlock;
    }

    @Override
    public void run() {
        String[] s = Thread.currentThread().getName().split("-");
        this.miner = s[s.length - 1];
        generateBlock();
    }
}
