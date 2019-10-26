package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int toZero = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++, toZero++) {
                if (toZero < list.size()) {
                    array[i][j] = list.get(toZero);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
