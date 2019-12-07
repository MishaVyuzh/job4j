package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int currentIndex;

    @SuppressWarnings("unchecked")
    SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    void add(T model) {
        this.array[currentIndex++] = model;
    }

    void set(int index, T model) {
        if (index < currentIndex) {
            array[index] = model;
        }
    }

    void remove(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, currentIndex - index - 1);
        this.array[currentIndex - 1] = null;
        currentIndex--;
    }

    T get(int index) {
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iteratorCount = 0;

            @Override
            public boolean hasNext() {
                return iteratorCount < currentIndex;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[iteratorCount++];
            }
        };
    }
}
