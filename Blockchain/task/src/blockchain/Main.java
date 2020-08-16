package blockchain;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(1);
        Block[] blocks = new Block[5];

        for (int i = 0; i < blocks.length; i++) {
            if (i == 0) {
                blocks[i] = new Block(integer.getAndIncrement(), String.valueOf(integer.get()), "0");
            } else {
                blocks[i] = new Block(integer.getAndIncrement(), String.valueOf(integer.get()), blocks[i - 1].getHash());
            }
        }

        System.out.println(Arrays.toString(blocks));
    }
}
