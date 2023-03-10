import java.util.ArrayList;
import java.util.Random;

/**
 *  Заполнить список десятью случайными числами. 
 * Отсортировать список методом sort() и вывести его на экран.
 */
public class task01 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = creatRandomArrList(1,100, 10);
        System.out.println(randomList.toString());
        randomList.sort(null);
        System.out.println(randomList.toString());
    }
    
    public static ArrayList<Integer> creatRandomArrList(int min, int max, int count){
        ArrayList<Integer> list = new ArrayList<Integer>(count);
        Random rnd  = new Random();
        for (int i = 0; i < count; i++) {
            list.add(rnd.nextInt(min, max));
        }
        return list;
    }
}
