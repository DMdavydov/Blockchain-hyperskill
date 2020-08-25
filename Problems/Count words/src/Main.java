import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String[] arr = null;
        String s = reader.readLine().trim();
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            arr = s.split("\\s+");
        }

        if (arr != null) {
            System.out.println(arr.length);
        }
        reader.close();
    }
}