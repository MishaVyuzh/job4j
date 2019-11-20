package ru.job4j.count;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class CountTest {
    private final Count count = new Count();

    @Test
    public void whenListFrom0To6Then56() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6);
        int result = count.squareEven(numbers);
        int expected = 2 * 2 + 4 * 4 + 6 * 6;

        assertThat(result, is(expected));
    }

    @Test
    public void whenListContainOnlyOddNumbersThen0() {
        List<Integer> numbers = List.of(1, 3, 5);
        int result = count.squareEven(numbers);
        int expected = 0;

        assertThat(result, is(expected));
    }

    @Test
    public void whenListContainsNegativeNumbers() {
        List<Integer> numbers = List.of(0, -1, -2, 3, -4, -5, 6);
        int result = count.squareEven(numbers);
        int expected = 2 * 2 + 4 * 4 + 6 * 6;

        assertThat(result, is(expected));
    }
}
