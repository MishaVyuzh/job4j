package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Создаем объект треугольник.
        Triangle triangle = new Triangle();
        // Вычисляем площадь.
        double result = triangle.area(3, 1, 5, 1, 4, 0);
        // Задаем ожидаемый результат.
        double expected = 1;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}
