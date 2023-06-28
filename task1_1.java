// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;
public class task1_1 {

    static int summ(int n){
        if(n==0) return 0;
        return n + summ(n-1);
    }

    static int factor(int n){
        if(n==0) return 1;
        if(n==1) return 1;
            return n * factor(n-1);
    }
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите натуральное число (целое, > 0), n -> ");
        Integer number = iScanner.nextInt();
        System.out.printf("Ваше число - %d. \n", number);
        System.out.printf("Сумма чисел от 1 до %d равна %d. \n", number, summ(number));
        System.out.printf("Факториал числа %d равен %d. \n", number, factor(number));

        iScanner.close();
    }
}
