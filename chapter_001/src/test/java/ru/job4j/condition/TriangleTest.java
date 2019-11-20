package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 9.08.2019
 */

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point first = new Point(3, 1);
        Point second = new Point(5, 1);
        Point third = new Point(4, 0);
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        double expected = 1;
        assertThat(result, closeTo(expected, 0.1));
    }
}
