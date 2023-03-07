import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Дана строка (получение через обычный текстовый файл!!!)
 * "фамилия":"Иванов","оценка":"5","предмет":"Математика"
 * "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
 * 
 * Написать метод(ы), который распарсит строку и, используя StringBuilder,
 * создаст строки вида:
 * Студент [фамилия] получил [оценка] по предмету [предмет].
 * 
 * Пример вывода в консоль:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */

public class hw02 {
    public static String file_name = "./info.txt";

    public static void main(String[] args) {
        init();// создадим файл с данными если его нет
        print(fileDictReader()); // Получаем и выводим данные в том формате который нам необходим

    }
    // Создаем файл и наполняем содержимым если его нет.
    public static boolean creatFile(String filename, String text) {
        try {
            File f = new File(filename);
            if (f.createNewFile()) {
                FileWriter fw = new FileWriter(f, true);
                fw.write(text);
                fw.close();
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // Данные для файла и вызов метода для его создания
    public static void init() {
        StringBuilder text_for_file = new StringBuilder();
        text_for_file.append("\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"\n");
        text_for_file.append("\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"\n");
        text_for_file.append("\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"\n");
        creatFile(file_name, text_for_file.toString());
    }
    // Метод чтения и преобразования строк из файла. Построчно.
    public static String fileDictReader() {
        StringBuilder res = new StringBuilder();
        String line;
        try {
            FileReader fr = new FileReader(file_name);
            Scanner fscan = new Scanner(fr);
            while (fscan.hasNextLine()) {
                // Читаем строку и переформатируем его под необходимый формат
                line = fscan.nextLine();
                res.append(newFormat(line));
            }
            fscan.close();
            fr.close();
        } catch (Exception e) {
            print("Errors "+ e.getMessage());
        }
        return res.toString();
    }
    // Метод для преобразования текста в файле в необходимый по задаче формат
    public static String newFormat(String msg) {
        String[] tmp = new String[2];
        String surname, point, science;
        tmp = msg.replaceAll("\"", "").split(",");
        surname = tmp[0].split(":")[1];
        point = tmp[1].split(":")[1];
        science = tmp[2].split(":")[1];
        return String.format("Студент %s получил %s по предмету %s.\n", surname, point, science);
    }
    // надоело много писать для вывода в консоль
    public static void print(String msg) {
        System.out.println(msg);
    }

}
