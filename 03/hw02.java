import java.util.ArrayList;
import java.util.Random;

/**
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */
public class hw02 {
    public static void main(String[] args) {
        // Создаем список со случайными целыми числами
        ArrayList<Integer> some_array_int_list = creatArray(-50, 50, 50);
        System.out.println(some_array_int_list.toString());
        // Удаляем из списка все четные числа
        removeEvenDidgit(some_array_int_list);
        System.out.println(some_array_int_list.toString());
    }

    public static ArrayList<Integer> creatArray(int min, int max, int len) {
        ArrayList<Integer> res = new ArrayList<Integer>(len);
        // Генерация списка со случайными целыми числами
        Random rnd = new Random();
        System.out.println(res.size());
        for (int i = 0; i < len; i++) {
            res.add(rnd.nextInt(min, max));
        }
        return res;
    }

    public static void removeEvenDidgit(ArrayList<Integer> arr) {
        // Удаляем четные числа из списка
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0){
                arr.remove(i);
                i--;
            }
        }
    }
}
