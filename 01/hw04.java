import java.util.Scanner;

/**
 * *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69
 * (пользователь).
 * Требуется восстановить выражение до верного равенства.
 * Предложить хотя бы одно решение или сообщить, что его нет.
 * Ввод: 2? + ?5 = 69
 * Вывод: 24 + 45 = 69
 */
public class hw04 {
    public static void main(String[] args) {
        String users_func = input("Задайте уровнение :");
        // users_func = "2? + ?5 = 69";
        String[] arrStr = users_func.split("\s");
        // System.out.println(arrStr[0] + ' ' + arrStr[2] + " = " + arrStr[4]);

        int q = whatIsit(arrStr[0]);
        int w = whatIsit(arrStr[2]);
        int e = whatIsit(arrStr[4]);

        int anq = 0;
        int anw = 0;
        int answer_q = 0;
        int answer_w = 0;
        int whereQ = 0;
        
        Integer temp = e - (q + w);
        // System.out.println("temp = "+temp);
        if (temp<10){
            anq = temp / 2;
            anw = anq;
        } else{
            // На какой позиции вопрос в первом числе
            whereQ = whereIs(arrStr[0]);
            // На что надо заменить этот вопрос берем из временной переменной
            Character r = temp.toString().charAt(whereQ);
            anq = Character.getNumericValue(r);

            // На какой позиции вопрос во втором числе
            whereQ = whereIs(arrStr[0]);
            // На что надо заменить этот вопрос берем из временной переменной
            r = temp.toString().charAt(whereQ);
            anw = Character.getNumericValue(r);
        }

        answer_q = replace(arrStr[0], anq);
        answer_w = replace(arrStr[2], anw);

        if ((answer_q + answer_w) != e) {
            System.out.println("Решений не имеет!");
        } else {
            System.out.println(answer_q + " + " + answer_w + " = " + e);
        }

        

    }

    public static int replace(String msg, int a){
        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '?') {
                temp += a;
            } else {
                temp +=msg.charAt(i);
            }
        }
        return Integer.parseInt(temp);
    }

    public static int whereIs(String msg){
        int res = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '?') {
                res = i;
            }
        }
        return res;
    }

    public static int whatIsit(String msg) {
        int res = 0;
        int a = 0;
        double prod = Math.pow(10, msg.length());
        for (int i = 0; i < msg.length(); i++) {

            if (msg.charAt(i) != '?') {
                a = Character.getNumericValue(msg.charAt(i));
                res += a * (prod / 10);
            }
            prod = prod / 10;
        }
        return res;
    }

    public static String input(String text) {
        Scanner iScan = new Scanner(System.in);
        System.out.println(text);
        String result = iScan.nextLine();
        iScan.close();
        return result;
    }
}