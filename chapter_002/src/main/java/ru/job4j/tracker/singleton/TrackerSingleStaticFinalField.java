package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#164398$
 * @since 13.09.2019
 */

/**
 * 3. static final field. Eager loading.
 */

public class TrackerSingleStaticFinalField {
    private static final TrackerSingleStaticFinalField INSTANCE = new TrackerSingleStaticFinalField();

    private TrackerSingleStaticFinalField() {}

    public static TrackerSingleStaticFinalField getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinalField tracker = TrackerSingleStaticFinalField.getInstance();
    }
}