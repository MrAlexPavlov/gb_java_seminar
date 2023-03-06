import java.util.Arrays;

/**
Дан массив nums = [3,2,2,3,4,5,3] и число val = 3. 
Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
Вывод:
[2,2,4,5,3,3,3]
 */
public class task03 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4,5,3};
        int val = 3;
        sortByValue(arr, val);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sortByValue(int[] arr, int val){
        int cnt = 0;
        for (int i : arr) {
            if (i != val){
                arr[cnt++] = i;
            }
        }
        for (int i=cnt; i<arr.length;i++){
            arr[i] = val;
        }
    }

}