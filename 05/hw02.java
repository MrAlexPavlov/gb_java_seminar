import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Пусть дан список сотрудников:
 * Написать программу, которая найдет и выведет повторяющиеся
 * имена с количеством повторений.
 * Отсортировать по убыванию популярности Имени.
 */
public class hw02 {
    private static ArrayList<String> staff_array = new ArrayList<>();
    private static String file_staff = new File("05/staff.txt").getAbsolutePath();

    public static void main(String[] args) {
        // Читаем файл
        init();
        // Формируем словарь ключ - имя, значение - количество упоминаний
        Map<String, Integer> namesake_dict = nameSake();
        // Сортируем словарь по значению
        namesake_dict = sortDictByValue(namesake_dict);
        // Выводим на экран отсортированный по значению словарь
        showDict( namesake_dict );
    }
    // Метод вывода ключей и значений словаря в консоль
    public static void showDict(Map<String, Integer> dict) {
        for (Map.Entry<String,Integer> item : dict.entrySet()) {
            System.out.printf("%s: %d\n", item.getKey(), item.getValue());
        }
    }
    //  Метод сортировки словаря по значению
    public static Map<String, Integer>  sortDictByValue(Map<String, Integer> namesake_dict) {
       return namesake_dict.entrySet()
                        .stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new));
    }

    // Метод сортировки словаря по значению. 
    public static void dictSort() {
        
    }

    // Метод подсчета популярности имени. Возвращает словарь `Имя:количество упоминаний`
    public static Map<String, Integer> nameSake() {
        Map<String, Integer> res_dict = new LinkedHashMap<>();
        String name;
        Object cnt;

        for (String full_name : staff_array) {
            name = full_name.split("\s")[0];
            cnt = res_dict.putIfAbsent(name, 1);

            if (cnt instanceof Integer)
                res_dict.put(name, Integer.parseInt(cnt.toString())+1 );

        }
        return res_dict;
    }

    // Метод чтения текстового файла. Возвращает список
    private static ArrayList<String> loadFromFile(String filename) {
        ArrayList<String> res_arr = new ArrayList<>();
        String line;
        try {
            FileReader fr = new FileReader(filename);
            Scanner fscan = new Scanner(fr);
            while (fscan.hasNextLine()){
                line = fscan.nextLine()
                            .trim()
                            .replaceAll("\n", "");
                res_arr.add(line);
            }
            fscan.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Errors: " + e.getMessage());
        }
        return res_arr;
    }
    
    private static void init() {
        staff_array = loadFromFile(file_staff);
    }

        
}
