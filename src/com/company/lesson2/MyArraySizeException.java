package com.company.lesson2;

/**
 * @author Sveta
 */
public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    MyArraySizeException(String error) {
        super(error);
    }
}
