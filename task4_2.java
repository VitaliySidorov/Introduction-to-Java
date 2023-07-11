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

        // System.out.println("Произведение: " + mult(d1, d2));

    }

    // public static Deque<Integer> mult(Deque<Integer> d1, Deque<Integer> d2) {
    //     Deque<Integer> result = new ArrayDeque<>();
    //     int carry = 0, mult = 1, digit=0;
    //     for (int i = 0; i < d2.size(); i++) {
    //         digit = (int) Math.pow(10, i);
    //         mult *= d1.removeFirst() * digit;
    //         System.out.println(mult);
            
    //         for (int j = 0; j < d1.size(); j++) {
    //             digit = (int) Math.pow(10, j);
    //             mult *= d2.removeFirst() * digit;
    //             System.out.println(mult);
    //             result.addLast((mult % 10) + carry);
    //             System.out.println(result);
    //             carry = mult / 10;
    //         }
            
            
    //         result.addLast(mult);
    //     }
    //     if (carry != 0) {
    //         result.addLast(carry);
    //     }
    
    // // int carry = 0;
    // // while (!d1.isEmpty() && !d2.isEmpty()) {
    // // int mult = 1;
    // // if (!d1.isEmpty()) {
    // // int digit1 = 1;
    // // mult *= d1.removeFirst() * digit1;
    // // System.out.println(mult);
    // // digit1 *=10;
    // // }
    // // if (!d2.isEmpty()) {
    // // int digit2 = 1;
    // // mult *= d2.removeFirst() * digit2;
    // // System.out.println(mult);
    // // digit2 *=10;
    // // }
    // // result.addLast(mult);
    // // // result.addLast((mult % 10) + carry);
    // // System.out.println(result);
    // // // carry = mult / 10;
    // // System.out.println(carry);
    // // }
    // // if (carry != 0) {
    // // result.addLast(carry);
    // // }
    // return result;

    // }


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