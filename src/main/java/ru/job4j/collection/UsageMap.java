package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("@mail.ru", "Sergey");
        map.put("@mail.ru", "Sergey");
        map.put("@outlook.com", "Petr");
        map.put("@outlook.com", "Petr");
        map.put("@gmail.ru", "Alex");
        map.put("@gmail.ru", "Alex");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " - " + value);
        }
    }
}
