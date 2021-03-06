package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSumEvenNumbersFromOneToTenThen() {
        Counter count = new Counter();
        int result = count.add(2, 39);
        int expected = 380;
        assertThat(result, is(expected));
    }
}