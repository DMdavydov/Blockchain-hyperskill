package blockchain;

import blockchain.util.SerializationUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Blockchain implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Blockchain blockchain;

    private int zeroNumbers;

    private final ArrayList<Block> chain;

    private Blockchain() {
        this.zeroNumbers = 0;
        this.chain = new ArrayList<>();
    }

    public static Blockchain getBlockchain(String filename) {
        if (blockchain != null) {
            return blockchain;
        }

        File file = new File(filename);
        //System.out.println(file.getAbsolutePath());
        if (file.exists() && file.length() != 0) {
            try {
                blockchain = (Blockchain) SerializationUtils.deserialize(file.getName());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            blockchain = new Blockchain();
        }
        return blockchain;
    }

    public Block getBlock(int id) {
        if (id < chain.size()) {
            return chain.get(id);
        }
        throw new IllegalArgumentException("There is no such block");
    }

    public synchronized Block peek() {
        if (chain == null || chain.isEmpty()){
            return null;
        }
        return chain.get(chain.size() - 1);
    }

    public synchronized int getZeroNumbers() {
        return zeroNumbers;
    }

    public synchronized boolean put(Block newBlock, String miner) {
        String prevHash = chain.isEmpty() ? "0" : chain.get(chain.size() - 1).getHash();
        if (prevHash == newBlock.getPrevHash()) {
            chain.add(newBlock);
            System.out.println("Block:");
            System.out.println("Created by miner # " + miner);
            System.out.println(newBlock);
            if (newBlock.getGeneratingTime() / 1000 < 60) {
                System.out.println(zeroNumbers++ + " was increased to 1\n");
            } else {
                System.out.println(zeroNumbers-- + " was decreased to 1\n");
            }
            return true;
        }
        return false;
    }

    public int getSize() {
        return chain.size();
    }

    public boolean validate() {
        for (int i = 1; i < chain.size(); i++) {
            if (Objects.equals(chain.get(i).getPrevHash(), chain.get(i - 1).getHash())) {
                return false;
            }
        }
        return true;
    }
}