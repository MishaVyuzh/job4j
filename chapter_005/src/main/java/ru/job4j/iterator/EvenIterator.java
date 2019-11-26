package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int index;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
        index = 0;
    }

    private boolean checkEven(int element) {
        return element % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < numbers.length) {
            if (checkEven(numbers[index])) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("The array does not contain even numbers.");
        }

        return numbers[index++];
    }
}