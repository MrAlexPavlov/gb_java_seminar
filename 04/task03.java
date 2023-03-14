import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 Реализовать консольное приложение, которое:

1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная 
была первой в списке, а первая - последней.
 */
public class task03 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Deque<String> some_arr = new LinkedList<String>();
        String users_text = stringFromUser(":");

        while (!users_text.equals("stop")) {
            if (users_text.equals("print")) {
                while(some_arr.size()>0) {
                    System.out.print(some_arr.pollLast() + " ");
                    }
                    System.out.println();
            } else {
                some_arr.add(users_text);
            }
            users_text = stringFromUser(":");
        }
     }

    public static String stringFromUser(String text) {
        System.out.print(text+" ");
        return scan.nextLine();
    }
    
    
}
