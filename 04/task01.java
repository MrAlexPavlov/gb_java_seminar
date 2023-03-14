import java.util.ArrayList;

/**
 * 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
 * 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
 */
public class task01 {
    public static int cnt = 1000_000_000;
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
        for (int i = 0; i <res_arr.size(); i++) {
            res_arr.add(0,"+");
        }
    }

    public static void createLinkedList(int cnt) {
        ArrayList<String> res_arr = new ArrayList<String>(cnt);
        for (int i = 0; i <res_arr.size(); i++) {
            res_arr.add(0,"-");
        }
    }
    
}
