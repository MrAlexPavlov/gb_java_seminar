import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * hw01
 */
public class hw01 {
    private static Scanner iscan = new Scanner(System.in);
    private static int count_laptops = 110; // Количество загруженных ноутбуков
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        // Создаем ноутбуки из базы
        List<Laptop> laptops_obj = new ArrayList<>();
        for (int i = 0; i < count_laptops; i++) {
            Laptop lap = new Laptop();
            lap.getLaptop(i);
            if (lap.info.size()!=0) {
                laptops_obj.add(lap);
            }
        }
        // Выводим помощь при работе с консолью
        System.out.println("Загружено " + laptops_obj.size() + " ноутбуков");
        help();
        // Просим пользователь ввести поисковый запрос
        String query = usersQuery(": ");
        // Перебираем ноутбуки и ищем подходящий, выводим его значения если есть совпадения
        int cnt = 0;
        for (Laptop lap : laptops_obj) {
            if (lap.parseQuery(query)) {
                lap.show();
                cnt++;
            }
        }
        System.out.printf("\nПо запросу %s найдено: %d ноутбуков",query,cnt);
    }

    public static String usersQuery(String text) {
        System.out.print(text);
        return iscan.nextLine();
    }

    public static void help() {
        StringBuilder str = new StringBuilder();
        str.append("\nЗадайте фильтр в формате(минимальные значения):\n");
        str.append("hdd=512,screen=15,..\n\n");
        str.append("Доступные поля для поиска:\n");
        str.append("brand; model; cpu; gpu; - текстовые поля \n");
        str.append("ram; hdd; screen(inch); price; - целочисленные.\n");
        System.out.println(str.toString());
    }
}
