package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculateTest {

    @Test
    public void outputThreeEchoPlusName() {
        String input = "Misha Vyuzhanin";
        String expect = "Echo, echo, echo : Misha Vyuzhanin";

        Calculate calc = new Calculate();

        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}