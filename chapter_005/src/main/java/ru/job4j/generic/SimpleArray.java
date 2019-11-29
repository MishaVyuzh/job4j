package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int currentIndex;

    public SimpleArray(T[] array) {
        this.array = array;
        currentIndex = 0;
    }

    void add(T model) {
        if (currentIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[currentIndex++] = model;
    }

    void set(int index, T model) {
        if (this.array[index] == null) {
            add(model);
        } else if (index >= currentIndex) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            this.array[index] = model;
            currentIndex++;
        }
    }

    void remove(int index) {
        if (index >= currentIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(this.array, index + 1, this.array, index, currentIndex - index - 1);
        this.array[currentIndex - 1] = null;
        currentIndex--;
    }

    T get(int index) {
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    T[] getArray() {
        return array;
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
