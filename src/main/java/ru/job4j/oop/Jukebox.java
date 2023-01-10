package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String str = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(str);
    }

    public static void main(String[] args) {
        Jukebox machine = new Jukebox();
        machine.music(2);
    }
}
