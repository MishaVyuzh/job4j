package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    @Test
    public void whenAddThreeStringsThenGetSecondElement() {
        SimpleArray<String> integers = new SimpleArray<>(5);
        integers.add("one");
        integers.add("two");
        integers.add("three");
        String expect = integers.get(2);
        assertThat(expect, is("three"));
    }

    @Test
    public void whenAddIntegersThenGetAllNumbers() {
        SimpleArray<Integer> integers = new SimpleArray<>(4);
        integers.add(0);
        integers.add(5);
        integers.add(7);
        Integer expect = 0;
        assertThat(expect, is(integers.get(0)));
    }

    @Test
    public void whenCreateEmptyArraySizeFiveAndAddTwoElementsAndSetThreeElementThenGet0() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
        integers.add(0);
        integers.add(5);
        integers.set(0, 1);
        integers.set(1, 2);
        integers.set(2, 3);
        assertThat(1, is(integers.get(0)));
    }

    @Test
    public void whenCreateEmptyArraySizeFiveAndSetThreeElementThenGet2() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
        integers.set(0, 1);
        integers.set(1, 2);
        integers.set(2, 3);
        assertThat(null, is(integers.get(2)));
    }

    @Test
    public void whenAddFiveIntegersAndRemoveZeroIndexThenGetArray() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.remove(0);
        Integer expect = 5;
        assertThat(expect, is(integers.get(3)));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
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

    @Test
    public void whenAddFiveElementsAndRemoveFourTimesThenGetOnlyOneElement() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.remove(0);
        integers.remove(0);
        integers.remove(0);
        integers.remove(0);
        assertThat(5, is(integers.get(0)));
    }
}
