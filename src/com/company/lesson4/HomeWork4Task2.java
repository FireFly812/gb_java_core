package com.company.lesson4;

import java.util.ArrayList;

/**
 * @author Sveta
 */
public class HomeWork4Task2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Abonent abonent = new Abonent("Иванов", "12345");
        Abonent abonent1 = new Abonent("Иванов", "123456");
        Abonent abonent2 = new Abonent("Иванов", "1234567");
        Abonent abonent3 = new Abonent("Петров", "12345678");

        phoneBook.addAbonent(abonent);
        phoneBook.addAbonent(abonent1);
        phoneBook.addAbonent(abonent2);
        phoneBook.addAbonent(abonent3);

        System.out.println(phoneBook.getPhone("Иванов"));
        System.out.println(phoneBook.getPhone("Петров"));
        System.out.println(phoneBook.getPhone("Сидоров"));

        System.out.println(phoneBook.printPhones("Иванов"));
        System.out.println(phoneBook.printPhones("Петров"));
        System.out.println(phoneBook.printPhones("Сидоров"));


    }
}
