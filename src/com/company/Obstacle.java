package com.company;

import java.util.Random;

/**
 * @author Sveta
 */
public class Obstacle {
    private String name;
    private int strength;
    private int endurance;
    private int agility;
    Random r = new Random();

    public String getName() {
        return name;
    }

    Obstacle(String name, int strength, int endurance, int agility) {
        this.name = name;
        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
    }

    public boolean tryIt(Member member) {
         if (member.getStrength() >= strength && member.getEndurance() >= endurance && member.getAgility() >= agility)
            return true;
        else if (member.getLuck() >= r.nextInt(100)) {
            System.out.print("Lucky!!!->");
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return "Obstacle: " + name + ":" + "S" + strength + "/" + "E" + endurance + "/" + "A" + agility + ".";
    }
}
