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
    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOfLimit(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }
    @Test
    public void whenFind215() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {15, 7, 1, 215, 4, 0};
        int value = 215;
        int start = 1;
        int finish = 3;
        int result = find.indexOfLimit(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }
    @Test
    public void whenFind100() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {15, 7, 1, 215, 4, 0};
        int value = 100;
        int start = 1;
        int finish = 3;
        int result = find.indexOfLimit(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
