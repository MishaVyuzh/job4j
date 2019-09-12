package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#164398$
 * @since 13.09.2019
 */

public class TrackerSingletonTest {

    @Test
    public void trackerEnumTest() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker1, is(tracker1));
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void trackerSingleStaticField() {
        TrackerSingleStaticField tracker1 = TrackerSingleStaticField.getInstance();
        TrackerSingleStaticField tracker2 = TrackerSingleStaticField.getInstance();
        assertThat(tracker1, is(tracker1));
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void trackerSingleStaticFinalField() {
        TrackerSingleStaticFinalField tracker1 = TrackerSingleStaticFinalField.getInstance();
        TrackerSingleStaticFinalField tracker2 = TrackerSingleStaticFinalField.getInstance();
        assertThat(tracker1, is(tracker1));
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void trackerSinglePrivateStaticFinalClass() {
        TrackerSinglePrivateStaticFinalClass tracker1 = TrackerSinglePrivateStaticFinalClass.getInstance();
        TrackerSinglePrivateStaticFinalClass tracker2 = TrackerSinglePrivateStaticFinalClass.getInstance();
        assertThat(tracker1, is(tracker1));
        assertThat(tracker2, is(tracker1));
    }
}
