import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> list = IntStream.range(0, numbers.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(numbers::get)
                .collect(Collectors.toList());
        Collections.reverse(list);
        list.forEach(x -> System.out.print(x + " "));
    }
}