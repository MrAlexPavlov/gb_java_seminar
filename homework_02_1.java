
/*
Задача 1:
Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно положительным.
Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException 
с сообщением "Некорректное число". В противном случае, программа должна выводить сообщение "Число корректно".
*/

import java.util.Scanner;

public class homework_02_1 {
    public static void main(String[] args) {
        int a = 0;
        try {
            a = input("Insert a number: ");
            System.out.println("Число корректно");
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Это не число!");
        }

    }

    public static int input(String text) throws InvalidNumberException {
        Scanner iScan = new Scanner(System.in);
        int result = 0;
        System.out.println(text);
        result = Integer.parseInt(iScan.nextLine());

        if (result < 0) {
            throw new InvalidNumberException("Число не корректно!");
        }
        iScan.close();
        return result;
    }

}

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}
