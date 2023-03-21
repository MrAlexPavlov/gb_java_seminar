import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 1. Напишите метод, который заполнит массив из 100 элементов случайными
 * цифрами от 0 до 100.
 * 
 * 2. Создайте метод, в который передайте заполненный выше массив
 * и с помощью Set вычислите процент уникальных значений в данном массиве и
 * верните его в виде числа с плавающей запятой.
 * 
 * Для вычисления процента используйте формулу:
 * процент уникальных чисел = количество уникальных чисел * 100 / общее
 * количество чисел в массиве.
 * 
 */
public class task02 {
    private static int min = 0;
    private static int max = 100;
    private static int count = 80;

    public static void main(String[] args) {
        int[] rand_int = mkRandomIntArray();
        System.out.println("Percent unique:\t" + percentUniqElems(rand_int));
    }

    // Создаем случайный массив с целочисленными значениями
    public static int[] mkRandomIntArray() {
        int[] res_array = new int[count];
        Random rnd = new Random();
        for (int i = 0; i < res_array.length; i++)
            res_array[i] = rnd.nextInt(min, max);
        return res_array;
    }

    // Используя свойство множества оставляем только уникальные значения
    // и рассчитаем процент уникальных значений в исходном массиве
    public static Float percentUniqElems(int[] arr) {
        Set<Integer> tempSet = new HashSet<>();
        for (int i : arr)
            tempSet.add(i);
        return ((float) tempSet.size() * 100) / count;
    }

}
