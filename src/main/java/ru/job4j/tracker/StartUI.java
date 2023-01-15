package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        String currentDateTime = item.getDateTime();
        System.out.println(currentDateTime);
    }
}
