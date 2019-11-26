package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Integer> actual = (new ArrayList<Integer>()).iterator();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !actual.hasNext()) {
                    actual = it.next();
                }
                return actual.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return actual.next();
            }
        };
    }
}
