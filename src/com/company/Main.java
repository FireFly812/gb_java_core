package com.company;

import java.util.Random;

/**
 * HomeWorkLesson1
 * @author Sveta
 * @version 13.02.2022
 */
public class Main {

    public static void main(String[] args) {
        Team team1 = createTeam("Команда 1", "синие");
        team1.printTeamMembers();
        Team team2 = createTeam("Команда 2", "красные");
        team2.printTeamMembers();

        Course course = createCourse();
        course.printObstacles();

        course.doIt(team1);
        course.doIt(team2);

        team1.showResults(); // Показываем результаты команды 1
        team2.showResults(); // Показываем результаты команды 2
        if (team1.getPoints() > team2.getPoints()) {
            System.out.println("Победила " + team1);
        } else if (team1.getPoints() == team2.getPoints()) {
            System.out.println("Ничья");
        } else {
            System.out.println("Победила " + team2);
        }

    }

    public static Team createTeam(String name, String color) {
        Member[] memberArray = new Member[4];
        for (int i = 0, j = 1; i < 4; i++, j++) {
            memberArray[i] = new Member(color + j, generateSkillLevel(), generateSkillLevel(),
                    generateSkillLevel(), generateSkillLevel());

        }
        return new Team(name, color, memberArray);
    }

    public static Course createCourse() {
        Obstacle[] obstacleArray = new Obstacle[5];
        obstacleArray[0] = new Obstacle("Стрельба из лука", 20, 20, 50);
        obstacleArray[1] = new Obstacle("Перетягивание каната", 50, 20, 10);
        obstacleArray[2] = new Obstacle("Забраться по веревочной лестнице", 30, 30, 30);
        obstacleArray[3] = new Obstacle("Переплыть реку", 30, 50, 10);
        obstacleArray[4] = new Obstacle("Выиграть в рулетку", 101, 101, 101);
        return new Course(obstacleArray);
    }

    public static int generateSkillLevel() {
        Random r = new Random();
        return r.nextInt(90) + 11;
    }
}
