import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Даны 2 строки, написать метод, который вернет true, если эти строки являются
 * изоморфными и false, если нет. Строки изоморфны, если одну букву в первом
 * слове можно заменить на некоторую букву во втором слове, при этом
 * 
 * 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с
 * сохранением порядка следования. (Например, add - egg изоморфны)
 * 2. буква может не меняться, а остаться такой же. (Например, note - code)
 * 
 * Пример 1:
 * 
 * Input: s = "foo", t = "bar"
 * 
 * Output: false
 * 
 * Пример 2:
 * 
 * Input: s = "paper", t = "title"
 * 
 * Output: true
 * 
 */
public class task02 {
    public static Scanner iscan = new Scanner(System.in);

    public static void main(String[] args) {

        Boolean isomorph_bool;
        String first_word = userText("Введите 1 слово: ");
        String second_word = userText("Введите 1 слово: ");
        
        isomorph_bool = isomorph(first_word, second_word);
        if (isomorph_bool){
            System.out.printf("Слова %s и %s - изоморфны",first_word,second_word);    
        } else {
            System.out.printf("Слова %s и %s - НЕ изоморфны", first_word,second_word);
        }
       
    }

    public static String userText(String text) {
        System.out.println(text);
        return iscan.nextLine();
    }

    public static Boolean isomorph(String first, String second) {
        if (first.length() != second.length())
            return false;

        Map<Character, Character> iso = new HashMap<>();
        Map<Character, Character> iso2 = new HashMap<>();
        Object ins, ins2;
        for (int i = 0; i < first.length(); i++) {

            ins = iso.putIfAbsent(first.charAt(i), second.charAt(i));
            if (ins != null && iso.get(first.charAt(i)) != second.charAt(i))
                return false;
            
            ins2 = iso2.putIfAbsent(second.charAt(i), first.charAt(i));
            if (ins2 != null && iso2.get(second.charAt(i)) != first.charAt(i))
                return false;

        }
        return true;
    }
}
