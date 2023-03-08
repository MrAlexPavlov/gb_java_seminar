import java.util.logging.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 * К калькулятору из предыдущего дз добавить логирование.
 * 1 + 3 = 4
 * 4 + 3 = 7
 */
public class hw03 {
    public static String log_file = "calc.log";
    public static void main(String[] args) throws SecurityException, IOException {

        Logger loger = initLog();
        
        String text = "Введите пример формата a + b\n(пробелы обязательны):\n";
        String users_entered = input(text);
        
        loger.log(Level.FINE, "Users equation: " + users_entered);

        String[] equation = users_entered.trim().split("\\\s+"); 
        
        try {
            float a = Float.parseFloat(equation[0]);
            char what = equation[1].charAt(0);
            float b = Float.parseFloat(equation[2]);
            loger.log(Level.FINE,"Parsed equation: a = " + a + " b = " + b + " what =" + what);
            calc(a, b, what);
        } catch (Exception e) {
            loger.log(Level.WARNING, "Parsing error! : " + users_entered);
        }        
    }

    public static Logger initLog() throws SecurityException, IOException{
        Logger loger = Logger.getLogger(hw03.class.getName());
        FileHandler fch = new FileHandler(log_file);
        loger.addHandler(fch);
        SimpleFormatter sformat = new SimpleFormatter();
        fch.setFormatter(sformat);
        loger.setLevel(Level.FINE);
        loger.log(Level.FINE, "Class initialized");
        return loger;
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
        System.out.println( nf.format(a) + " " + what + " " + nf.format(b) + " = "+ nf.format(res) );
    
        return;
    }

    public static String input(String text) {
        String result = "";
        Scanner iScan = new Scanner(System.in);
        System.out.print(text);
        result = iScan.nextLine();
        iScan.close();
        return result;
    }

    public static void print(String msg){
        System.out.println(msg);
    }
}
