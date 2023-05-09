package ru.job4j.lambda;

import java.util.*;

public class IterableLambdaUsage {
    public static void main(String[] args) {
        String input = "Hello, my name is Sergey, and i am programmer.".replaceAll(" ", "");
        Map<Character, Integer> map = new HashMap<>();
        for (char symbol : input.toCharArray()) {
            map.merge(symbol, 1, (oldValue, newValue) -> oldValue + 1);
//            Integer temp = map.get(symbol);
//            Integer temp = map.getOrDefault(symbol, 0);
//            map.put(symbol, temp + 1);
//            if (temp != null) {
//                map.put(symbol, temp + 1);
//            } else {
//                map.put(symbol, 1);
//            }
        }
        int max = 0;
        char result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println("Most used: " + result + " " + max);
    }
}
