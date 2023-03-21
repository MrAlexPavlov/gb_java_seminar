import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1. Создайте HashSet, заполните его следующими числами: {1, 2, 30000, 2, 4, 5000, 6, 3}. Распечатайте содержимое данного множества.
 * 2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 30000, 2, 4, 5000, 6, 3}.  Распечатайте содержимое данного множества.
 * 3. Создайте TreeSet, заполните его следующими числами: {1, 2, 30000, 2, 4, 5000, 6, 3}.  Распечатайте содержимое данного множества.
 */
public class task01 {

    public static void main(String[] args) {
        System.out.println("HashSet:\t" + mkHashSet().toString());

        System.out.println("LinkedHashSet:\t" + mkLinkedHashSet().toString());

        System.out.println("TreeSet:\t" + mkTreeSet().toString());
        
    }

    public static Set<Integer> mkHashSet() {
        Set<Integer> resSet = new HashSet<>(Arrays.asList(1, 2, 30000, 2, 4, 5000, 6, 3));
        return resSet;
    }
    
    public static Set<Integer> mkLinkedHashSet() {
        Set<Integer> resSet = new LinkedHashSet<>(Arrays.asList(1, 2, 30000, 2, 4, 5000, 6, 3));
        return resSet;
    }

    public static Set<Integer> mkTreeSet() {
        Set<Integer> resSet = new TreeSet<>(Comparator.reverseOrder());
        resSet.addAll(Arrays.asList(1, 2, 30000, 2, 4, 5000, 6, 3));
        return resSet;
    }
    
}