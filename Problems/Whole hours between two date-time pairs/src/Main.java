import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime firstDate= LocalDateTime.parse(scanner.nextLine());
        LocalDateTime secondDate= LocalDateTime.parse(scanner.nextLine());
        long hours = ChronoUnit.HOURS.between(firstDate, secondDate);
        System.out.println(hours);
    }
}