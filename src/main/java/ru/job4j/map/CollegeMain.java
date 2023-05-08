package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CollegeMain {
    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student.get());
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по предмету: " + english.get().score());
    }

}
