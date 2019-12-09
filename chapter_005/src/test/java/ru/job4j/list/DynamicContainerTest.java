package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class DynamicContainerTest {
    private DynamicContainer<String> dc;

    @Before
    public void beforeTest() {
        dc = new DynamicContainer<>(5);
        dc.add("a");
        dc.add("b");
        dc.add("c");
    }

    @Test
    public void whenAddThreeElementsThenGetZeroLetterA() {
        assertThat(dc.get(0), is("a"));
    }

    @Test
    public void whenAddSixElementsThenIncreaseSizeGetNinePositionElementNull() {
        dc.add("d");
        dc.add("e");
        dc.add("f");
        assertNull(dc.get(9));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCallMethodsHasNextAndNext() {
        Iterator it = dc.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("a"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("b"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("c"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
