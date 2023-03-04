import java.util.Scanner;

/**
 * *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
 * Требуется восстановить выражение до верного равенства.
 * Предложить хотя бы одно решение или сообщить, что его нет.
 * Ввод: 2? + ?5 = 69
 * Вывод: 24 + 45 = 69
 */
public class hw04 {
    public static void main(String[] args) {
        
    }

        public static String input(String text) {
        Scanner iScan = new Scanner(System.in);
        System.out.println(text);
        String result = iScan.nextLine();
        iScan.close();
        return result;
    }
}