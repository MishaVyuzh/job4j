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

    private boolean exit = true;

    /**
     * Хранилище заявок.
     */

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        /**
         * Хранилище заявок.
         */
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
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