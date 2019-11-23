package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {
    private final int[][] arrays;
    private int row, col;

    public MatrixIterator(int[][] arrays) {
        this.arrays = arrays;
    }

    @Override
    public boolean hasNext() {
        return row < arrays.length && col < arrays[row].length;
    }

    @Override
    public Object next() {
        int element = arrays[row][col];
        col++;
        while (row < arrays.length && col >= arrays[row].length) {
            col = 0;
            row++;
        }
        return element;
    }
}
