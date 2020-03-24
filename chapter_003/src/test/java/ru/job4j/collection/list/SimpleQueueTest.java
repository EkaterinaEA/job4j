package ru.job4j.collection.list;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleQueueTest {

    private SimpleQueue<String> queue;

    @Before
    public void before() {
        queue = new SimpleQueue<>();
        queue.push("zero");
        queue.push("one");
        queue.push("two");
    }

    @Test
    public void whenAdd3ShouldSize() {
        assertThat(queue.size(), is(3));
    }

    @Test
    public void whenPollShouldFIFO() {
        String[] actual = new String[3];
        actual[0] = queue.poll();
        actual[1] = queue.poll();
        actual[2] = queue.poll();
        assertThat(actual, is(new String[] {"zero", "one", "two"}));
    }

    @Test
    public void whenAddFIFOShouldFIFO() {
        assertThat(queue.poll(), is("zero"));
        assertThat(queue.poll(), is("one"));
        queue.push("four");
        queue.push("five");
        assertThat(queue.size(), is(3));
        assertThat(queue.poll(), is("two"));
        assertThat(queue.poll(), is("four"));
        assertThat(queue.poll(), is("five"));
        queue.push("six");
        queue.push("seven");
        assertThat(queue.poll(), is("six"));
        assertThat(queue.poll(), is("seven"));
    }

    @Test
    public void whenPollEmptyQueuqShouldNull() {
        queue = new SimpleQueue<>();
        assertNull(queue.poll());
    }

}
