package ru.job4j.condition;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MultiMax {
    /**
     * Вывод максимума из 3-х значений.
     * @param first первое значение.
     * @param second второе значение.
     * @param third третье значение.
     * @return максимума.
     */
    public int max(int first, int second, int third) {
        if (first >= second && first >= third) {
            return first;
        } else if (second >= first && second >= third) {
            return second;
        } else {
            return third;
        }
    }
}