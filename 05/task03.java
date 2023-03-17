import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Написать программу, определяющую правильность расстановки скобок в выражении.
 * 
 * Пример 1: a+(d*3) - истина
 * 
 * Пример 2: [a+(1*3) - ложь
 * 
 * Пример 3: [6+(3*3)] - истина
 * 
 */
public class task03 {
    private static Scanner iscan = new Scanner(System.in);
    private static Map<Character, Character> dict = new HashMap<>();

    public static void main(String[] args) {
        init();
        String equ = "{{}[6+(3*3)]{}}";
        System.out.println(equ + " -> " + itterEqu(equ));
    }

    private static void init() {
        dict.put('(', ')');
        dict.put('[', ']');
        dict.put('{', '}');
    }

    public static Boolean itterEqu(String msg) {
        Deque<Character> equ = new LinkedList<>();
        char c;
        // Перебираем по элементно выражение
        for (int i = 0; i < msg.length(); i++) {
            c = msg.charAt(i);
            // Когда находим открывающуюся скобку то вносим ее в `очередь`
            if (dict.containsKey(c))
                equ.addLast(c);

            // Когда находим закрывающуюся скобку то пытаемся удалить последнюю открывающуюся 
            // если они парные. Парность определяем формат ключ:значение, где ключ это открывающаяся скобка
            // значение это закрывающаяся скобка
            if (dict.containsValue(c)) {
                if (equ.size() == 0)
                    return false;
                if (dict.get(equ.getLast()) == c)
                    equ.pollLast();
            }
        }

        if (equ.size() > 0)
            return false;
        return true;
    }

    public static String userText(String text) {
        System.out.println(text);
        return iscan.nextLine();
    }
}
