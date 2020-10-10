package blockchain;

import blockchain.util.SerializationUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int blocksNumber = 5;
        int zeros = 0;
        int miners = 10;
        ParallelExecutor<Miner> parallelExecutor = new ParallelExecutor<>(12, miners);

        List<List<String>> messagesList = List.of(
                List.of(),
                List.of("Tom: Hey, I'm first!"),
                List.of("Sarah: It's not fair!",
                        "Sarah: You always will be first because it is your blockchain!",
                        "Sarah: Anyway, thank you for this amazing chat."),
                List.of("Tom: You're welcome :)",
                        "Nick: Hey Tom, nice chat"),
                List.of());

        Block cursor = null;
        for (int i = 0; i < blocksNumber; i++) {
            Block finalCursor = cursor;
            int finalZeros = zeros;
            List<String> messages = messagesList.get(i);
            Miner miner = parallelExecutor.execute(id -> new Miner(id, finalCursor, finalZeros, messages)::mine);

            cursor = miner.getBlock();

            printBlock(cursor, miner);

            int miningDuration = cursor.getMiningDuration();
            if (miningDuration < 10) {
                zeros++;
                System.out.println("N was increased to " + zeros);
            } else if (miningDuration > 30) {
                zeros--;
                System.out.println("N was decreased by 1");
            } else {
                System.out.println("N stays the same");
            }

            System.out.println();
        }
    }

    private static void printBlock(Block block, Miner miner) {
        String message = block.getMessage();
        message = message == null ? "no messages" : System.lineSeparator() + message;
        System.out.printf("Block:%n" +
                        "Created by miner # %d%n" +
                        "Id: %d%n" +
                        "Timestamp: %d%n" +
                        "Magic number: %d%n" +
                        "Hash of the previous block: %n" +
                        "%s%n" +
                        "Hash of the block: %n" +
                        "%s%n" +
                        "Block data: %s%n" +
                        "Block was generating for %d seconds%n",
                miner.getId(), block.getUid(), block.getTimestamp(), block.getMagicNumber(),
                block.getPreviousHash(), block.getHash(),message, block.getMiningDuration());
    }
}
