package ru.job4j.collection.list;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class SimpleStackTest {

    private SimpleStack<Integer> stack = new SimpleStack<>();

    @Before
    public void before() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenPushThenPoll() {
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        stack.push(1);
        stack.poll();
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPollShouldLIFO() {
        int[] actual = new int[3];
        actual[0] = stack.poll();
        actual[1] = stack.poll();
        actual[2] = stack.poll();
        assertThat(actual, is(new int[]{3, 2, 1}));
    }

    @Test
    public void whenPollEmptyStackShouldNull() {
        stack = new SimpleStack<>();
        assertNull(stack.poll());
    }

    @Test
    public void whenPush3ElementsShouldSize3() {
        assertThat(stack.size(), is(3));
    }

    @Test
    public void whenEmptyShouldSize0() {
        stack = new SimpleStack<>();
        assertThat(stack.size(), is(0));
    }

    @Test
    public void when3ElementsShouldGet2ElementByIndexIsOne() {
        assertThat(stack.get(1), is(2));
    }

}
