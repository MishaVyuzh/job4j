package ru.job4j.condition;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * Вывод максимума из 2-х значений.
     * @param left первое значение.
     * @param right второе значение.
     * @return максимум.
     */
    public int max(int left, int right) {
        return left > right ? left : right;
    }
}