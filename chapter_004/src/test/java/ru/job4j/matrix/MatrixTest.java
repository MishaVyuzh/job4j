package ru.job4j.matrix;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixTest {
    @Test
    public void whenMatrixWithSameLengthRowsThenListLength6() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = new Matrix().convert(matrix);
        assertThat(result, is(expected));
    }

    @Test
    public void whenMatrixWithDifferentLengthRowsThenListLength4() {
        Integer[][] matrix = {{1, 2, 3}, {4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> result = new Matrix().convert(matrix);
        assertThat(result, is(expected));
    }
}
