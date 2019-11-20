package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class Matrix {
    /**
     * Метод multiple по заданному размеру записывает таблицу умножения.
     *
     * @param size размер матрицы.
     * @return таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int out = 0; out != size; out++) {
            for (int in = 0; in != size; in++) {
                table[out][in] = (out + 1) * (in + 1);
            }
        }
        return table;
    }
}
