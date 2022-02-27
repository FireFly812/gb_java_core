package com.company.lesson4;

import java.util.ArrayList;

/**
 * @author Sveta
 */
public class PhoneBook {
    private ArrayList<Abonent> phoneBook;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
    }

    public ArrayList<String> getPhone(String surname) {
        ArrayList<String> phoneList = new ArrayList<>();
        for (Abonent item : phoneBook) {
            if (item.getSurname().equals(surname)) {
                phoneList.add(item.getPhone());
            }
        }
        return phoneList;
    }

    public String printPhones(String surname) {
        String result = "";
        boolean found = false;

        for (Abonent item : phoneBook) {
            if (item.getSurname().equals(surname)) {
                found = true;
                result += item.getPhone() + "; ";
            }
        }
        if (!found) {
            result = "Абонент не найден";
        }
        return result;
    }

    public void addAbonent(Abonent abonent) {
        phoneBook.add(abonent);
    }
}
