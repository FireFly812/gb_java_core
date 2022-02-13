package com.company;

/**
 * @author Sveta
 */
public class Member {

    private String name;
    private int strength;
    private int endurance;
    private int agility;
    private int luck;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getAgility() {
        return agility;
    }

    public int getLuck() {
        return luck;
    }

    Member(String name, int strength, int endurance, int agility, int luck) {
        this.name = name;
        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
        this.luck = luck;
    }

    @Override
    public String toString() {
        return "Member: " + name + ":" + "S" + strength + "/" + "E" + endurance + "/" + "A" + agility + "/" + "L" + luck
                + ".";
    }
}

