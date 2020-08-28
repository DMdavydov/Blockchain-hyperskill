package blockchain;

import blockchain.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Block implements Serializable {
    private static final long serialVersionUID = 1L;
    private final long id;
    private final long timeStamp;
    private final String prevHash;
    private final long generatingTime;
    private String hash;
    private int magicNum;

    private Block(Block prev, int proof) {
        this.timeStamp = new Date().getTime();
        if (prev == null) {
            this.id = 1;
            this.prevHash = "0";
        } else {
            this.id = prev.getId() + 1;
            this.prevHash = prev.getHash();
        }
        this.hash = generateHash(proof);
        generatingTime = new Date().getTime() - timeStamp;
    }

    private String generateHash(int proof) {
        String zeros = "0".repeat(proof);
        Random random = new Random(34564);
        int magic;
        String hash;
        do {
            magic = random.nextInt(1000000);
            hash = StringUtils.applySha256(+ timeStamp + String.valueOf(id) + String.valueOf(magic)  + prevHash);
        } while (!hash.startsWith(zeros));
        magicNum = magic;
        this.hash = hash;
        return hash;
    }

    public static Block getInstance(Block prev, int proof) {
        return new Block(prev, proof);
    }

    public String getHash() {
        return this.hash;
    }

    public long getId() {
        return id;
    }

    public String getPrevHash() {
        return prevHash;
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + id +
                "\nTimestamp: " + timeStamp +
                "\nMagic number: " + magicNum +
                "\nHash of the previous block:\n" + prevHash +
                "\nHash of the block:\n" + getHash() +
                "\nBlock was generating for " + generatingTime / 1000.0 + " seconds";
    }
}
