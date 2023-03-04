import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 * Реализовать простой калькулятор (+ - / *)
 * Ввод числа ->
 * Ввод знака ->
 * Ввод числа ->
 */
public class hw03 {

    public static void main(String[] args) {
        float a = Float.parseFloat( input("Ввод числа `a`: ") );
        Character what = input("Ввод знака: ").charAt(0);
        float b = Float.parseFloat( input("Ввод числа `b`: ") );

        calc(a, b, what);
    }

    public static void calc(float a, float b, Character what){
        float res = 0;
        if ( what == '+' ){
            res = (float) a + b;
        } else if (what == '-') {
            res = (float) a - b;
        } else if (what == '*') {
            res = (float) a * b;
        } else if (what == '/') {
            if (b != 0) {
                res = (float) a / b;
            } else {
                System.out.println("Делить на ноль нельзя!");
                return;
            }
        } else {
            System.out.printf("Действие `%c` не найдено!", what);
            return;
        }
        
        NumberFormat nf = new DecimalFormat("#.######");
        System.out.println( nf.format(a) + what + nf.format(b) + " = "+ nf.format(res) );
    
        return;
    }

    public static String input(String text) {
        String result = "";
        Scanner iScan = new Scanner(System.in);
        System.out.print(text);
        result = iScan.nextLine();
        // iScan.close();
        return result;
    }
}
