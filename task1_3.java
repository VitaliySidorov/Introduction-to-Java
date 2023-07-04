// 3) Реализовать простой калькулятор

import java.util.Scanner;

public class task1_3 {
    static Scanner iScanner = new Scanner(System.in);

    public static int nextInt(int a){
        System.out.printf("Введите %d-е число: ", a);
        int number;
        if(iScanner.hasNextInt()){
            number = iScanner.nextInt();
        } else {
            System.out.println("Неверный ввод числа. Попробуйте еще раз.");
            iScanner.next();
            number = nextInt(a);
        }
        return number;
    }

    public static void Calculating(int n, int m){
        System.out.print("Выберите операцию ( +, -, *, / ): ");
        char operation = iScanner.next().charAt(0);
            switch (operation) {
                case '+':
                    System.out.printf("%d + %d = %d\n", n, m, n + m);
                    break;
                case '-':
                    System.out.printf("%d - %d = %d\n", n, m, n - m);
                    break;
                case '*':
                    System.out.printf("%d * %d = %d\n", n, m, n * m);
                    break;
                case '/':
                    if (m == 0) System.out.println("Ошибка! Делить на 0 нельзя!");
                    else if (n % m == 0) System.out.printf("%d / %d = %d\n", n, m, n / m);
                    else {
                        System.out.printf("%d / %d = %s\n", n, m, (float) n / m);
                    }
                    break;
                
                case 0:
                    break;
                default:
                    System.out.println("Операция не распознана. Повторите ввод.");
                    Calculating(n, m);
            }
    }

    public static void main(String[] args) {
        int numberN = nextInt(1);
        int numberM = nextInt(2);
        Calculating(numberN, numberM);
            
        iScanner.close();
    }
    
}