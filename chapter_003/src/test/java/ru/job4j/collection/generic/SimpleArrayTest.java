package ru.job4j.collection.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SimpleArrayTest {

    @Test
    public void whenAddElementShouldGetSameElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        simpleArray.add(123);
        Integer[] expected = new Integer[] {123};
        Integer[] actual = new Integer[1];
        actual[0] = simpleArray.get(0);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSetElementShouldGetSameElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        Integer expected = 123;
        simpleArray.set(0, expected);
        assertThat(simpleArray.get(0), is(expected));
    }

    @Test
    public void whenAddThreeAndRemoveOneInMiddle() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(123);
        simpleArray.add(456);
        simpleArray.add(789);
        simpleArray.remove(1);
        Integer expected = 10;
        simpleArray.add(expected);
        assertThat(simpleArray.get(2), is(expected));
    }

    @Test
    public void whenAddAndGetUsingIterator() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(123);
        simpleArray.add(456);
        Integer[] expected = new Integer[] {123, 456};
        Integer[] acteal = new Integer[2];
        Iterator<Integer> iterator = simpleArray.iterator();
        acteal[0] = iterator.next();
        acteal[1] = iterator.next();
        assertThat(acteal, is(expected));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementToEmptyArrayShouldException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(0);
        simpleArray.add(123);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddThreeElementsToArrayTwoShouldException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(123);
        simpleArray.add(456);
        simpleArray.add(789);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetByIndexGreaterThenSizeShouldException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.set(5, 123);
    }

    @Test
    public void whenGetByIndexGreaterThenSizeShouldGetNull() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(123);
        assertNull(simpleArray.get(3));
    }

    @Test
    public void whenAddOneAndRemoveOneShouldGetNull() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(123);
        simpleArray.remove(0);
        assertNull(simpleArray.get(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddThenNextUsingIteratorNextTimeGreaterThenSize() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(123);
        simpleArray.add(456);
        simpleArray.add(789);
        Iterator<Integer> iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}
