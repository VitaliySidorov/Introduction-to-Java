// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

// Доп задача
// Реализовать алгоритм сортировки слиянием

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class task3_1 {
    private static FileWriter writer;

    public static void writeToFile(String s) throws IOException { // метод записи строки лог-файла
        writer.write(s + "\n");
    }

    private static float calculateAverage(List<Integer> array) { // метод расчета среднего значения элемента списка
        Integer sum = 0;
        if (!array.isEmpty()) {
            for (Integer elementArray : array) {
                sum += elementArray;
            }
            return (float) sum.doubleValue() / array.size();
        }
        return sum;
    }

    public static void removingEvenItems(List<Integer> array) { // метод удаления четных элементов из списка
        Iterator<Integer> elementArray = array.iterator();
        while (elementArray.hasNext()) {
            Integer element = elementArray.next();
            if (element % 2 == 0) {
                elementArray.remove();
            }
        }
    }

    public static void fillingArray(List<Integer> array, int number) { // метод заполнения массива случайными числами
        for (int index = 0; index < number; index++) {
            array.add((int) (Math.random() * 201) - 100);
        }
    }

    public static void main(String[] args) {
        try {
            File fileList = new File("list.txt");
            fileList.createNewFile();
            writer = new FileWriter(fileList);
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Введите количество элементов массива: ");
            int number = iScanner.nextInt();

            ArrayList<Integer> array = new ArrayList<Integer>();
            fillingArray(array, number);

            System.out.println("Задан массив случайных чисел:\t\t" + array.toString());
            writeToFile("Задан массив случайных чисел:\t\t" + array.toString());

            MergeSort ms = new MergeSort(array);
            ms.sortGivenArray();

            System.out.println("Сортировка массива слиянием:\t\t" + array.toString());
            writeToFile("Сортировка массива слиянием:\t\t" + array.toString());

            int max = Collections.max(array);
            System.out.println("Максимальный элемент списка:\t\t" + max);
            writeToFile("Максимальный элемент списка:\t\t" + max);

            int min = Collections.min(array);
            System.out.println("Минимальный элемент списка:\t\t" + min);
            writeToFile("Минимальный элемент списка: \t\t" + min);

            System.out.println("Среднее значение элементов списка:\t" + calculateAverage(array));
            writeToFile("Среднее значение элементов списка:\t" + calculateAverage(array));

            removingEvenItems(array);
            System.out.println("Удаление всех четных элементов списка:\t" + array.toString());
            writeToFile("Удаление всех четных элементов из списка:\t" + array.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
