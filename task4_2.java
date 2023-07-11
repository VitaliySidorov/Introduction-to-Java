import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class task4_2 {

    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Задаем первое число в список в обратном порядке
        int numberN = nextNumber(1);
        int tempN = numberN;
        ArrayList<Integer> arrayN = new ArrayList<Integer>();
        for (int i = 0; i < String.valueOf(numberN).length(); i++) {
            if (tempN == 0)
                break;
            arrayN.add(tempN % 10);
            tempN /= 10;
        }

        // Задаем второе число в список в обратном порядке
        int numberM = nextNumber(2);
        int tempM = numberM;
        ArrayList<Integer> arrayM = new ArrayList<Integer>();
        for (int i = 0; i < String.valueOf(numberM).length(); i++) {
            if (tempM == 0)
                break;
            arrayM.add(tempM % 10);
            tempM /= 10;
        }

        Deque<Integer> d1 = new LinkedList<Integer>();
        for (int i : arrayN)
            d1.add(i);
        Deque<Integer> d2 = new LinkedList<Integer>();
        for (int j : arrayM)
            d2.add(j);

        System.out.println("Первое число: " + Arrays.toString(d1.toArray()));
        System.out.println("Второе число: " + Arrays.toString(d2.toArray()));

        System.out.println("Произведение: " + mult(d1, d2));

    }

     public static Deque<Integer> mult(Deque<Integer> d1, Deque<Integer> d2) {
        // Создаем новый связанный список для хранения результата умножения
        Deque<Integer> result = new ArrayDeque<>();

        // Проверяем, является ли одно из чисел отрицательным
        boolean isNegativeFirst, isNegativeSecond;
        if (isNegativeFirst = (d1.getLast() < 0));
        if (isNegativeSecond = (d2.getLast() < 0));

        // Инициализируем массив для хранения промежуточных результатов умножения
        int[] intermediateResults = new int[d1.size() + d2.size()];

        // Выполняем умножение цифр
        for (int i = 0; i < d1.size(); i++) {
            int digit1 = Math.abs(d1.removeFirst());
            int carry = 0;

            for (int j = 0; j < d2.size(); j++) {
                int digit2 = Math.abs(d2.removeFirst());
                int product = digit1 * digit2 + intermediateResults[i + j] + carry;

                intermediateResults[i + j] = product % 10;
                carry = product / 10;
                d2.addLast(digit2);
            }

            if (carry > 0) {
                intermediateResults[i + d2.size()] += carry;
            }

            d1.addLast(digit1);
        }
        
        // Удаляем ведущие нули из промежуточных результатов
        int i = intermediateResults.length - 1;
        while (i >= 0 && intermediateResults[i] == 0) {
            i--;
        }

        // Формируем итоговый связанный список
        if (isNegativeFirst ^ isNegativeSecond) {
            result.addLast(-1);
            
        }
        
        while (i >= 0) {
            result.addFirst(intermediateResults[i]);
            i--;
        }
        return result;
    }
    


public static int nextNumber(int a) { // Ввод числа
        System.out.printf("Введите %d-е число: ", a);
        int number;
        if (iScanner.hasNextInt()) {
            number = iScanner.nextInt();
        } else {
            System.out.println("Неверный ввод числа. Попробуйте еще раз.");
            iScanner.next();
            number = nextNumber(a);
        }

        return number;
    }
}