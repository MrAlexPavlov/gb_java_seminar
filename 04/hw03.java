import java.util.logging.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */

public class hw03 {
    public static String log_file = "calc.log";
    public static Logger loger;
    public static Scanner iScan = new Scanner(System.in);
    public static Deque<Object> calc_queue = new LinkedList<Object>();
    public static NumberFormat nf = new DecimalFormat("#.######");
    public static void main(String[] args) throws SecurityException, IOException {
        Logger loger = initLog();

        Object last_answer = false;
        String equ = "";
        String[] equation = new String[3];
        String help = "\n`show` выводит список последних операций\n"
                    + "`esc` сбросить последовательность операции ОТМЕНА\n"
                    + "`del~2` удаляет последние 2 операции\n"
                    + "`break` окончание работы с калькулятором\n";

        String text = "Поддерживается ввод a+b и последующие операции +a";
        String users_entered = "";
        
        print(help);
        while (true) {           
            
            // Если первый проход цикла или
            // Если последнее решение упало с ошибкой то сбрасываем последовательность операций и спрашиваем новый пример
            if (last_answer instanceof Boolean) 
                print(text);
            
            users_entered = input(":");
            loger.log(Level.FINE, "Users equation: " + users_entered);

            // Удаляем последние n операций и делаем возможность продолжить
            if (users_entered.contains("del~")){
                int number_op = 0;
                String last_op = users_entered.replaceAll("del~", "");
                try {
                    number_op = Integer.parseInt(last_op);
                    if (calc_queue.size()<number_op) number_op = calc_queue.size();
                    for (int i = 0; i < number_op; i++) {
                        equ = calc_queue.pollLast().toString();    
                        }
                    
                    if(calc_queue.size()>0){
                        last_answer = Float.parseFloat(forCalcSplit(equ)[0]);
                        print(calc_queue.getLast()+"= " +nf.format(last_answer));
                    } else {
                        last_answer = false;
                    }
                    continue;
                } catch (Exception e) {
                    loger.log(Level.WARNING, "ParsingINT error! : " + users_entered);
                }                
            }
            // Сброс последовательных операций
            if (users_entered.contains("esc")){
                last_answer = false;
                continue;
            }

            // Выходим из программы по команде пользователя
            if (users_entered.contains("break")){
                loger.log(Level.FINE, "Users equation: " + users_entered);
                break;
                }

            // Показываем последние операции
            if (users_entered.contains("show")){
                print(calc_queue.toString());
                last_answer = false;
                continue;
                }

            // Если последняя арифмитическая операция корректно завершилась, то можно продолжить последовательность операций
            if (last_answer instanceof Float){
                users_entered = last_answer + users_entered;
                // print(forCalcSplit(users_entered)[0] + "--here!!\n");
                // if (forCalcSplit(users_entered)[0].equals("0")){
                //     users_entered;
                //     print(users_entered + " last!!\n");
                // }
            }
            
            try {
                // Получаем все элементы арифмитической операции из строки пользователя
                equation = forCalcSplit(users_entered);
               
                float a = Float.parseFloat(equation[0]);
                float b = Float.parseFloat(equation[1]);
                char what = equation[2].charAt(0);
                
                loger.log(Level.FINE,"Parsed equation: a = " + nf.format(a) + " b = " + nf.format(b) + " what =" + what);
                last_answer =  calc(a, b, what);

                // Сохраняем в очередь все операции пользователя
                equ = nf.format(a) + Character.toString(what) + nf.format(b);
                calc_queue.add(equ);

            } catch (Exception e) {
                loger.log(Level.WARNING, "Parsing error! : " + users_entered);
                last_answer = false;
            }

        }
    
    }

    public static String[] forCalcSplit(String str) {
        String[] arr = {"none","none","none"};
        try {
             // Проверяем неявляется ли первое число отрицательным
            // Если верно то запоминаем это и удаляем этот знак
            Boolean first_negative = false; 
            if (str.charAt(0) == '-'){
                first_negative = true;
                str = str.substring(1);
            } else if (str.charAt(0) == '+'){
                str = "0" + str;
            }
            // Удаляем все пробелы
            str = str.replaceAll("\\s+", "");
            // Разбиваем строку на числа с разделителем арифмитических операций +-/*
            arr = str.split("([+\\-*/])");
            // Если размер массива получился больше 2 элементов, значит у второго был знак -
            if (arr.length==3) {
                // Переносим в нужную ячейку массива с противоположным знаком
                // И удаляем уже не нужный символ -
                arr[1] = "-" + arr[2];
                str = str.replace("-", "");
            } else {
                // Если второе число не было отрицательным то расширяем массив для внесения арифмитической операции
                arr = Arrays.copyOf(arr, 3);
            }
            // Если первый элемент арифмитического действия был `-` то добавим его к элементу массива
            if (first_negative) arr[0] = "-" + arr[0];
            // удаляем все цифры, что бы получить итоговую арифмитическую операцию.
            arr[2] = str.replaceAll("([0-9.]*)", "");
            print("arr = " + Arrays.toString(arr));
        } catch (Exception e) {
            loger.log(Level.WARNING, "Parsing error! : " + str);
        }
        return arr;
    }


    public static Object calc(float a, float b, Character what){
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
                return false;
            }
        } else {
            System.out.printf("Действие `%c` не найдено!", what);
            return false;
        }
        System.out.println( nf.format(a) + " " + what + " " + nf.format(b) + " = "+ nf.format(res) );
        return res;
    }

    public static String input(String text) {
        System.out.print(text);    
        return iScan.nextLine();
    }

    public static void print(String msg){
        System.out.println(msg);
    }

    public static Logger initLog() throws SecurityException, IOException{
        Logger loger = Logger.getLogger(hw03.class.getName());
        FileHandler fch = new FileHandler(log_file, true); //true - для добавления в концец файла, без него будет перезаписывать.
        loger.addHandler(fch);
        SimpleFormatter sformat = new SimpleFormatter();
        fch.setFormatter(sformat);
        loger.setLevel(Level.FINE);
        loger.log(Level.FINE, "Class initialized");
        return loger;
    }
}
