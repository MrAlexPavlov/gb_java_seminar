import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
 * что 1 человек может иметь несколько телефонов.
 * Добавить функции 
 * 1) Добавление номера
 * 2) Вывод всего
 */
public class hw01 {
    private static Scanner iscan = new Scanner(System.in);
    public static Map<String, ArrayList<String>> phonebook = new HashMap<>();
    public static void main(String[] args) {
        String cmd, f_name, phone_number ;
        String help = "? - помощь\n"
                    + "1 - добавить контакт\n"
                    + "2 - вывести на экран справочник\n"
                    + "quit - выход";
        System.out.println(help);

        while (true) {
            cmd = user_Text("Введите команду:");
            if (cmd.equals("?")){
                System.out.println(help);
            }

            if (cmd.equals("1")){
                f_name = user_Text("Введите имя:");
                phone_number = user_Text("Номер телефона:");
                addContact(f_name, phone_number);    
            }

            if (cmd.equals("2"))
                show();

            if ( cmd.equals("quit") )
                break;
        }
        
    }

    public static void addContact(String name, String phone) {
        // В списках будем хранить телефонные номера
        // это необходимо для хранения формата один ко многим
        ArrayList<String> numbers = new ArrayList<>();
        // Проверка на то что новый это контакт или нет
        // Без проверки на регистр
        if (!phonebook.containsKey(name)){
            numbers.add(phone);
            phonebook.put(name, numbers);
        } else {
            numbers = phonebook.get(name);
            if (!numbers.contains(phone)){
                numbers.add(phone);
            }
        }
    }

    public static void show() {
        String answer = "";
        for (Map.Entry<String, ArrayList<String>> items : phonebook.entrySet()) {
            answer += items.getKey()+ ": ";
            for (String phone : items.getValue()) {
                answer += phone + " ";
            }
            answer += "\n";
        }
        System.out.println(answer);
    }

    private static String user_Text(String msg){
        System.out.println(msg);
        return iscan.nextLine().trim();
    }
    
}
