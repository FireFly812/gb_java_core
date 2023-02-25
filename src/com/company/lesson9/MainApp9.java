package com.company.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp9 {

    public static void main(String[] args) {
        List<Student> studentList = getStudentList();
        List<Course> courseList = getGBCourse();

        //task1
        List<Course> func1 = getDistinctCourses(studentList.subList(2, 5));
        func1.forEach(System.out::println);

        //task2
        List<Student> func2 = getMostEducationStudent(studentList);
        func2.forEach(System.out::println);

        //task3
        List<Student> func3 = getStudentListByCourse(studentList, courseList.get(2));
        func3.forEach(System.out::println);
    }

    public static List<Course> getDistinctCourses(List<Student> studentList) {
        return studentList.stream().flatMap(student -> student.getAllCourses().stream())
                .distinct().collect(Collectors.toList());
    }

    public static List<Student> getMostEducationStudent(List<Student> studentList) {
        return studentList.stream().sorted((s1, s2) -> s2.getAllCourses().size() - s1.getAllCourses().size()).limit(3).collect(Collectors.toList());
    }

    public static List<Student> getStudentListByCourse(List<Student> studentList, Course course) {
        return studentList.stream().filter(student -> student.getAllCourses().contains(course)).collect(Collectors.toList());
    }


    public static List<Student> getStudentList() {
        List<Course> courseList = getGBCourse();
        List<Student> studentList = new ArrayList<>();
        studentList.add(new GBStudent("Студент1", courseList.subList(0, 4)));
        studentList.add(new GBStudent("Студент2", courseList.subList(0, 2)));
        studentList.add(new GBStudent("Студент3", courseList.subList(1, 2)));
        studentList.add(new GBStudent("Студент4", courseList.subList(3, 5)));
        studentList.add(new GBStudent("Студент5", courseList.subList(4, 5)));
        return studentList;
    }

    public static List<Course> getGBCourse() {
        List<Course> gbCoursesList = new ArrayList<>();
        gbCoursesList.add(new GBCourse("Курс1"));
        gbCoursesList.add(new GBCourse("Курс2"));
        gbCoursesList.add(new GBCourse("Курс3"));
        gbCoursesList.add(new GBCourse("Курс4"));
        gbCoursesList.add(new GBCourse("Курс5"));
        return gbCoursesList;
    }
}
