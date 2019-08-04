package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class Check {
    /**
     * Метод mono проверяет, что все элементы в массиве являются true или false.
     * Возвращает true только если все элементы одинаковые (либо все true, либо все false), иначе false.
     *
     * @param data входящий массив.
     * @return результат.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index != data.length; index++) {
            if (data[0] == data[index]) {
            }
            else {
                result = false;
            }
        }
        return result;
    }
}
