package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int col = 0;
        int str = 0;

        for (Integer i : list) {
            if (str == rows) {
                str = 0;
                col++;
            }
            array[col][str] = i;
            str++;
        }
        return array;
    }
}
