// Задание 1.
// Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class PhoneBook {
    private HashMap<String, List> contacts;

    public PhoneBook() {
        contacts = new HashMap<String, List>();
    }

    public void addPhoneNumber(String name, String number) { // Добавление нового номера телефона, если имя контакта уже существует, добавляется следующий номер
        List numbers;
        if (contacts.containsKey(name)) {
            numbers = contacts.get(name);
        } else {
            numbers = new ArrayList<>();
            contacts.put(name, numbers);
        }
        numbers.add(number);
    }

    public void printAllNumbers() { // Вывод телефонной книги в консоль
        for (String name : contacts.keySet()) {
            System.out.print(name + ":\t");
            List numbers = contacts.get(name);
            System.out.print(numbers);
            System.out.println();
        }
    }
}

public class task5_1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.print("----- ТЕЛЕФОННАЯ КНИГА -----\nНажмите [1] для добавления имени и номера телефона\nНажмите [2] для вывода телефонной книги\nНажмите [0] для выхода\n-> ");
            int choice = inputScanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите имя: ");
                String name = inputScanner.next();
                System.out.println("Введите номер телефона: ");
                String number = inputScanner.next();
                phoneBook.addPhoneNumber(name, number);
            }
            if (choice == 2) {
                phoneBook.printAllNumbers();
            }
            if (choice == 0) {
                System.out.println("До встречи!");
                break;
            }
        }
        inputScanner.close();
    }

}
