import java.util.HashMap;
import java.util.Map;

/**
 Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
Вывести данные по сотрудникам с фамилией Иванов.
 */
public class task01 {

    public static void main(String[] args) {
        Map<Integer,String> dict_ids = new HashMap<>();
        dict_ids.put(123456, "Иванов");
        dict_ids.put(321456, "Васильев");
        dict_ids.put(234561, "Петрова");
        dict_ids.put(234432, "Иванов");
        dict_ids.put(654321, "Петрова");
        dict_ids.put(345678, "Иванов");
        
        // System.out.println(dict_ids.containsValue("Иванов"));
        // dict_ids.
        for (Map.Entry<Integer,String> item : dict_ids.entrySet()) {
            if ( item.getValue().equals("Иванов") ){
                System.out.printf("%d: %s\n", item.getKey(),item.getValue());
            }
        }           
    }
}