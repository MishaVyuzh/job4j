package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 3.08.2019
 */

public class PrimeNumberTest {
    @Test
    public void when5() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(5);
        assertThat(count, is(3));
    }

    @Test
    public void when11() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(11);
        assertThat(count, is(5));
    }

    @Test
    public void when1() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(2);
        assertThat(count, is(1));
    }
    @Test
    public void when101() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(101);
        assertThat(count, is(26));
    }
    @Test
    public void when0() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(0);
        assertThat(count, is(0));
    }
}
