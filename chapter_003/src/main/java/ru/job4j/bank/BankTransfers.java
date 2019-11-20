package ru.job4j.bank;

import java.util.*;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.11.2019
 */
public class BankTransfers {
    private Map<User, List<Account>> listBankAccount = new HashMap<>();

    /**
     * Метод добавляет пользователя в коллекцию Map.
     */
    public void addUser(User user) {
        this.listBankAccount.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из коллекцию Map.
     */
    public void deleteUser(User user) {
        this.listBankAccount.remove(user);
    }

    /**
     * Метод добавляет счёт пользователю.
     *
     * @param passport паспорт пользователя.
     * @param account счёт, который нужно добавить.
     */
    public void addAccountToUser(String passport, Account account) {
        listBankAccount.get(getUserByPassport(passport)).add(account);
    }

    /**
     * Метод удаляет счёт пользователю.
     *
     * @param passport паспорт пользователя.
     * @param account счёт, который нужно добавить.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        listBankAccount.get(getUserByPassport(passport)).remove(account);
    }

    /**
     * Метод получает список счетов пользователя.
     *
     * @param passport паспорт пользователя.
     * @return List список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        return listBankAccount.get(getUserByPassport(passport));
    }

    /**
     * Метод получает счёт по паспорту пользователя и рекви зитам.
     *
     * @param passport паспорт пользователя счёта.
     * @param requisite реквизиты счёта.
     * @return найденный счёт.
     */
    public Account getAccountByRequisite(String passport, String requisite) {
        List<Account> accounts = getUserAccounts(passport);
        return accounts.stream().filter(
                account -> account.getRequisites().equals(requisite)
        )
                .findFirst().orElse(new Account());
    }

    /**
     * Метод получает User по паспорту пользователя и рекви зитам.
     *
     * @param passport паспорт пользователя счёта.
     * @return найденный User.
     */
    private User getUserByPassport(String passport) {
        return listBankAccount.keySet().stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst()
                .get();
    }

    /**
     * Метод перечисляет деньги с одного счёта на другой счёт.
     *
     * @param srcPassport паспорт пользователя, который отправляет деньги.
     * @param srcRequisite счёт, с которого списывают деньги.
     * @param destPassport паспорт пользователя, который получает деньги.
     * @param dstRequisite счёт, на который поступают деньги.
     * @param amount сумма перевода.
     * @return true, если перевод успешен или false, если данные неверны или если не хватает денег на счёте srcRequisite.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean report = false;
        Account srcAccount = getAccountByRequisite(srcPassport, srcRequisite);
        Account destAccount = getAccountByRequisite(destPassport, dstRequisite);
        if (amount > 0) {
            if (srcAccount != null && destAccount != null && destAccount.getValues() >= amount) {
                srcAccount.setValues(srcAccount.getValues() - amount);
                destAccount.setValues(destAccount.getValues() + amount);
                report = true;
            }
        }
        return report;
    }
}
