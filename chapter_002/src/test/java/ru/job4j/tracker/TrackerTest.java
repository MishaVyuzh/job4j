package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        Item second = new Item("test2", "testDescription2", created);
        tracker.add(first);
        tracker.add(second);
        String firstId = first.getId();
        tracker.delete(first);
        List<Item> items = tracker.findAll();
        boolean result = true;
        for (Item item : items) {
            if (item.getId().equals(firstId)) {
                result = false;
                break;
            }
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        Item second = new Item("test2", "testDescription2", created);
        tracker.add(first);
        tracker.add(second);
        List<Item> expect = List.of(first, second);
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        Item second = new Item("test2", "testDescription2", created);
        Item third = new Item("test1", "testDescription3", created);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findByName("test1"), is(List.of(first, third)));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        Item second = new Item("test2", "testDescription2", created);
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findById(first.getId()), is(first));
    }
}
