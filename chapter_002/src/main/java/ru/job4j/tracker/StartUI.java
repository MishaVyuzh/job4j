package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 15.08.2019
 */

public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    private Tracker tracker;
    private final Consumer<String> output;

    private boolean exit = true;

    /**
     * Хранилище заявок.
     */

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {

        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        /**
         * Хранилище заявок.
         */
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions(this);
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            output.accept("------------ Меню ------------");
            menu.show();
            menu.select(input.ask("Введите пункт меню : ", range));
        } while (!"y".equals(this.input.ask("Вы точно хотите выйти?(y): ")));
    }

    public void stop() {
        this.exit = false;
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(),
                System.out::println
        ).init();
    }
}