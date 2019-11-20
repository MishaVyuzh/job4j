package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class EndsWithTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "hello");
        assertThat(result, is(false));
    }
    @Test
    public void whenStartEqualsPrefixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Intellij", "Intellij");
        assertThat(result, is(true));
    }
}