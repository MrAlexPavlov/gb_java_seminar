import java.util.LinkedList;
import java.util.Scanner;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */
public class hw02 {
    private static Scanner iscan = new Scanner(System.in);
    private static LinkedList<Object> array_list = new LinkedList<Object>();

    public static void main(String[] args) {
        init();
        String[] atmp = new String[2];
        String cmd = users_comand(": ");
        while (!cmd.equals("break")) {

            if (cmd.charAt(0) == '?')
                init();

            if (cmd.charAt(0) == 'p')
                System.out.println(array_list.toString());

            if (cmd.charAt(0) == '2')
                System.out.println(dequeue());

            if (cmd.charAt(0) == '3')
                System.out.println(first());

            if (cmd.charAt(0) == '1') {
                atmp = cmd.split(" ", 2);
                enqueue(atmp[1]);
            }

            cmd = users_comand(": ");
        }
    }
    // Метод для добовления в сылочный список элемент в конец списка
    public static boolean enqueue(String value) {
        return array_list.add(value);
    }
    // Метод удаления последнего элемента, возвращает удаленный элемент
    public static String dequeue() {
        String res = array_list.getLast().toString();
        array_list.removeLast();
        return res;
    }
    // Метод получения первого элемента из списка
    public static String first() {
        return array_list.getFirst().toString();
    }
    // Парсинг команды пользователя
    public static String users_comand(String text) {
        System.out.print(text);
        return iscan.nextLine();
    }

    public static void init() {
        StringBuilder solution = new StringBuilder();
        solution.append("`?` - Help:\n");
        solution.append("`break` - Quit the programm\n");
        solution.append("`1 msg` - Add an element 'msg' to the tail queue\n");
        solution.append("`2` - Return an element and remove from the head queue\n");
        solution.append("`3` - Return an element from the head queue\n");
        solution.append("`print` - Return all elements from the queue\n");
        System.out.println(solution.toString());
    }

}
