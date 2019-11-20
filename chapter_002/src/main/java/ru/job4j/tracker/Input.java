package ru.job4j.tracker;

import java.util.List;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 15.08.2019
 */

public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);
}
