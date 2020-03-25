package ru.job4j.collection.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest {

    ForwardLinkedList<Integer> linked;

    @Before
    public void before() {
        linked = new ForwardLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
    }

    @Test
    public void whenAddThenIter() {
        Iterator<Integer> iterator = linked.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        linked.revert();
        Iterator<Integer> iterator = linked.iterator();
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(1));
    }

}
