package com.company.lesson3;

import java.util.ArrayList;

/**
 * @author Sveta
 */
public class HomeWork3Task2 {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        System.out.println(appleBox);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));
        System.out.println(orangeBox);

        Box<Orange> orangeBox3 = new Box<>();
        Box<Apple> appleBox4 = new Box<>();
        System.out.println(appleBox4.compare(orangeBox3));

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.pourOver(appleBox);
        System.out.println(appleBox);
        System.out.println(appleBox1);

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.pourOver(orangeBox);
        System.out.println(orangeBox);
        System.out.println(orangeBox1);
    }
}
