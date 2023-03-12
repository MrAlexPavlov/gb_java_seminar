import java.util.Arrays;
import java.util.Random;

/**
 *(Дополнительно) Реализовать алгоритм сортировки слиянием
 */
public class hw01 {
    public static void main(String[] args) {
        int[] int_array = creatArray(0, 10, 10);
        System.out.println(Arrays.toString(int_array));
        
        System.out.println(Arrays.toString(sortArray(int_array)));
    }

    public static int[] creatArray(int min, int max, int len) {
        int[] res = new int[len];
        Random rnd = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt(min, max);
        }
        return res;
    }

    private static int[] merge(int[] left, int[] right) {
        // определяем массив итоговый полученный от слияния двух массивов
        int[] res = new int[left.length + right.length];
        int resIn = 0, lftIn = 0, rghtIn = 0;
        // перебираем обе половинки массива и набираем итоговый из двух уже отсортированным
        while (lftIn < left.length && rghtIn < right.length){
            if (left[lftIn] > right[rghtIn]){
                res[resIn++] = right[rghtIn++];
            } else {
                res[resIn++] = left[lftIn++];
            }
        }
        // Оставшиеся элементы в массивах left и right складываем в результирующий.
        // На те случае когда самый маленький элемент левого массива меньше самого маленького элемента правого.
        // и вверхнем цикле мы обработали только один массив.
        while(resIn < res.length){
            if (lftIn != left.length){
                res[resIn++] = left[lftIn++];
            } else {
                res[resIn++] = right[rghtIn++];
            }
        }
        return res;
    }
    
    public static int[] sortArray(int[] arr){
        // Функция с рекурсией, обозначем вариант выхода из него
        if (arr.length <=1 ) return arr;
        // Делим массив пополам, на условно левую и правую часть
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, left.length, arr.length);
        // Вызываем функцию слияния двух половин в качесте аргументов указываем эту функцию сортировки
        return merge(sortArray(left), sortArray(right));
    }

    
}
