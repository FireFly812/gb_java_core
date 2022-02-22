package com.company.lesson3;

/**
 * @author Sveta
 */
public abstract class Fruit {
    private float weight;

    Fruit(float weight){
        this.weight = weight;
    }

    public float getWeight(){
        return weight;
    }
}
