package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 3.09.2019
 */

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        List<Integer> in = new ArrayList<>();
        in.add(1);
        input.ask("Enter", in);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите корректное значение меню.%n")
                )
        );
    }

    @Test
    public void whenChooseExistingMenuItem() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"-1", "1"})
        );
        List<Integer> in = new ArrayList<>();
        in.add(1);
        input.ask("Enter", in);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Выберите существующий пункт меню.%n")
                )
        );
    }
}
