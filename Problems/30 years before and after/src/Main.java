import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String date = scanner.nextLine();
        System.out.println(LocalDate.parse(date).minusYears(30));
        System.out.println(LocalDate.parse(date).plusYears(30));
    }
}