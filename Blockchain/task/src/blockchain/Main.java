package blockchain;

import blockchain.util.SerializationUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) {
        String filename = "tamechain.data";
        File file = new File(filename);
        //System.out.println(file.getAbsolutePath());
        Blockchain blockchain = null;
        int size = 0;
        if (file.exists()) {
            try {
                blockchain = (Blockchain) SerializationUtils.deserialize(file.getName());
                //System.out.println("Deserialized");
                size = blockchain.getSize();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must start with: ");
        int zeroNumbers = scanner.nextInt();

        blockchain = Blockchain.generate(blockchain, zeroNumbers, 5);

        try {
            SerializationUtils.serialize(blockchain, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Blockchain blockchain = new Blockchain(zeroNumbers);
        for (int i = size; i < blockchain.getSize(); i++) {
            Block block = blockchain.getBlock(i);
            System.out.println(block);
            System.out.println();
        }
    }

}
