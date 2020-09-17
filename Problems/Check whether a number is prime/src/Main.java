import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newCachedThreadPool(); // assign an object to it

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            // create and submit tasks
            executor.submit(new PrintIfPrimeTask(number));
        }
        executor.shutdown();
    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // write code of task here
        BigInteger bigInteger = BigInteger.valueOf(number);
        boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(number));
        if (number > 1 && probablePrime) {
            System.out.println(number);
        }
    }
}