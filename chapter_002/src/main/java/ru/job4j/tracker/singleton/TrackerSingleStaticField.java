package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#164398$
 * @since 13.09.2019
 */

/**
 * 2. static field. Lazy loading.
 */

public class TrackerSingleStaticField {
    private static TrackerSingleStaticField instance;

    private TrackerSingleStaticField() {

    }

    public static TrackerSingleStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticField();
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerSingleStaticField tracker = TrackerSingleStaticField.getInstance();
    }
}
