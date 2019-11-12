package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}
