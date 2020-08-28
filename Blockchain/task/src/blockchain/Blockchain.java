package blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Blockchain implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Block> chain;
    private final int zeroNumbers;

    public Blockchain(int zeroNumbers) {
        this.zeroNumbers = zeroNumbers;
        this.chain = new ArrayList<>();
    }

    public static Blockchain generate(Blockchain instance, int proof, int blockNum) {
        Blockchain bchain = instance;
        if (bchain == null) {
            bchain = new Blockchain(proof);
        } else {
            if (!bchain.validate()) {
                throw new IllegalArgumentException("Blockchain is not valid");
            }
        }

        for (int i = 0; i < blockNum; i++) {
            bchain.generateBlock(proof);
        }
        return bchain;
    }

    private Block generateBlock(int proof) {
        Block newBlock;
        if (chain.size() == 0) {
            newBlock = Block.getInstance(null, proof);
        } else {
            newBlock = Block.getInstance(chain.get(chain.size() - 1), proof);
        }
        chain.add(newBlock);
        return newBlock;
    }

    public Block getBlock(int id) {
        if (id < chain.size()) {
            return chain.get(id);
        }
        throw new IllegalArgumentException("There is no such block");
    }

    public int getSize() {
        return chain.size();
    }

    public boolean validate() {
        for (int i = 1; i < chain.size(); i++) {
            if (Objects.equals(chain.get(i).getPrevHash(), chain.get(i).getHash())) {
                return false;
            }
        }
        return true;
    }
}
