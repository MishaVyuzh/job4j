package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяем линию, заданную прараметрами, есть ли там нужные фишки.
     *
     * @param predicate подставляем метод из Figure.
     * @param startX начало по Х проверяемой цепочки.
     * @param startY начало по Y проверяемой цепочки.
     * @param deltaX приращение по X.
     * @param deltaY приращение по Y.
     * @return если линия заполнена одинаковыми фигурами - true.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Крестика.
     *
     * @return если комбинация найдена - true.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, 2, 0, -1, 1);
    }

    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Нолика.
     *
     * @return если комбинация найдена - true.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, 2, 0, -1, 1);
    }

    /**
     * Метод проверяет есть ли пустые клетки для новых ходов.
     *
     * @return если поле заполнено - false.
     */
    public boolean hasGap() {
        boolean result = false;
        for (Figure3T[] figure : table) {
            for (int j = 0; j < table.length; j++) {
                if (!figure[j].hasMarkO() && !figure[j].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
