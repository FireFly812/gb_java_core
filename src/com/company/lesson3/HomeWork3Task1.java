package com.company.lesson3;

import java.util.Arrays;

/**
 * @author Sveta
 */
public class HomeWork3Task1 {

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(arr));
        changeIterMatrix(1, 2, arr);
        System.out.println(Arrays.toString(arr));

        String[] arr2 = { "1", "2", "3", "4", "5" };
        System.out.println(Arrays.toString(arr));
        changeIterMatrix(1, 2, arr);
        System.out.println(Arrays.toString(arr));

    }

    public static <T> void changeIterMatrix(int it1, int it2, T[] arr) {
        T a = arr[it1];
        arr[it1] = arr[it2];
        arr[it2] = a;
    }
}
