package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScope(), left.getScope()))
                .takeWhile(st -> st.getScope() > bound)
                .collect(Collectors.toList());
    }
}
