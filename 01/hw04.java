import java.util.Scanner;

/**
 * *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69
 * (пользователь).
 * Требуется восстановить выражение до верного равенства.
 * Предложить хотя бы одно решение или сообщить, что его нет.
 * Ввод: 2? + ?5 = 69
 * Вывод: 24 + 45 = 69
 * reg ([0-9?]*)[\s+]*([0-9?]*)[\s=]*([0-9]*)
 */
public class hw04 {
    public static void main(String[] args) {
        String users_func = input("Задайте уровнение :");
        String[] arrStr = users_func.split("\s");
        // Разбиваем уровнение на части по пробелу
        String q = arrStr[0];
        Character sign = arrStr[1].toCharArray()[0];
        String w = arrStr[2];
        int e = Integer.parseInt(arrStr[4]);

        int try_q = 0;
        int try_w = 0;
        boolean answer = false;

        for (int i = 0; i < 10; i++) {
            try_q = replace(q, i);
            for (int j = 0; j < 10; j++) {
                try_w = replace(w, j);
                if (sign == '+') answer = sum(try_q, try_w, e);
                if (sign == '-') answer = minus(try_q, try_w, e);
                if (sign == '*') answer = prod(try_q, try_w, e);
                if (sign == '/') answer = div(try_q, try_w, e);
                if (answer) break;
            }
            if (answer) break;
        }

        if (answer) {
            System.out.printf("%d %c %d = %d", try_q, sign, try_w, e);
        } else {
            System.out.println("Решений не имеет!");
        }

    }

    public static int replace(String msg, int a) {
        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '?') {
                temp += a;
            } else {
                temp += msg.charAt(i);
            }
        }
        return Integer.parseInt(temp);
    }

    public static String input(String text) {
        Scanner iScan = new Scanner(System.in);
        System.out.println(text);
        String result = iScan.nextLine();
        iScan.close();
        return result;
    }

    public static boolean sum(int a, int b, int answer) {
        return a + b == answer ? true : false;
    }

    public static boolean minus(int a, int b, int answer) {
        return a - b == answer ? true : false;
    }

    public static boolean prod(int a, int b, int answer) {
        return a * b == answer ? true : false;
    }

    public static boolean div(int a, int b, int answer) {
        return a / b == answer ? true : false;
    }
}