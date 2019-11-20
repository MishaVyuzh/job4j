package ru.job4j.loop;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 3.08.2019
 */

public class Mortgage {
    /**
     * Метод year вычисляет количество лет необходимых для погашения кредита.
     * Кредитная сумма перерасчитывается каждый год по процентной ставке.
     *
     * @param amount  сумма выданная по кредиту.
     * @param monthly ежемесячный платеж.
     * @param percent процентная ставка по кредиту.
     * @return количесвто лет для погашения кредита.
     */
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double all = amount + amount * percent / 100;
        System.out.println(all);

        if (all <= monthly * 12) {
            year = 1;
        } else {
            year = 1;
            while (all > monthly * 12) {
                all -= monthly * 12;
                year++;
            }
        }


        return year;
    }
}
