package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicContainer<E> implements Iterable<E> {
    private E[] array;
    private int size;
    private int fill;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    DynamicContainer(int size) {
        this.array = (E[]) new Object[size];
        this.size = size;
        fill = 0;
    }

    void add(E element) {
        if (this.fill == this.size) {
            increaseSizeArray();
        }
        array[fill++] = element;
    }

    E get(int index) {
        return (E) array[index];
    }

    private void increaseSizeArray() {
        this.size *= 2;
        this.array = Arrays.copyOf(this.array, this.size);
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;

        return new Iterator<E>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < fill;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else {
                    return array[position++];
                }
            }
        };
    }
}
