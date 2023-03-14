import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
 * 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
 */
public class task01 {
    public static int cnt = 10_000_000;
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        createArrayList(cnt);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        createLinkedList(cnt);
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void createArrayList(int cnt) {
        ArrayList<String> res_arr = new ArrayList<String>(cnt);
        for (int i = 0; i <cnt; i++) {
            res_arr.add("+");
        }
    }

    public static void createLinkedList(int cnt) {
        LinkedList<String> res_arr = new LinkedList<String>();
        for (int i = 0; i <cnt; i++) {
            res_arr.add("-");
        }
    }
    
}
