package blockchain;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


//    public static void main(String[] args) {
//        AtomicInteger integer = new AtomicInteger(1);
//        Block[] blocks = new Block[5];
//
//        for (int i = 0; i < blocks.length; i++) {
//            if (i == 0) {
//                blocks[i] = new Block(integer.getAndIncrement(), String.valueOf(integer.get()), "0");
//            } else {
//                blocks[i] = new Block(integer.getAndIncrement(), String.valueOf(integer.get()), blocks[i - 1].getHash());
//            }
//        }
//
//        System.out.println(Arrays.toString(blocks));
//    }
public static void main(String[] args) {
    int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    for (int code : message) {
        outputStream.write(code);
    }

    System.out.println(outputStream.toString());
}
}
