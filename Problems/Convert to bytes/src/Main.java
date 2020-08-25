import java.io.CharArrayReader;
import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int a;
        while (inputStream.available() != 0) {
            a = inputStream.read();
            System.out.print(a);
        }
        inputStream.close();
    }
}