package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTransfersTest {
    private User first = new User("Ivan", "123");
    private User second = new User("Alex", "555");
    private User third = new User("Marta", "300");
    private Account ivan = new Account(1000D, "Ivan123");
    private Account alex = new Account(500D, "Alex555");
    private Account marta = new Account(700D, "Marta300");

    @Test
    public void whenAddUserAndAddAccountToUser() {
        BankTransfers bank = new BankTransfers();
        bank.addUser(first);
        bank.addAccountToUser("123", ivan);
        double result = bank.getUserAccounts("123").get(0).getValues();
        assertThat(result, is(1000D));
    }

    @Test
    public void whenTransferMoneyIsSuccess() {
        BankTransfers bank = new BankTransfers();
        bank.addUser(first);
        bank.addUser(second);
        bank.addAccountToUser("123", ivan);
        bank.addAccountToUser("555", alex);
        boolean result = bank.transferMoney("123", "Ivan123", "555", "Alex555", 100D);
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferMoney300FromIvanToMartaThenIvanValues700() {
        BankTransfers bank = new BankTransfers();
        bank.addUser(first);
        bank.addUser(third);
        bank.addAccountToUser("123", ivan);
        bank.addAccountToUser("300", marta);
        bank.transferMoney("123", "Ivan123", "300", "Marta300", 300D);
        assertThat(ivan.getValues(), is(700D));
    }
}
