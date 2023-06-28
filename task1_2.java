// 2) Вывести все простые числа от 1 до 1000

public class task1_2 {
    public static void main(String[] args) {
        int number = 1000;
        for (int i = 2; i <= number; i++){
            int count = 0;
            for (int j = 2; j <= i; j++){
                if (i % j == 0) count ++;
                if (count > 1) break;
                
            }
            if (count == 1) System.out.printf("%d\t", i);
        }
        System.out.println();
    }
}
