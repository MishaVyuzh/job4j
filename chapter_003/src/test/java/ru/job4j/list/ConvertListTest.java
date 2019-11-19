package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void whenAdd12And3456Then123456() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = List.of(
                1, 2, 3, 4, 5, 6
        );
        List<Integer> expect = convertList.convert(list);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAddFourArrays() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>(List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6},
                new int[]{0, 0, 155},
                new int[]{}
        ));
        List<Integer> result = Arrays.asList(
                1, 2, 3, 4, 5, 6, 0, 0, 155
        );
        List<Integer> expect = convertList.convert(list);
        assertThat(result, is(expect));
    }
}
