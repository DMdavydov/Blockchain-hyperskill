import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.now().withYear(year).withMonth(month).withDayOfMonth(1);

        LocalDate firstMonday;
        while(!date.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            date = date.plusDays(1);
        }
        LocalDate last_day_of_month = date.with(lastDayOfMonth());
        firstMonday=date;

        while(firstMonday.isBefore(last_day_of_month)){
            System.out.println(firstMonday);
            firstMonday = firstMonday.plusDays(7);
        }
    }
}