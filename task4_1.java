// Даны два Deque, представляющие два целых числа. 
// Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 2) Сложите два числа и верните сумму в виде связанного списка. 
// Одно или два числа должны быть отрицательными.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class task4_1 {

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

        System.out.println("Сумма: " + sum(d1, d2));

    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) { // Сложение числе в списке
        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            int sum = carry;
            if (!d1.isEmpty()) {
                sum += d1.removeFirst();
            }
            if (!d2.isEmpty()) {
                sum += d2.removeFirst();
            }
            result.addLast(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            result.addLast(carry);
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