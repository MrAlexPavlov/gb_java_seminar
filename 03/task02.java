import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Заполнить список названиями планет Солнечной системы 
 * в произвольном порядке с повторениями. 
 * Вывести название каждой планеты и количество его повторений в списке.
 */
public class task02 {
    public static String[] planet = {"Sun", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
    public static void main(String[] args) {
        ArrayList<String> randomPlanetList = randomPlaneArrayList(10);
        System.out.println(randomPlanetList);
        System.out.println(groupBy(randomPlanetList));
    }

    public static ArrayList<String> randomPlaneArrayList(int cnt){
        ArrayList<String> resList = new ArrayList<String>();
        Random rnd = new Random();
        for (int i = 0; i < cnt; i++) {
            resList.add(planet[rnd.nextInt(0,planet.length-1)]);
        }
        return resList;
    }
    
    public static ArrayList<String> groupBy(ArrayList<String> arrList){
        arrList.sort(Comparator.naturalOrder());
        String itog = "";
        ArrayList<String> res = new ArrayList<String>();

        String temp = arrList.get(0);
        int cnt = 0;
        for (String pln : arrList) {
            if (temp.equals(pln)){
                cnt++;
            } else {
                itog = "\"" + temp + ":" + cnt +"\"";
                res.add(itog);
                cnt = 1;
            }
            temp = pln;
        }
        itog = "\"" + temp + ":" + cnt +"\"";
        res.add(itog);
        return res;
    }


}


// Создать список типа ArrayList. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа
