package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных.
 * Класс описывает пользователя при регистрации в банковской системе.
 */
public class User {
    /**
     * Поле описывает паспорт пользователя.
     * Это поле уникально идентифицирует пользователя.
     */
    private String passport;
    /**
     * Поле описывает имя пользователя
     */
    private String username;

    /**
     * Конструктор класса User. Создание объекта и инициализация полей
     * @param passport строковое значение паспорт.
     * @param username строковое значение имяПользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
