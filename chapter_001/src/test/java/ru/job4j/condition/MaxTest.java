package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax2ToThen1() {
        Max max = new Max();
        int result = max.max(5, 2);
        assertThat(result, is(5));
    }
    @Test
    public void whenMax1EqualThen2() {
        Max max = new Max();
        int result = max.max(7, 7);
        assertThat(result, is(7));
    }
}