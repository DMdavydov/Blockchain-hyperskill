import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine()).plusHours(11);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
    }
}