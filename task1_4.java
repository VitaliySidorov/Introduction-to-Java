// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

import java.util.Scanner;


public class task1_4 {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите уравнение вида: q + w = e, где q, w, e >= 0 -> ");
        String equation = iScanner.nextLine();
        
        String[] elements = equation.split(("\\s*[+=]\\s*")); 
        
        int q = 0, w = 0, e = 0;
                
        int valueQ = elements[0].indexOf('?');
        q = Integer.parseInt(elements[0].replace('?', '0'));
        
        int valueW = elements[1].indexOf('?');
        w = Integer.parseInt(elements[1].replace('?', '0'));
        
        e = Integer.parseInt(elements[2]);
         
        int valueA = e - (q + w);
        
        if (valueA < 0) {
            System.out.println("Решений нет.\n");
        }
        else {
            if (valueQ == 1 && valueW == 0) {
                q = q + valueA % 10;
                w = (valueA / 10) * 10 + w;
                System.out.printf("%d + %d = %d\n", q, w, e);
            }
            else if (valueQ == 0 && valueW == 1) {
                w = w + valueA % 10;
                q = (valueA / 10) * 10 + q;
                System.out.printf("%d + %d = %d\n", q, w, e);
            }
        }
        
        iScanner.close();
    }
}
