package ru.job4j.department;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;

public class SortDepartmentTest {
    private SortDepartment sortDepartment = new SortDepartment();

    @Test
    public void whenFillGapsDepartmentThenFirstElemK1() {
        List<String> set = new ArrayList<>();
        List<String> result;

        set.add("K1\\SK1");
        set.add("K1\\SK2");
        set.add("K1\\SK1\\SSK1");
        set.add("K1\\SK1\\SSK2");
        set.add("K2");
        set.add("K2\\SK1\\SSK1");
        set.add("K2\\SK1\\SSK2");
        result = sortDepartment.fillGaps(set);
        assertThat(result.get(0), is("K1"));
    }

    @Test
    public void whenDirectOrderDepartmentThenFirstElemK1() {
        List<String> set = new ArrayList<>();
        List<String> result;

        set.add("K1\\SK1");
        set.add("K1\\SK2");
        set.add("K1\\SK1\\SSK1");
        set.add("K1\\SK1\\SSK2");
        set.add("K2");
        set.add("K2\\SK1\\SSK1");
        set.add("K2\\SK1\\SSK2");
        result = sortDepartment.directOrder(set);
        assertThat(result.get(0), is("K1"));
    }

    @Test
    public void whenReverseOrderDepartmentThenFirstElemK2() {
        List<String> set = new ArrayList<>();
        List<String> result;

        set.add("K1\\SK1");
        set.add("K1\\SK2");
        set.add("K1\\SK1\\SSK1");
        set.add("K1\\SK1\\SSK2");
        set.add("K2");
        set.add("K2\\SK1\\SSK1");
        set.add("K2\\SK1\\SSK2");
        result = sortDepartment.reverseOrder(set);
        assertThat(result.get(0), is("K2"));
    }
}
