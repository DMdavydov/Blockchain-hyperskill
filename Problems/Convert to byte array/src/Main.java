import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        for (String word : words) {
            char[] bytes = word.toCharArray();
            for (char a : bytes) {
                charArrayWriter.append(a);
            }
        }
        return charArrayWriter.toCharArray();
    }

    public static void main(String[] args) {
        File sampleFile = new File("sample.txt");
        byte[] content = new byte[] {'J', 'a', 'v', 'a'};

        try {
            OutputStream outputStream = new FileOutputStream(sampleFile, true);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}