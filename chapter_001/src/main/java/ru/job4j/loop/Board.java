package ru.job4j.loop;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    /**
     * Метод, который формирует доску из Х и пробелов в виде строки без вывода в консоль.
     *
     * @param width ширина доски.
     * @param height высота доски.
     * @return строки, представляющей данные последовательности.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int out = 0; out < height; out++) {
            for (int in = 0; in < width; in++) {
                if ((out + in) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
