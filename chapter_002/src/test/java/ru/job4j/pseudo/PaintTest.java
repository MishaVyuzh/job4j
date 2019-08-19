package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 19.08.2019
 */
public class PaintTest {
    // поле содержит стандартный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер, содержащий результат
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void backOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void loadOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("#####")
                                .append("#   #")
                                .append("#   #")
                                .append("#   #")
                                .append("#####")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("     *     ")
                                .append("    * *    ")
                                .append("   *   *   ")
                                .append("  *     *  ")
                                .append(" *       * ")
                                .append("***********")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
