package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Пупкин Василий Петрович.");
        student.setGroup(123);
        student.setCreated(new Date());
        System.out.println(student.getFullName() + " Студент группы № " + student.getGroup()
                + " Дата поступления: " + student.getCreated());
    }
}
