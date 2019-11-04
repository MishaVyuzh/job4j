package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.11.2019
 */
public class Account {
    private double values;
    private String requisites;

    public Account() {
    }

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public String getRequisites() {
        return requisites;
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
        return Double.compare(account.values, values) == 0 && Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, requisites);
    }
}
