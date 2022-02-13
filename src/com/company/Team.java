package com.company;

/**
 * @author Sveta
 */
public class Team {
    private String name;
    private String color;
    private Member[] members;
    private int points;

    public int getPoints() {
        return points;
    }

    Team(String name, String color, Member[] members) {
        this.name = name;
        this.color = color;
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team: " + name + "," + color + ".";
    }

    public Member[] getMember() {
        return members;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void printTeamMembers() {
        System.out.println(this);
        for (Member member : members) {
            System.out.println("  " + member);
        }
    }

    public void showResults() {
        System.out.println(this+" - "+points);
    }
}
