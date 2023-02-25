package com.company.lesson9;

import java.util.List;

public class GBStudent implements Student {

    private String name;
    private List<Course> courseList;

    public GBStudent(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public String toString() {
        return "GBStudent{" +
                "name='" + name + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
