import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
 * результат после каждой итерации запишите в лог-файл.
 */
public class hw01 {
    public static void main(String[] args) throws IOException {
        // Логирование изменений
        Logger logger = Logger.getLogger(hw01.class.getName());
        FileHandler fch = new FileHandler("log.txt");
        logger.addHandler(fch);
        SimpleFormatter sFormat = new SimpleFormatter();
        fch.setFormatter(sFormat);
        
        int[] array = inputArray("Введите числа через запятую:", logger);
        // генерация массива с 10 случайными элементами
        // int[] array = creatArray(1, 10, 10);
        logger.log(Level.WARNING, "Не отсортированный массив\n" + Arrays.toString(array));

        // Сортируем массив и пишем в лог каждый шаг
        sortArray(array, logger);
    }

    public static int[] creatArray(int min, int max, int len) {
        int[] res = new int[len];
        Random rnd = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt(min, max);
        }
        return res;
    }

    public static int[] sortArray(int[] arr, Logger log) {
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    log.info(Arrays.toString(arr));
                }
            }
        }
        return arr;
    }

    public static int[] inputArray(String msg, Logger log){
        Scanner iscan = new Scanner(System.in);
        System.out.println(msg);
        String[] temparr = iscan.nextLine().strip().split(",");
        int[] res = new int[temparr.length];
        for (int i = 0; i < temparr.length; i++) {
            try {
                res[i] = Integer.parseInt(temparr[i]);
            } catch (Exception e) {
                log.warning("Some thing wrong after parse with users inputs:" + temparr[i]);
            }
        }
        iscan.close();
        return res;
    }

}