package ru.job4j.oop.nested.inner;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("Марка", "Модель");
        Car.Transmission transmission = car.new Transmission();
        Car.Brakes brakes = car.new Brakes();
        car.startEngine();
        transmission.accelerate();
        brakes.brake();
    }
}
