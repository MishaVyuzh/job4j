package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    @Test
    public void whenAddThreeStringsThenGetSecondElement() {
        SimpleArray<String> integers = new SimpleArray<>(new String[5]);
        integers.add("one");
        integers.add("two");
        integers.add("three");
        String expect = integers.get(2);
        assertThat(expect, is("three"));
    }

    @Test
    public void whenAddIntegersThenGetAllNumbers() {
        SimpleArray<Integer> integers = new SimpleArray<>(new Integer[4]);
        integers.add(0);
        integers.add(5);
        integers.add(7);
        Integer[] expect = new Integer[]{0, 5, 7, null};
        assertThat(expect, is(integers.getArray()));
    }

    @Test
    public void whenCreateEmptyArraySizeFiveAndSetThreeElementThenGetArray() {
        SimpleArray<Integer> integers = new SimpleArray<>(new Integer[5]);
        integers.set(0, 1);
        integers.set(1, 2);
        integers.set(2, 3);
        Integer[] expect = new Integer[]{1, 2, 3, null, null};
        assertThat(expect, is(integers.getArray()));
    }

    @Test
    public void whenAddFiveIntegersAndRemoveZeroIndexThenGetArray() {
        SimpleArray<Integer> integers = new SimpleArray<>(new Integer[5]);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.remove(0);
        Integer[] expect = new Integer[]{2, 3, 4, 5, null};
        assertThat(integers.getArray(), is(expect));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        SimpleArray<Integer> integers = new SimpleArray<>(new Integer[5]);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Iterator<Integer> iterator = integers.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
}
