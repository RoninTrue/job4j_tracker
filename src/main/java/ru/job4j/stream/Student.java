package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int scope;
    private String surname;

    public Student(int scope, String surname) {
        this.scope = scope;
        this.surname = surname;
    }

    public int getScope() {
        return scope;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, surname);
    }
}
