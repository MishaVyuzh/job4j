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
        FindLoop find = new FindLoop();
        int el = Integer.MAX_VALUE;
        int start = 0;
        int finish = data.length - 1;
        int min;
        int tmp;

        for (int i = 0; i != data.length; i++) {
            if (data[i] < el) {
                el = data[i];
            }
        }
        for (int index = 0; index != data.length; index++) {
            min = -1;
            while (min == -1) {
                min = find.indexOfLimit(data, el, start, finish);
                el++;
            }
            tmp = data[index];
            data[index] = data[min];
            data[min] = tmp;

            el = data[index];
            start++;
        }
        return data;
    }
}
