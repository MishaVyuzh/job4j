package ru.job4j.count;

import java.util.List;

class Count {
    int squareEven(List<Integer> data) {
        return data.stream().
                filter(i -> i % 2 == 0).
                map(i -> i * i).
                mapToInt(i -> i).
                sum();
    }
}
