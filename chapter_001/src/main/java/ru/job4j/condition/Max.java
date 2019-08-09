package ru.job4j.condition;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 9.08.2019
 */

public class Max {
    /**
     * Вывод максимума из 2-х значений.
     * @param first первое значение.
     * @param second второе значение.
     * @return максимум.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Вывод максимума из 3-х значений.
     * @param first первое значение.
     * @param second второе значение.
     * @param third третье значение.
     * @return максимум.
     */
    public int max(int first, int second, int third) {
        int twoMax = max(first, second);
        return twoMax > third ? twoMax : third;
    }
    /**
     * Вывод максимума из 4-х значений.
     * @param first первое значение.
     * @param second второе значение.
     * @param third третье значение.
     * @param fourth четвертое значение.
     * @return максимум.
     */
    public int max(int first, int second, int third, int fourth) {
        int threeMax = max(first, second, third);
        return threeMax > fourth ? threeMax : fourth;
    }
}