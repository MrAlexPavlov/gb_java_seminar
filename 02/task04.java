import java.io.File;
import java.io.FileReader;

/**
 * записать в текстовый файл слово TEST 10 раз
 */
public class task04 {
    public static void main(String[] args) {
            
    }

    public static void name(String filename) {
        for (int i = 0; i < 10; i++) {
            
        }
        
        File f  = new File(filename);
        try {
            f.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

}