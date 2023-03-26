package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных. Класс описывает модель банковского счёта.
 */
public class Account {
    /**
     * поле описывает реквизит банковского счёта
     */
    private String requisite;
    /**
     * поле описывает баланс банковского счёта
     */
    private double balance;

    /**
     * Конструктор класса. Инициализирует поля: реквизит и баланс
     * @param requisite реквизит банковского счёта
     * @param balance баланс банковского счёта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
