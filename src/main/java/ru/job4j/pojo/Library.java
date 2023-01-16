package ru.job4j.pojo;

import java.sql.SQLOutput;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 300);
        Book second = new Book("Algorithms", 350);
        Book third = new Book("The Self-Taught Programmer", 400);
        Book fourth = new Book("Code", 200);
        Book[] books = {first, second, third, fourth};
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + book.getAmount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            if (book.getTitle().equals("Clean code")) {
                System.out.println(book.getTitle() + " - " + book.getAmount());
            }
        }
    }
}
