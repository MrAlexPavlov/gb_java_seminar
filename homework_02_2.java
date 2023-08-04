
/*
Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. 
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
 с сообщением "Деление на ноль недопустимо". 
 В противном случае, программа должна выводить результат деления.

Обратите внимание, что в обоих задачах используются собственные исключения, которые наследуются от класса Exception. 
Это позволяет нам определить специфическую причину ошибки и передать информацию об ошибке для последующей обработки.
*/

import java.util.Scanner;

public class homework_02_2 {
    public static void main(String[] args) {
        float a, b = 0;
        try {
            a = (float) input("Insert number 'a': ", false);
            b = (float) input("Insert number 'b': ", true);
            float c =  a / b;
            System.out.printf("{a} / {b} = " + a/b);
        } catch (InvalidDivException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Это не число!");
        }

    }

    public static int input(String text, boolean zero) throws InvalidDivException {
        Scanner iScan = new Scanner(System.in);
        int result = 0;
        System.out.println(text);
        result = Integer.parseInt(iScan.nextLine());

        if (result == 0 & zero) {
            throw new InvalidDivException("Деление на ноль не допустимо!");
        }
        return result;
    }

}

class InvalidDivException extends Exception {
    public InvalidDivException(String message) {
        super(message);
    }
}
