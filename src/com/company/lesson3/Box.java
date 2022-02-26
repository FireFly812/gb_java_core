package com.company.lesson3;

import java.util.ArrayList;

/**
 * @author Sveta
 */
public class Box<T extends Fruit> {

    private ArrayList<T> fruitList;

    public float getBoxWeight() {
        float totalWeight = 0;
        for (Fruit item : fruitList) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public int getFruitCount() {
        return this.fruitList.size();
    }

    Box() {
        this.fruitList = new ArrayList<T>();
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void addFruit(T fruit) {
        this.fruitList.add(fruit);
    }

    public T extractFruit() {
        if (this.fruitList.size() == 0) {
            System.out.println("Нельзя ничего забрать из пустой коробки");
        } else {
            return this.fruitList.remove(0);
        }
        return null;
    }

    public void pourOver(Box<T> box) {
        for (int i = box.getFruitCount(); i > 0; i--) {
            this.addFruit(box.extractFruit());
        }
    }

    @Override
    public String toString() {
        if (fruitList.size() == 0) {
            return "Коробка пустая.";
        }
        return "Коробка: " + fruitList.get(0).getClass().getSimpleName() + " кол-во:" + getFruitCount() + " вес:"
                + getBoxWeight();
    }
}
