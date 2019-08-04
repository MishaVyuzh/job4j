package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class Square {
    /**
     * Метод calculate заполняет массив числами, возведенными в квадрат.
     *
     * @param bound размер массива.
     * @return заполненный массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int out = 0; out != bound; out++) {
            rst[out] = (out + 1) * (out + 1);
        }
        return rst;
    }
}
