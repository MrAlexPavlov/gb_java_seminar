/**
 * Дано четное число N (>0) и символы c1 и c2.
 * Написать метод, который вернет строку длины N,
 * которая состоит из чередующихся символов c1 и c2, начиная с c1.
 */
public class task01 {

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        int n = 10;
        System.out.println(concatN(a, b, n));
    }

    public static String concatN(char a, char b, int cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            res.append(i % 2 == 0 ? a : b) ;
        }
        return res.toString();
    }
}
