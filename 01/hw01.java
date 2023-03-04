import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n),
 * а так же n! (произведение чисел от 1 до n)
 * Ввод:5
 * Треугольное число 1 + 2 + 3 + 4 + 5 = 15
 * n! 1 * 2 * 3 * 4 * 5 = 120
 */

public class hw01 {
    public static void main(String[] args) {
        int n = 0;
        try {
            String str = input("Введите число");
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод числа!");
        }
        int outSum = sum(n);
        int outFactorial = factorial(n);
        System.out.printf("%d, %d", outSum, outFactorial);
    }

    public static int sum(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static String input(String text) {
        Scanner iScan = new Scanner(System.in);
        System.out.println(text);
        String result = iScan.nextLine();
        iScan.close();
        return result;
    }

}