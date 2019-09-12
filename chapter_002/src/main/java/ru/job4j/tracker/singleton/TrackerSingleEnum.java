package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#164398$
 * @since 13.09.2019
 */

/**
 * 1. enum. Eager loading.
 */

public enum  TrackerSingleEnum {
    INSTANCE;

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
    }
}
