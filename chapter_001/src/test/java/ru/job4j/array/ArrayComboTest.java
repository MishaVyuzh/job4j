package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 3.09.2019
 */

public class ArrayComboTest {
    @Test
    public void whenA13AndB24ThenResult1234() {
        ArrayCombo arr = new ArrayCombo();
        int[] a = new int[] {1, 3};
        int[] b = new int[] {2, 4};
        int[] result = arr.merge(a, b);
        int[] expected = new int[] {1, 2, 3, 4};
        assertThat(result, is(expected));
    }

    @Test
    public void whenA3AndB24ThenResult1234() {
        ArrayCombo arr = new ArrayCombo();
        int[] a = new int[] {0, 3, 5};
        int[] b = new int[] {-5, 25};
        int[] result = arr.merge(a, b);
        int[] expected = new int[] {-5, 0, 3, 5, 25};
        assertThat(result, is(expected));
    }
}
