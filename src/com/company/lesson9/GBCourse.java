package com.company.lesson9;

import java.util.Objects;

public class GBCourse implements Course{
    private String name;

    public GBCourse(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GBCourse{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GBCourse gbCourse = (GBCourse) o;
        return Objects.equals(name, gbCourse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
