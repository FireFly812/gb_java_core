package com.company.lesson2;

/**
 * @author Sveta
 */
public class MyArrayDataException extends NumberFormatException {
    private int i;
    private int j;

    MyArrayDataException(int i, int j) {
        super();
        this.i = i;
        this.j = j;

    }

    @Override
    public String toString() {
        return "Неверный формат ячейки " + i + "-" + j;
    }
}
