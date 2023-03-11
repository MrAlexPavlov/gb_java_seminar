import java.util.ArrayList;
import java.util.Random;

/**
 * Создать список типа ArrayList.
 * Поместить в него как строки, так и целые числа.
 * Пройти по списку, найти и удалить целые числа
 */
public class task03 {
    public static Character[] alphabet = { 'a', 'b', 'c', 'd', 'e',
             'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    public static int min_int_array = 0;
    public static int max_int_array = 99999;
    public static int min_str_array = 4;
    public static int max_str_array = 6;
    public static Random rnd = new Random();

    public static void main(String[] args) {
        ArrayList<Object> res_list = randomArrayList(20);
        System.out.println(res_list.toString());
        removeNaturalDigits(res_list);
        System.out.println(res_list.toString());
    }

    public static ArrayList<Object> removeNaturalDigits(ArrayList<Object> arr){
        for (int i = 0; i < arr.size(); i++) {
            if ( arr.get(i) instanceof Integer ){
                arr.remove(i);
                i--;
            }
        }
        return arr;
    }

    public static ArrayList<Object> randomArrayList(int cnt) {
        // Создаем список состоящий как из натуральных чисел так и текста
        ArrayList<Object> res_list = new ArrayList<Object>();
        for (int i = 0; i < cnt; i++) {
            if (rnd.nextInt(0, 2) == 1) {
                res_list.add(rndInt());
            } else {
                res_list.add(rndString());
            }
        }
        return res_list;
    }

    private static int rndInt() {
        return rnd.nextInt(min_int_array, max_int_array + 1);
    }

    private static String rndString() {
        StringBuilder m = new StringBuilder();
        int tmp;
        // Cлучайно выбираем сколько будет символов в строке
        int max = rnd.nextInt(max_str_array, max_str_array + 1);
        for (int i = 0; i < max; i++) {
            // Случайно выбираем символ из алфавита
            tmp = rnd.nextInt(0, alphabet.length);
            m.append(alphabet[tmp]);
        }
        return m.toString();
    }
}
