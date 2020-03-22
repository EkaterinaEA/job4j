package ru.job4j.collection.list;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {

    private SimpleArrayList<String> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add("zero");
        list.add("one");
    }

    @Test
    public void whenGetShouldSame() {
        assertThat(list.get(0), is("zero"));
        assertThat(list.get(1), is("one"));
    }

    @Test
    public void whenUsingIteratorShouldSame() {
        Iterator<String> iterator = this.list.iterator();
        String[] expected = new String[] {"zero", "one"};
        String[] actual = new String[2];
        actual[0] = iterator.next();
        actual[1] = iterator.next();
        assertThat(actual, is(new String[] {"zero", "one"}));
    }

    @Test
    public void whenAddedMoreCapacityShouldIncrease() {
        list.add("two");
        list.add("tree");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");
        assertThat(list.get(11), is("eleven"));
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
    public void whenHasNextInEmptyArrayShouldFalse() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        Iterator<String> iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmptyArrayShouldException() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        assertNull(list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNotAddedShouldException() {
        assertNull(list.get(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextUsingIteratorMoreSizeTimesShouldException() {
        Iterator<String> iterator = this.list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

}
