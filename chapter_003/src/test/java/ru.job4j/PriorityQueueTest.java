package ru.job4j;

import org.junit.Test;
import ru.job4j.search.PriorityQueue;
import ru.job4j.search.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenSecondComesOut() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("second", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("first", 0));
        Task result = queue.take();
        result = queue.take();
        assertThat(result.getPriority(), is(1));
    }
}

