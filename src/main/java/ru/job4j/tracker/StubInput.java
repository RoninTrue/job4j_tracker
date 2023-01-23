package ru.job4j.tracker;

public class StubInput implements Input {

    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(int question) {
        return 0;
    }
}
