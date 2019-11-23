package ru.job4j;

import ru.job4j.iterator.MatrixIterator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixIteratorTest {
    private MatrixIterator it;

    @Test
    public void whenArraysContainsFourDifferentLengthBlocksThenOrderFrom1To14() {
        it = new MatrixIterator(new int[][]{{1}, {2, 3, 4, 5,}, {6, 7}, {8, 9, 10, 11, 12, 13, 14}});

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(12));
        assertThat(it.next(), is(13));
        assertThat(it.next(), is(14));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        it = new MatrixIterator(new int[][]{{1, 2}, {3, 4}});

        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }
}
