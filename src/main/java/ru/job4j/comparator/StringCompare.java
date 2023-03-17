package ru.job4j.comparator;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl;
        int count = Integer.compare(left.length(), right.length());
        if (count == 0 || count < 0) {
            for (int index = 0; index < left.length(); index++) {
                rsl = Character.compare(left.charAt(index), right.charAt(index));
                if (rsl != 0) {
                    return rsl;
                }
            }
        } else {
            for (int index = 0; index < right.length(); index++) {
                rsl = Character.compare(left.charAt(index), right.charAt(index));
                if (rsl != 0) {
                    return rsl;
                }
            }
        }
        return count;
    }
}
