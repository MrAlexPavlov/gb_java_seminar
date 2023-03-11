import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Задан целочисленный список ArrayList. 
 * Найти минимальное, максимальное и среднее ариф. из этого списка.
 */
public class hw03 {
    public static int min, max;
    public static double avg;
    public static void main(String[] args) {
        ArrayList<Integer> arr_int_list = creatArray(-50, 50, 20);
        mathMinMaxAvg(arr_int_list);

        // Выводим в консоль все элементы массива, а так же его максимум минимум и среднеарифмитическое
        System.out.println(arr_int_list.toString());
        NumberFormat nf = new DecimalFormat("#.######");
        System.out.printf("min: %d\tmax:%d\t\taverage:%s",min, max, nf.format(avg));

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

    private static void mathMinMaxAvg(ArrayList<Integer> a_list){
        int sum = 0;
        // Находим минимум, максимум и среднеарифмитическое элементов массива
        for (Integer value : a_list) {
            if (value > max) max = value;
            if (value < min) min = value;
            sum+=value;
        }
        avg = (double)sum / a_list.size();
    }
}
