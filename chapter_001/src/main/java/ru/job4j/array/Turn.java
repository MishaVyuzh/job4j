package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class Turn {
    /**
     * Метод back переворачивает массив задом наперед.
     *
     * @param array входящий массив.
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {
        int tmp;
        for (int index = 0; index != array.length / 2; index++) {
            tmp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = tmp;
        }
        return array;
    }
}
