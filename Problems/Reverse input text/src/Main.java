import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        char[] ch = new char[50];
        int count = reader.read(ch);
        for(int i = count; i >= 0; i--) {
            if(ch[i] != 0) {
                System.out.print(ch[i]);
            }
        }
        reader.close();
    }
}