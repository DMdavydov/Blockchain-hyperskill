package blockchain;

import java.util.Date;

public class Block {

    private int id;
    private long timeStamp;
    private String previousHash;
    private String hash;

    public Block(int id, String hash, String previousHash) {
        this.id = id;
        this.timeStamp = new Date().getTime();
        this.previousHash = previousHash;
        this.hash = StringUtil.applySha256(hash);
    }

    public int getId() {
        return id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return  "\n" + "Block: " + "\n" +
                "Id: " + id + "\n" +
                "Timestamp: " + timeStamp + "\n" +
                "Hash of the previous block: " + "\n" + previousHash + "\n" +
                "Hash of the block: " + "\n" + hash;
    }
}
