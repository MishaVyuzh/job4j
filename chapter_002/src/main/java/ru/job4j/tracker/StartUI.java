package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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

    private boolean exit = true;

    /**
     * Хранилище заявок.
     */

    public StartUI(Input input, Tracker tracker) {

        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        /**
         * Хранилище заявок.
         */
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            System.out.println("------------ Меню ------------");
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
                new Tracker()
        ).init();
    }
}