import java.util.LinkedList;

/**
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод(не void), который вернет “перевернутый” список.
 */
public class hw01 {
    public static int cnt_str_array = 10;

    public static void main(String[] args) {
        LinkedList<Integer> some_arr = creatRandomLinkedList();
        System.out.println("original: " + some_arr.toString());

        System.out.println("first reverse method: " + reversLinkedList(some_arr).toString());

        System.out.println("second reverse method:" + reversLinkedList2(some_arr).toString());
    }

    private static LinkedList<Integer> creatRandomLinkedList() {
        LinkedList<Integer> res_array = new LinkedList<Integer>();
        for (int i = 0; i < cnt_str_array; i++) {
            res_array.add(i);
        }
        return res_array;
    }
    // Метод разворота списка путем замены элементов, без создания нового списка
    private static LinkedList<Integer> reversLinkedList(LinkedList<Integer> arr) {
        int frst,scnd;
        for (int i = 0; i < arr.size()/2; i++) {
            frst = arr.get(i);
            scnd = arr.get(arr.size() - i - 1);

            arr.remove(i);
            arr.add(i, scnd);

            arr.remove(arr.size() - i - 1);
            arr.add(arr.size() - i, frst);
        }
        return arr;
    }
    // Метод разворота списка через создание нового списка и перебора текущего.
    private static LinkedList<Integer> reversLinkedList2(LinkedList<Integer> arr) {
        LinkedList<Integer> res_arr = new LinkedList<Integer>();
        for (Integer val : arr) {
            res_arr.addLast(val);
        }
        return res_arr;
    }
}
