import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        // implement this method

        while (true) {
            int a = Integer.parseInt(scanner.nextLine());
            if (a == 0) {
                return;
            }
            if (a % 2 == 0) {
                System.out.println(a);
            }
        }
    }
}