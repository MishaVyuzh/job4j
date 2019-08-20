package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 19.08.2019
 */

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("#####" + "\r\n")
                                .append("#   #" + "\r\n")
                                .append("#   #" + "\r\n")
                                .append("#   #" + "\r\n")
                                .append("#####")
                                .toString()
                )
        );
    }
}