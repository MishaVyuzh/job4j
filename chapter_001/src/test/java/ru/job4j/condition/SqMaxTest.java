package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class SqMaxTest {
    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int result = check.max(5, 4, 2, 1);
        assertThat(result, is(5));
    }
    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 5, 2, 4);
        assertThat(result, is(5));
    }
    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 4, 5, 2);
        assertThat(result, is(5));
    }
    @Test
    public void whenFourthMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 4, 2, 5);
        assertThat(result, is(5));
    }
}
