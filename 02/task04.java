import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * записать в текстовый файл слово TEST 10 раз
 */
public class task04 {
    public static void main(String[] args) {
            writeFile("text.txt", createMsg());
    }

    public static String createMsg(){
        StringBuilder phrase = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phrase.append("TEST\n");
        }
        return phrase.toString();
    }

    public static void writeFile(String filename, String text) {
        File f  = new File(filename);
        try {
            f.createNewFile();
            FileWriter w = new FileWriter(f, true);
            w.write(text);
            w.close();
        } catch (Exception e) {
            System.out.println("Errors" + e.getMessage());
        }
        
    }

}