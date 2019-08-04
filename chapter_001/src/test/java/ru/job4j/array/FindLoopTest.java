package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas11ThenNeg1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 11;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
