import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Laptop {
    private String bd_file = new File("bd.csv").getAbsolutePath();
    private String[] fields;
    private Map<Integer, Map<String, String>> bd_laptop = new HashMap<>();
    public Map<String, String> info = new HashMap<>();

    private String brand;
    private String model;
    private String cpu;
    private String ram;
    private String hdd;
    private String gpu;
    private String screen;
    private String price;

    // Вытаскиваем ноутбуки из базы.
    public void getLaptop(int i) {
        loadDBfromCSVFile();
        if (i>=bd_laptop.size()) return;
        this.info = bd_laptop.get(i);

        this.brand = bd_laptop.get(i).get("brand").trim();
        this.model = bd_laptop.get(i).get("model").trim();
        this.cpu = bd_laptop.get(i).get("cpu").trim();
        this.ram = bd_laptop.get(i).get("ram").trim();
        this.hdd = bd_laptop.get(i).get("hdd").trim();
        this.gpu = bd_laptop.get(i).get("gpu").trim();
        this.screen = bd_laptop.get(i).get("screen").trim();
        this.price = bd_laptop.get(i).get("price").trim();
        this.brand = bd_laptop.get(i).get("brand").trim();
    }

    private void loadDBfromCSVFile() {
        int i = 0;
        String line;
        String[] values;
        try {
            FileReader fr = new FileReader(bd_file);
            Scanner fscan = new Scanner(fr);
            // Читаем название cтолбцов из csv файла
            line = fscan.nextLine().trim().replaceAll("\n", "");
            // Конвертация строки в массив со значениями, назания столбцов.
            fields = convertLineToArray(line);

            // Производим чтение данных и заполняем массив нашей базы, данными типа HashMap
            while (fscan.hasNextLine()) {
                line = fscan.nextLine().trim().replaceAll("\n", "");

                // Создаем массив HashMap со значениями из датасета
                // где ключи - имена столбцов
                Map<String, String> temp_map = new HashMap<>();
                values = convertLineToArray(line);
                temp_map = arraysToMap(fields, values);
                // Наполняем базу данных
                bd_laptop.put(i++, temp_map);
            }
            // System.out.println(bd_laptop);
            fr.close();
            fscan.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private String[] convertLineToArray(String line) {
        line = line.replaceAll("\"", "");
        return line.split(",");
    }

    private Map<String, String> arraysToMap(String[] fields, String[] values) {
        Map<String, String> temp_map = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            temp_map.put(fields[i], values[i]);
        }
        return temp_map;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    // Возвращает true если этот ноутбук подходит под требования
    public Boolean parseQuery(String query) {
        Boolean res = false;
        String source;
        query = query.toLowerCase();
        int a, b;
        for (String msg : query.trim().split(",")) {
            String[] arr = msg.trim().split("=");
            if (this.info.get(arr[0]) == null) continue;
            // Если поля целочисленные то делаем проверку, поиск это минимум
            try {
                a = Integer.parseInt(arr[1]);
                b = Integer.parseInt(this.info.get(arr[0]));
                if (b >= a) {
                    res = true;
                } else {
                    res = false;
                    break;
                }
            // Если оказались строковыми то ищем совпадения в том числе частичные
            } catch (Exception e) {
                source = this.info.get(arr[0]).toLowerCase();
                if (source.contains(arr[1])){
                    res = true;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public void show(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("%s %s ",this.brand, this.model));
        str.append(String.format(", %s,  RAM:%s GB",this.cpu, this.ram));
        str.append(String.format(", HDD:%s GB,  GPU:%s GB",this.hdd, this.gpu));
        str.append(String.format(", Screen size:%s\",  price:%s Rub",this.screen, this.price));
        System.out.println(str.toString());
    }

}
