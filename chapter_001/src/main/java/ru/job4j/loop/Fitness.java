package ru.job4j.loop;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Fitness {
    /**
     * Метод calc вычисляет количество месяцев, которое необходимо Ивану, чтобы обогнать в тяге Николая.
     *
     * За 1 месяц у Ивана тяга увеличивается в 3 раза, у Николая в 2 раза
     *
     * @param ivan сила тяги Ивана.
     * @param nikolai сила тяги Николая.
     * @return количесвто месяцев.
     */
    public int calc(int ivan, int nikolai) {
        int month = 0;

        while(ivan < nikolai) {
            ivan *= 3;
            nikolai *= 2;
            month++;
        }
        return month;
    }
}
