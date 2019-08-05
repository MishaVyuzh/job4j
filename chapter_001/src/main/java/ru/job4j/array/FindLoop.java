package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class FindLoop {
    /**
     * Метод indexOf выполняет поиск числа в массиве.
     *
     * @param data входящий массив.
     * @param el   число, которое нужно найти.
     * @return индекс найденного числа.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод indexOfLimit выполняет поиск числа в заданном диапазоне массива.
     *
     * @param data   входящий массив.
     * @param el     число, которое нужно найти.
     * @param start  начальное число диапазона.
     * @param finish конечное число диапазона.
     * @return индекс найденного числа.
     */
    public int indexOfLimit(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index <= finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод sort выполняет сортировку массива выбором.
     *
     * @param data входящий массив.
     * @return отсортированный массив.
     */
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int k = i; k < data.length; k++) {
                if (data[k] < min) {
                    min = data[k];
                }
            }
            int index = this.indexOfLimit(data, min, i, data.length - 1);
            int tmp = data[i];
            data[i] = data[index];
            data[index] = tmp;
        }
        return data;
    }
}
