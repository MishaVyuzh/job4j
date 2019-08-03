package ru.job4j.loop;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 3.08.2019
 */

public class PrimeNumber {
    /**
     * Метод calc вычисляет количество простых чисел в диапазоне от 1 до finish.
     *
     * @param finish конечное число диапазона.
     * @return количесвто простых чисел.
     */

    public int calc(int finish) {
        int count = 0;
        boolean check;
        for (int i = 2; i <= finish; i++){
            check = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = true;
                    break;
                }
            }
            if (check) {
                continue;
            }
            count++;
        }
        return count;
    }
}
