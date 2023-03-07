import java.util.Scanner;

/** Н
 * апишите метод, который принимает на вход строку (String) и 
 * определяет является ли строка палиндромом (возвращает boolean значение).
 */
public class task03 {
    public static void main(String[] args) {
        String msg = input("Введите фразу: ");
        if (polyndrom(msg)){
            System.out.printf("Эта фраза %s - полиндром", msg);
        } else {
            System.out.printf("%s - не полиндром", msg);
        }
    }
    
    public static String input(String text){
        String res = new String();
        Scanner iscanner = new Scanner(System.in);
        System.out.println(text);
        res = iscanner.nextLine();
        iscanner.close();
        return res;
    }

    public static boolean polyndrom(String N){
        for (int i = 0; i < N.length()/2; i++) {
            if (N.charAt(i) != N.charAt(N.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    
}
