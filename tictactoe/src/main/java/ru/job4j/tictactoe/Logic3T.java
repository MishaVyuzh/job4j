package ru.job4j.tictactoe;

import java.util.function.Predicate;

class Logic3T {
    private final Figure3T[][] table;

    Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяем линию, заданную прараметрами, есть ли там нужные фишки.
     *
     * @param predicate подставляем метод из Figure.
     * @param startX    начало по Х проверяемой цепочки.
     * @param startY    начало по Y проверяемой цепочки.
     * @param deltaX    приращение по X.
     * @param deltaY    приращение по Y.
     * @return если линия заполнена одинаковыми фигурами - true.
     */
    private boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
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
     * Метод ищет заполненную линию.
     *
     * @return если линия найдена - true.
     */
    private boolean searchFill(Predicate<Figure3T> predicate) {
        boolean result = false;
        if (fillBy(predicate, 0, 0, 1, 1)
                || fillBy(predicate, 2, 0, -1, 1)) {
            result = true;
        }
        for (int pos = 0; pos < table.length; pos++) {
            if (fillBy(predicate, pos, 0, 0, 1)
                    || fillBy(predicate, 0, pos, 1, 0)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Крестика.
     *
     * @return если комбинация найдена - true.
     */
    boolean isWinnerX() {
        return searchFill(Figure3T::hasMarkX);
    }

    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Нолика.
     *
     * @return если комбинация найдена - true.
     */
    boolean isWinnerO() {
        return searchFill(Figure3T::hasMarkO);
    }

    /**
     * Метод проверяет есть ли пустые клетки для новых ходов.
     *
     * @return если поле заполнено - false.
     */
    boolean hasGap() {
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
