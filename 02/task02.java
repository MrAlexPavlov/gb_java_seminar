import java.util.Scanner;

/**
 * Напишите метод void, который сжимает строку.
 * Пример: вход aaaabbbcddaa.
 * результат - a4b3cd2a2
 */
public class task02 {

    public static void main(String[] args) {
        String text = input("Введите фразу");
        String zp = zipString(text);
        System.out.println(zp);

    }

    public static String input(String text) {
        Scanner iScan = new Scanner(System.in);
        System.out.println(text);
        String result = iScan.nextLine();
        iScan.close();
        return result;
    }

    public static String zipString(String N){
        StringBuilder  res = new StringBuilder();
        int cnt = 1;
        res.append(N.charAt(0));
        char tmp = N.charAt(0);
        for (int i = 1; i<N.length(); i++){
            if (N.charAt(i) != tmp){
                if (cnt > 1) {
                    res.append(cnt);
                }
                res.append(N.charAt(i));
                tmp = N.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt>1) {
            res.append(cnt);
        }
        return res.toString();
    }

}