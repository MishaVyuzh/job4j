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

        for(int i = 0; i != size; i++) {
            for (int k = 0; k != size; k++){
                table[i][k] = (i + 1) * (k + 1);
            }
        }
        return table;
    }
}
