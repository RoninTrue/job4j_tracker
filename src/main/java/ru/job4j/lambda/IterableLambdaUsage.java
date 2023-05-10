package ru.job4j.lambda;

import java.util.*;

public class IterableLambdaUsage {
    public static void main(String[] args) {
        String input = "Hello World".replaceAll(" ", "").toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (char symbol : input.toCharArray()) {
            map.merge(symbol, 1, (oldValue, newValue) -> oldValue + 1);
        }
        int max = 0;
        char result = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println(result + " " + max);
    }
}
