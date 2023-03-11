import java.util.Arrays;
import java.util.Random;

/**
 *(Дополнительно) Реализовать алгоритм сортировки слиянием
 */
public class hw01 {
    public static void main(String[] args) {
        int[] int_array = creatArray(0, 10, 10);
        System.out.println(Arrays.toString(int_array));
    }

    public static int[] creatArray(int min, int max, int len) {
        int[] res = new int[len];
        Random rnd = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt(min, max);
        }
        return res;
    }

    public static void sortArray(int[] arr){
        // Тут должен быть код с рекурсией
    }

    
}
