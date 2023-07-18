// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, 
// отвечающие фильтру.
// Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации 
// можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package Task_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>(); // Определяем список доступных моделей
        laptops.add(new Laptop("Model 1", 8, 256, "Windows", "Black"));
        laptops.add(new Laptop("Model 2", 16, 512, "Windows", "Silver"));
        laptops.add(new Laptop("Model 3", 8, 512, "MacOS", "Grey"));
        laptops.add(new Laptop("Model 4", 16, 256, "Linux", "White"));
        laptops.add(new Laptop("Model 5", 8, 512, "Windows", "Black"));

        System.out.println("Laptops are available:");
        for (Laptop laptop : laptops) System.out.println(laptop);

        Map criteria = new HashMap();
        criteria.put(1, "RAM");
        criteria.put(2, "Storage");
        criteria.put(3, "Operating System");
        criteria.put(4, "Color");

        System.out.println(criteria);

        Map filterParams = new HashMap<>(); // Определяем параметры фильтрации

        System.out.print("Enter a Criteria for Selection -> ");
        Scanner scanner = new Scanner(System.in);
        Integer selection = scanner.nextInt();

        String filterKey = "";
        switch (selection) {
            case 1:
            filterKey = "RAM";
            System.out.print("Enter a Value for " + filterKey + " -> ");
            Integer valueRam = scanner.nextInt();
            filterParams.put(filterKey, valueRam);
            break;

            case 2:
            filterKey = "Storage";
            System.out.print("Enter a Value for " + filterKey + " -> ");
            Integer valueStorage = scanner.nextInt();
            filterParams.put(filterKey, valueStorage);
            break;

            case 3:
            filterKey = "OS";
            System.out.print("Enter the Type of " + filterKey + " -> ");
            String valueOS = scanner.next();
            filterParams.put(filterKey, valueOS);
            break;

            case 4:
            filterKey = "Color";
            System.out.print("Enter the desired " + filterKey + " -> ");
            String valueColor = scanner.next();
            filterParams.put(filterKey, valueColor);
            break;

        }
        
        // System.out.println(filterParams);

        Set<Laptop> filteredLaptops = new HashSet<>(); // Определяем список для отфильтрованных моделей
        for (Laptop laptop : laptops) {

            if (selection == 1 && laptop.getRam() == (int) filterParams.get("RAM")) {
                filteredLaptops.add(laptop);
            }
            
            if (selection == 2 && laptop.getStorage() == (int) filterParams.get("Storage")) {
                filteredLaptops.add(laptop);
            }
            
            if (selection == 3 && laptop.getOs().equals(filterParams.get("OS"))) {
                // System.out.println(laptop.getOs());
                // System.out.println(filterParams.get("OS"));
                filteredLaptops.add(laptop);
            }
            if (selection == 4 && laptop.getColor().equals(filterParams.get("Color"))) {
                filteredLaptops.add(laptop);
            }
        }
        
        System.out.println("\nFiltered Laptops:"); // Выводим отфильтрованные модели
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
        scanner.close();
    }
}