// 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Scanner;

public class task2_2 {

    private static FileWriter writer;

    public static void logStep(String s) throws IOException { // метод записи строки лог-файла
        writer.write(new Timestamp(System.currentTimeMillis()) + "\t" + s + "\n");
    }

    public static void bubbleSort(int[] array) { // пузырьковая сортировка
        try {
            Integer count = 0, swap = 0;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j + 1] < array[j]) {
                        swap = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = swap;
                    }
                }
                count++;
                logStep(count + "-я итерация сортировки пузырьком ->\t" + Arrays.toString(array));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File log = new File("log_sorting.txt");
            log.createNewFile();
            writer = new FileWriter(log);

            Scanner iScanner = new Scanner(System.in);
            System.out.println("Введите количество элементов массива: ");
            int number = iScanner.nextInt();
            logStep("Ввод количества элементов массива ->\t" + number);

            int[] array = new int[number];

            for (int index = 0; index < number; index++) {
                array[index] = (int) (Math.random() * 100);
            }
            logStep("Задан массив случайных чисел ->       \t" + Arrays.toString(array) + "\n");

            System.out.println("Массив перед пузырьковой сортировкой:\t" + Arrays.toString(array));

            bubbleSort(array);

            System.out.println("Массив после пузырьковой сортировки:\t" + Arrays.toString(array));
            logStep("Массив отсортирован:                  \t" + Arrays.toString(array));

            iScanner.close();

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