package ru.job4j.condition;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class SqMax {
    /**
     * Вывод максимума из 2-х значений.
     * @param first первое значение.
     * @param second второе значение.
     * @param third второе значение.
     * @param forth второе значение.
     * @return максимум.
     */
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
            }
        } else if (second > third) {
            if (second > forth) {
                result = second;
            }
        } else if (third > forth) {
            result = third;
        }
        return result;
    }
}