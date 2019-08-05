package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 5.08.2019
 */

public class MatrixCheck {
    /**
     * Метод mono проверяет диагонали в квадратной матрице на совпадение либо true, либо false.
     *
     * @param data входящий массив.
     * @return совпадения или несовпадения.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i] || data[0][0] != data[data.length - 1 - i][i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
