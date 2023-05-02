package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель для банковской системы.
 * В системе можно регистрировать пользователя и удалять его
 * Добавлять пользователю один или несколько банковских счетов
 * Переводить деньги с одного счёта на другой
 * @author Sergey Vasenev
 */
public class BankService {
    /**
     * Хранение всех пользователей с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления пользователя в систему.
     * В методе реализована проверка, что такого пользователя ещё нет в системе
     * если он есть, то пользователь не добавляется.
     * @param user принимает на вход пользователя
     * по умолчанию к пользователю добавляется пустой список ArrayList.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяет удалить пользователя из системы.
     * В методе реализована проверка, что пользователь есть в системе.
     * Пользователь используется в качестве ключа для удаления.
     * @param passport уникальный идентификатор пользователя, которого нужно удалить
     * @return true - если пользователь удалён, false - если пользователь не найден.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод позволяет добавить новый счёт к пользователю.
     * Производится поиск пользователя по паспарту с помощью метода {@link #findByPassport(String)}
     * В методе должна быть проверка, что такого счёта у пользователя ещё нет.
     * @param passport принимает на вход уникальный идентификатор пользователя
     * @param account новый счёт пользователя, который необходимо добавить.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользователя в системе
     * @param passport уникальный идентификатор пользователя
     * @return возвращает пользователя, если он есть в системе, если нет - вернёт null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет найти счёт пользователя по реквезитам.
     * Производится поиск пользователя по паспарту с помощью метода {@link #findByPassport(String)}
     * Далее получает список счетов пользователя, и в этом списке находит нужный счёт.
     * В методе должна быть проверка, что метод {@link #findByPassport(String)} не равен null.
     * @param passport уникальный индетификатор пользователя
     * @param requisite счёт пользователя, который необходимо найти.
     * @return возвращает аккаунт пользователя.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> requisite.equals(a.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет перечислить деньги с одного счёта на другой счёт.
     * @param srcPassport паспорт пользователя, со счёта которого переводят деньги
     * @param srcRequisite пользовательский счёт, с которого переводят деньги
     * @param destPassport паспорт пользователя, на счёт которого переводят деньги
     * @param destRequisite пользовательский счёт, на который переводят деньги
     * @param amount сумма перечисления
     * @return true - если перевод произошёл. false - Если счёт не найден
     * или не хватает денег на счёте srcAccount.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            rsl = true;
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * Метод необходим для тестов.
     * @param user пользователь
     * @return список аккаунов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
