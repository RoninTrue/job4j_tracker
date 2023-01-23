package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Начал движение");
    }

    @Override
    public void passengers(int number) {
        System.out.println("кол-во пассажиров: " + number);
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 10;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.refuel(10);
    }
}
