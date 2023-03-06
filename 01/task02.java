/**
 * Дан массив двоичных чисел, например [1,1,0,1,1,1],
 * вывести максимальное количество подряд идущих 1.
 */
public class task02 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 1, 1, 1, 0, 1, 1, 1, 0 };
        int max = inaRow(array);
        System.out.println("Максимальное количество едениц подряд: " + max);
    }

    public static int inaRow(int[] arr) {
        int res = 0, cnt = 0;

        for (int i : arr) {
            if (i == 0 && res < cnt) {
                res = cnt;
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return res < cnt ? cnt : res;
    }

}