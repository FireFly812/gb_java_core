package com.company;

/**
 * @author Sveta
 */
public class Course {

    private Obstacle[] obstacles;

    Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void printObstacles() {
        System.out.println(this);
        for (Obstacle obstacle : obstacles) {
            System.out.println("  " + obstacle);
        }
    }

    public void doIt(Team team) {
        int points = 0;
        System.out.println("Начала " + team);
        for (Member member : team.getMember()) {
            System.out.println("  " + member.getName() + " начал проходить");
            for (Obstacle obstacle : obstacles) {
                boolean result = obstacle.tryIt(member);
                System.out.println("    " + obstacle.getName() + " - " + (result ? "прошел" : "завалил"));
                if (result) {
                    points += 1;
                } else
                    break;
            }

        }
        team.addPoints(points);
    }
}
