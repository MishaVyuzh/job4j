package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 5.08.2019
 */

public class ArrayDuplicate {
    /**
     * Метод remove удаляет дубликаты строк.
     *
     * @param array входящий массив строк.
     * @return отсортированный массив.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
