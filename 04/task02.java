import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Scanner;

/**
 Реализовать консольное приложение, которое:
1. Принимает от пользователя строку вида

text

1. Нужно сохранить text в связный список
2. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

asd
[asd]
dfhj
[asd, dfhj]
xzcv
[asd, dfhj, xzcv]
print~1
Вывод dfhj
[asd, xzcv]

 */
public class task02 {
    public static void main(String[] args) {
        ArrayList<String> arr_list = new ArrayList<String>();
        String users_text = stringFromUser(":");
        int id;
        while (!users_text.equals("stop")) {
            if (users_text.contains("print~")) {
                try {
                    id = Integer.parseInt(users_text.split("~",2)[1]) ;    
                } catch (Exception e) {
                    id = arr_list.size()-1;
                }
                arr_list.remove(id);
            } else {
                arr_list.add(users_text);
            }
            System.out.println(arr_list.toString());
            users_text = stringFromUser(":");
        }
    }

    public static String stringFromUser(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.println(text);
        return scan.nextLine();
    }
    
}
