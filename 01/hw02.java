
/**
 * Вывести все простые числа от 1 до 1000
 */
public class hw02 {
    public static void main(String[] args) {
        System.out.println("Start");
        int max = 1000;
        for (int i = 2; i <= max; i++){
            if ( isSimple(i) ) {
                System.out.print(i);
                System.out.print(" ");
            }
        }

    }

    public static boolean isSimple(int n){
        boolean res = true;
        for (int i = 2; i < n; i++){
            if (n % i == 0) res = false;
        }
        return res;
    }
    
}