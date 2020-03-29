package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class LinkedListTest {

    private LinkedList<String> list;

    @Before
    public void beforeTest() {
        list = new LinkedList<>();
        list.addFirst("zero");
        list.addLast("one");
    }

    @Test
    public void whenGetShouldSame() {
        assertThat(list.getElementByIndex(0), is("zero"));
        assertThat(list.getElementByIndex(1), is("one"));
    }

    @Test
    public void whenUsingIteratorShouldSame() {
        Iterator<String> iterator = this.list.iterator();
        String[] actual = new String[2];
        actual[0] = iterator.next();
        actual[1] = iterator.next();
        assertThat(actual, is(new String[] {"zero", "one"}));
    }

    @Test
    public void whenAddedMoreCapacityShouldIncrease() {
        list.addLast("two");
        list.addLast("tree");
        list.addLast("four");
        list.addLast("five");
        list.addLast("six");
        list.addLast("seven");
        list.addLast("eight");
        list.addLast("nine");
        list.addLast("ten");
        list.addLast("eleven");
        assertThat(list.getElementByIndex(11), is("eleven"));
    }

    @Test
    public void whenUsingIteratorSizeTimesShouldFalse() {
        Iterator<String> iterator = this.list.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenHasNextInEmptyListShouldFalse() {
        LinkedList<String> list = new LinkedList<>();
        Iterator<String> iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmptyListShouldException() {
        LinkedList<String> list = new LinkedList<>();
        assertNull(list.getElementByIndex(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNotAddedShouldException() {
        assertNull(list.getElementByIndex(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNextUsingIteratorMoreSizeTimesShouldException() {
        Iterator<String> iterator = this.list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

}

