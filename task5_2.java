// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class task5_2 {

    public static String readFile(String fileName) throws Exception // Загрузка данных из файла
    {
        String data = "";
        data = new String(
                Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static List<String> getName(String data) { // Выборка имен из списка
        List<String> listName = new ArrayList<>();
        List<String> myList = new ArrayList<String>(Arrays.asList(data.split("\n")));
        for (String name : myList) {
            listName.add(name.substring(0, name.indexOf(" ")));
            ;
        }
        return listName;
    }

    public static void main(String[] args) throws Exception {
        String data = readFile("employees.txt"); // Подгружаем файл с данными
        File outputFile = new File("names.out"); // Задаем файл для вывода

        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(outputFile));

            ArrayList<String> listName = (ArrayList<String>) getName(data);

            // Задаем карту имен с количествами повторов
            Map<String, Long> unsortList = listName.stream()
                    .collect(Collectors
                            .groupingBy(Function.identity(),
                                    Collectors.counting()));

            // Сортируем карту имен по убыванию популярности
            LinkedHashMap<String, Long> sortedMap = unsortList.entrySet()
                    .stream()
                    .sorted(Map.Entry
                            .comparingByValue(Comparator
                                    .reverseOrder()))
                    .collect(Collectors
                            .toMap(Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new));

            // Выводим отсортированный список в консоль
            sortedMap.forEach((k, v) -> System.out.println(k + ":   \t" + v + " чел."));
            
            // Записываем отсортированный список в файл
            for(Map.Entry<String, Long> entry : sortedMap.entrySet()){
            bf.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            
            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }

    }

}
