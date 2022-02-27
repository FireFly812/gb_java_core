package com.company.lesson4;

/**
 * @author Sveta
 */
public class Abonent {
    private String surname;
    private String phone;

    public Abonent(String surname, String phone) {
        this.surname = surname;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }
}
