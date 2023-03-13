package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double temp = 0;
        double gpa = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp++;
                gpa += subject.score();
            }
        }
        return gpa / temp;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double gpa = 0D;
            double size = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                gpa += subject.score();
            }
            list.add(new Label(pupil.name(), gpa / size));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), score + subject.score());
            }

        }
        double size = pupils.size();
        for (String subject : map.keySet()) {
            list.add(new Label(subject, map.get(subject) / size));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            list.add(new Label(pupil.name(), sum));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), score + subject.score());
            }

        }
        for (String subject : map.keySet()) {
            list.add(new Label(subject, map.get(subject)));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}
