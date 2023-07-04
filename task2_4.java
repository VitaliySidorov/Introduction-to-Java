// 4) Реализовать простой калькулятор. Добавить логирование.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

public class task2_4 {
    static Scanner iScanner = new Scanner(System.in);
    private static FileWriter writer;

    public static void logStep(String s) throws IOException {
        writer.write(new Timestamp(System.currentTimeMillis()) + "\t" + s + "\n");
    }

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
        try{
            System.out.print("Выберите операцию ( +, -, *, / ): ");
            char operation = iScanner.next().charAt(0);
            logStep("Пользователь выбрал операцию ->\t" + operation);
            int result;
                switch (operation) {
                    case '+':
                        result = n + m;
                        System.out.printf("%d + %d = %d\n", n, m, result);
                        logStep("Результат операции ->\t" + result);
                        break;
                    case '-':
                        result = n - m;
                        System.out.printf("%d - %d = %d\n", n, m, result);
                        logStep("Результат операции ->\t" + result);
                        break;
                    case '*':
                        result = n * m;
                        System.out.printf("%d * %d = %d\n", n, m, result);
                        logStep("Результат операции ->\t" + result);
                        break;
                    case '/':
                        if (m == 0) {
                            System.out.println("Ошибка! Делить на 0 нельзя!");
                            logStep("Ошибка деления на 0.");
                        }
                        else if (n % m == 0) {
                            result = n / m;
                            System.out.printf("%d / %d = %d\n", n, m, result);
                            logStep("Результат операции ->\t" + result);
                        }
                        else {
                            Float fresult = (float) n / m;
                            System.out.printf("%d / %d = %s\n", n, m, fresult);
                            logStep("Результат операции ->\t" + fresult);
                        }
                        break;
                    
                    case 0:
                        break;
                    default:
                        System.out.println("Операция не распознана. Повторите ввод.");
                        logStep("Ошибочный ввод");
                        Calculating(n, m);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File log = new File("log_calculating.txt");
            log.createNewFile();
            writer = new FileWriter(log);

            int numberN = nextInt(1);
            logStep("Пользователь ввел число n ->\t" + numberN);
            int numberM = nextInt(2);
            logStep("Пользователь ввел число n ->\t" + numberM);

            Calculating(numberN, numberM);
            
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