package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#164398$
 * @since 13.09.2019
 */

/**
 * 4. private static final class. Lazy loading.
 */

public class TrackerSinglePrivateStaticFinalClass {

    private TrackerSinglePrivateStaticFinalClass() {

    }

    public static TrackerSinglePrivateStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinalClass INSTANCE = new TrackerSinglePrivateStaticFinalClass();
    }

    public static void main(String[] args) {
        TrackerSinglePrivateStaticFinalClass tracker = TrackerSinglePrivateStaticFinalClass.getInstance();
    }
}

